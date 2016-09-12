package mx.alnegasoft.mascotamd.restApi.model;

/**
 * Created by NEO on 05/09/2016.
 */
public class UsuarioResponse {

    private String id;
    private String id_dispositivo;
    private String id_instagram;
    private String id_foto;
    private String foto_likes;

    public UsuarioResponse(String id, String id_dispositivo, String id_instagram, String id_foto, String foto_likes) {
        this.id = id;
        this.id_dispositivo = id_dispositivo;
        this.id_instagram = id_instagram;
        this.id_foto = id_foto;
        this.foto_likes = foto_likes;
    }

    public UsuarioResponse() {
    }

    public String getId() {
        return id;
    }

    public String getId_foto() {
        return id_foto;
    }

    public void setId_foto(String id_foto) {
        this.id_foto = id_foto;
    }

    public String getFoto_likes() {
        return foto_likes;
    }

    public void setFoto_likes(String foto_likes) {
        this.foto_likes = foto_likes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getId_instagram() {
        return id_instagram;
    }

    public void setId_instagram(String id_instagram) {
        this.id_instagram = id_instagram;
    }
}