package mx.alnegasoft.mascotamd.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.pojo.Mascota;
import mx.alnegasoft.mascotamd.R;
import mx.alnegasoft.mascotamd.adaptader.MascotaAdaptador;
import mx.alnegasoft.mascotamd.presenter.IRecyclerViewFragmentPresenter;
import mx.alnegasoft.mascotamd.presenter.RecyclerViewFragmentPresenter;


public class MascotasFragment extends Fragment implements IMascotasFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

/*
    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }*/


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_mascotas, container, false);

        View v = inflater.inflate(R.layout.fragment_mascotas, container , false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        presenter = new RecyclerViewFragmentPresenter(this , getContext());

        return v;
    }

/*    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);

    }*/

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

/*    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(id, "Firulais", R.drawable.perro1,3));
        mascotas.add(new Mascota(id, "Pulgas", R.drawable.perro3,4));
        mascotas.add(new Mascota(id, "Dory", R.drawable.perro5,1));
        mascotas.add(new Mascota(id, "Colosso",R.drawable.perro4,5));
        mascotas.add(new Mascota(id, "Max",R.drawable.perro2 ,5));
    }*/


}
