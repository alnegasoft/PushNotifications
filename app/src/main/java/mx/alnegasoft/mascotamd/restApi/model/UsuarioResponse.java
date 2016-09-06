package mx.alnegasoft.mascotamd.restApi.model;

/**
 * Created by NEO on 05/09/2016.
 */
public class UsuarioResponse {

    private String id;
    private String id_dispositivo;
    private String id_instagram;

    public UsuarioResponse(String id, String id_dispositivo, String id_instagram) {
        this.id = id;
        this.id_dispositivo = id_dispositivo;
        this.id_instagram = id_instagram;
    }

    public UsuarioResponse() {
    }

    public String getId() {
        return id;
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