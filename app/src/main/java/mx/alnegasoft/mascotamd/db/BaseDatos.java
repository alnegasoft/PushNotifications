package mx.alnegasoft.mascotamd.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.pojo.Mascota;

/**
 * Created by NEO on 28/07/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTA + "(" +
                                        ConstantesBD.TABLE_MASCOTA_ID       + " INTEGER PRIMARY KEY, " +
                                        ConstantesBD.TABLE_MASCOTA_NOMBRE   + " TEXT, " +
                                        ConstantesBD.TABLE_MASCOTA_FOTO     + " INTEGER " +
                                        ")";


        String queryCrearTablaMascotaLikes = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTA_LIKES + "(" +
                                            ConstantesBD.TABLE_MASCOTA_LIKES_ID             + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            ConstantesBD.TABLE_MASCOTA_LIKES_ID_MASCOTA     + " INTEGER, " +
                                            ConstantesBD.TABLE_MASCOTA_LIKES_NUMLIKES       + " INTEGER, " +
                                            "FOREIGN KEY (" + ConstantesBD.TABLE_MASCOTA_LIKES_ID_MASCOTA + ")" +
                                            "REFERENCES " + ConstantesBD.TABLE_MASCOTA + "(" + ConstantesBD.TABLE_MASCOTA_ID + ")" +
                                            ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaMascotaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST" + ConstantesBD.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST" + ConstantesBD.TABLE_MASCOTA_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getString(0));
            mascotaActual.setNombre(registros.getString(1));
            //mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBD.TABLE_MASCOTA_LIKES_NUMLIKES +") as likes " +
                    " FROM " + ConstantesBD.TABLE_MASCOTA_LIKES +
                    " WHERE " + ConstantesBD.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;

    }




    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTA_LIKES, null, contentValues);
        db.close();
    }


    public int obtenerLikesMascota(Mascota mascota){

        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBD.TABLE_MASCOTA_LIKES_NUMLIKES + ")" +
                " FROM " + ConstantesBD.TABLE_MASCOTA_LIKES +
                " WHERE " + ConstantesBD.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query , null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;

    }


    public ArrayList<Mascota> cincoMascotasMasVotadas(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query =   "SELECT * FROM (SELECT * , (SELECT Count(" + ConstantesBD.TABLE_MASCOTA_LIKES_NUMLIKES +
                                        ") as likes FROM " + ConstantesBD.TABLE_MASCOTA_LIKES +
                                            " WHERE " + ConstantesBD.TABLE_MASCOTA_LIKES_ID_MASCOTA +
                                            " = a." +  ConstantesBD.TABLE_MASCOTA_ID + ") as likes" +
                        " FROM " + ConstantesBD.TABLE_MASCOTA + " a) ORDER BY likes DESC LIMIT 0,5";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);


        while (registros.moveToNext()){

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getString(0));
            mascotaActual.setNombre(registros.getString(1));
            //mascotaActual.setFoto(registros.getInt(2));

/*            String queryLikes = "SELECT COUNT(" + ConstantesBD.TABLE_MASCOTA_LIKES_NUMLIKES +") as likes " +
                    " FROM " + ConstantesBD.TABLE_MASCOTA_LIKES +
                    " WHERE " + ConstantesBD.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setRaiting(registrosLikes.getInt(0));
            }else {
                mascotaActual.setRaiting(0);
            }*/

            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }


}
