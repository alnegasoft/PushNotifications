package mx.alnegasoft.mascotamd.pojo;

/**
 * Created by NEO on 11/07/2016.
 */
public class Mascota {

    private int id;
    private String nombre;
    private int foto;
    private int raiting;

    public Mascota(int id, String nombre, int foto, int raiting) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.raiting = raiting;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
