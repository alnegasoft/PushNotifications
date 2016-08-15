package mx.alnegasoft.mascotamd.pojo;

/**
 * Created by NEO on 11/07/2016.
 */
public class Mascota {

    private String id;
    private String nombre;
    private String urlFoto;
    private int likes = 0;
    private String urlFotoPerfil;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Mascota(String id, String nombre, String urlFoto, int likes, String urlFotoPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.likes = likes;
        this.urlFotoPerfil = urlFotoPerfil;
    }

    public Mascota() {

    }


    public String getUrlFotoPerfil() {
        return urlFotoPerfil;
    }

    public void setUrlFotoPerfil(String urlFotoPerfil) {
        this.urlFotoPerfil = urlFotoPerfil;
    }
}
