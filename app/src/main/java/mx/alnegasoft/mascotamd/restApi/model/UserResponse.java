package mx.alnegasoft.mascotamd.restApi.model;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.pojo.Mascota;

/**
 * Created by NEO on 12/08/2016.
 */
public class UserResponse {

    ArrayList<Mascota> usuarios;

    public ArrayList<Mascota> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Mascota> usuarios) {
        this.usuarios = usuarios;
    }

}
