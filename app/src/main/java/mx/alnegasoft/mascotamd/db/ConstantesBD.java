package mx.alnegasoft.mascotamd.db;

/**
 * Created by NEO on 28/07/2016.
 */
public class ConstantesBD {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    //private String nombre;
    //private int foto;
    //private int raiting;

    public  static final String TABLE_MASCOTA           = "mascota";
    public  static final String TABLE_MASCOTA_ID        = "id";
    public  static final String TABLE_MASCOTA_NOMBRE    = "nombre";
    public  static final String TABLE_MASCOTA_FOTO      = "foto";

    public  static final String TABLE_MASCOTA_LIKES             = "mascota_likes";
    public  static final String TABLE_MASCOTA_LIKES_ID          = "id";
    public  static final String TABLE_MASCOTA_LIKES_ID_MASCOTA  = "id_mascota";
    public  static final String TABLE_MASCOTA_LIKES_NUMLIKES    = "mascota";

}
