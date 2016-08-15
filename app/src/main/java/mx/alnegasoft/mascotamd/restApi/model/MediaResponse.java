package mx.alnegasoft.mascotamd.restApi.model;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.pojo.Mascota;

/**
 * Created by ABITA on 15/08/2016.
 */
public class MediaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }



}
