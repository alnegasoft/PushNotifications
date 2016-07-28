package mx.alnegasoft.mascotamd.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.R;
import mx.alnegasoft.mascotamd.pojo.Mascota;

/**
 * Created by NEO on 28/07/2016.
 */
public class ConstructorBD {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorBD(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerMascotasVotadas(){
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.cincoMascotasMasVotadas();
    }



    /*    mascotas.add(new Mascota(id, "Firulais", R.drawable.perro1,3));
        mascotas.add(new Mascota(id, "Pulgas", R.drawable.perro3,4));
        mascotas.add(new Mascota(id, "Dory", R.drawable.perro5,1));
        mascotas.add(new Mascota(id, "Colosso",R.drawable.perro4,5));
        mascotas.add(new Mascota(id, "Max",R.drawable.perro2 ,5));*/

    public void insertarMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID, 1);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Firulais");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID, 2);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Pulgas");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID, 3);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Dory");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID, 4);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Colosso");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID, 5);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Max");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro5);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID, 6);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Puppy");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID, 7);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Terry");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID, 8);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Blu");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro5);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID, 9);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE, "Lalo");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro1);
        db.insertarMascota(contentValues);

    }

    public void darLikeMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES_NUMLIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }


    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }



}
