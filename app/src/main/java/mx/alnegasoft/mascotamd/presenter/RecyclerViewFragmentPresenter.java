package mx.alnegasoft.mascotamd.presenter;

import android.content.Context;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.db.ConstructorBD;
import mx.alnegasoft.mascotamd.fragment.IMascotasFragmentView;
import mx.alnegasoft.mascotamd.pojo.Mascota;

/**
 * Created by NEO on 28/07/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private ConstructorBD constructorBD;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context) {
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorBD = new ConstructorBD(context);
        mascotas = constructorBD.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotasFragmentView.inicializarAdaptadorRV(iMascotasFragmentView.crearAdaptador(mascotas));
        iMascotasFragmentView.generarLinearLayoutVertical();
    }
}
