package mx.alnegasoft.mascotamd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.R;
import mx.alnegasoft.mascotamd.adaptader.MascotaAdaptador;
import mx.alnegasoft.mascotamd.db.ConstructorBD;
import mx.alnegasoft.mascotamd.fragment.IMascotasFragmentView;
import mx.alnegasoft.mascotamd.pojo.Mascota;
import mx.alnegasoft.mascotamd.presenter.IRecyclerViewFragmentPresenter;
import mx.alnegasoft.mascotamd.presenter.RecyclerViewFragmentPresenter;

public class MascotasVotadas extends AppCompatActivity  {

    private ConstructorBD constructorBD;

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_votadas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasVotadas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);



        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarListaMascotas(){


        constructorBD = new ConstructorBD(this);
        mascotas = constructorBD.obtenerMascotasVotadas();

/*        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(1, "Max",R.drawable.perro2 ,5));
        mascotas.add(new Mascota(2, "Colosso",R.drawable.perro4,5));
        mascotas.add(new Mascota(3, "Pulgas", R.drawable.perro3,4));
        mascotas.add(new Mascota(4, "Firulais", R.drawable.perro1,3));
        mascotas.add(new Mascota(5, "Dory", R.drawable.perro5,1));*/


    }


}
