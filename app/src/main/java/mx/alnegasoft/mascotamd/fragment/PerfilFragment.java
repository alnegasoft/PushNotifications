package mx.alnegasoft.mascotamd.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.MainActivity;
import mx.alnegasoft.mascotamd.pojo.Mascota;
import mx.alnegasoft.mascotamd.R;
import mx.alnegasoft.mascotamd.adaptader.PerfilMascotaAdaptador;
import mx.alnegasoft.mascotamd.presenter.IRecyclerViewFragmentPresenter;
import mx.alnegasoft.mascotamd.restApi.ConstantesRestApi;
import mx.alnegasoft.mascotamd.restApi.EndPointsApi;
import mx.alnegasoft.mascotamd.restApi.adapter.RestApiAdapter;
import mx.alnegasoft.mascotamd.restApi.model.MediaResponse;
import mx.alnegasoft.mascotamd.restApi.model.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    String userId = "0";
    String fotoPerfil = "0";
    String nombreCuenta="0";
    View v;
    com.mikhaellopez.circularimageview.CircularImageView circularImageView;
    TextView tvNombreCuenta;

    public PerfilFragment() {
        // Required empty public constructor

    }

//    public PerfilFragment(String userId) {
//        this.userId = userId;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_mascotas, container, false);

        v = inflater.inflate(R.layout.fragment_perfil, container , false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascotas);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaMascotas.setLayoutManager(llm);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);


        obtenerMediaUserId();
//        inicializarListaMascotas();
//        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador(){
        PerfilMascotaAdaptador adaptador = new PerfilMascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);

    }

//    public void mostrarMediaUserIdRV() {
//        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
//        iRecyclerViewFragmentView.generarGridLayout();
//    }



/*    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

*//*        mascotas.add(new Mascota("1", "Pipo", R.drawable.perro1,3));
        mascotas.add(new Mascota("2", "Pulgas", R.drawable.perro3,4));
        mascotas.add(new Mascota("3", "Dory", R.drawable.perro5,1));
        mascotas.add(new Mascota("4", "Coloso",R.drawable.perro4,5));
        mascotas.add(new Mascota("5", "Max",R.drawable.perro2 ,5));*//*
    }*/

    public void obtenerMediaUserId() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaUserId = restApiAdapter.construyeGsonDeserializadorMediaUserId();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaUserId);

        String userId="0";
        if (getArguments() != null) {
            userId = getArguments().get("userId").toString();
            fotoPerfil = getArguments().get("fotoPerfil").toString();
            nombreCuenta = getArguments().get("nombreCuenta").toString();

            circularImageView = (com.mikhaellopez.circularimageview.CircularImageView) v.findViewById(R.id.circularImageView);
            Picasso.with(getContext())
                    .load(fotoPerfil)
                    .placeholder(R.drawable.perro1)
                    .into(circularImageView);

            tvNombreCuenta = (TextView) v.findViewById(R.id.tvNombreCuenta);
            tvNombreCuenta.setText(nombreCuenta);
            //Toast.makeText(getContext(), "Main Activity UserId: "+ userId, Toast.LENGTH_SHORT).show();
            Call<MediaResponse> mediaResponseCall = endPointsApi.getRecentMediaUser(userId);
            //Call<MediaResponse> mediaResponseCall = endPointsApi.getRecentMediaUser();

            mediaResponseCall.enqueue(new Callback<MediaResponse>() {
                @Override
                public void onResponse(Call<MediaResponse> call, Response<MediaResponse> response) {
                    MediaResponse mediaResponse = response.body();
                    mascotas = mediaResponse.getMascotas();
                    inicializarAdaptador();
                }

                @Override
                public void onFailure(Call<MediaResponse> call, Throwable t) {
                    //Toast.makeText(getBaseContext(), "Intenta de nuevo!!!", Toast.LENGTH_SHORT).show();
                    Log.e("FALLO LA CONEXION", t.toString());
                }
            });
        }
    }



}
