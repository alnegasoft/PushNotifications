package mx.alnegasoft.mascotamd.fragment;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.adaptader.MascotaAdaptador;
import mx.alnegasoft.mascotamd.pojo.Mascota;

/**
 * Created by NEO on 28/07/2016.
 */
public interface IMascotasFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
