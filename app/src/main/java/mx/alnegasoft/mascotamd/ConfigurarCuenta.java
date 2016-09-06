package mx.alnegasoft.mascotamd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.fragment.PerfilFragment;
import mx.alnegasoft.mascotamd.pojo.Mascota;
import mx.alnegasoft.mascotamd.restApi.ConstantesRestApi;
import mx.alnegasoft.mascotamd.restApi.EndPointsApi;
import mx.alnegasoft.mascotamd.restApi.adapter.RestApiAdapter;
import mx.alnegasoft.mascotamd.restApi.model.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfigurarCuenta extends AppCompatActivity {


    private ArrayList<Mascota> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);


        Button btnGuardarCuenta;
        btnGuardarCuenta = (Button) findViewById(R.id.btnGuardarCuenta);

        btnGuardarCuenta.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerUserId();
                //Intent intent = new Intent(this , PerfilFragment.class);
            }
        });


    }


    public void obtenerUserId() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonUserId = restApiAdapter.construyeGsonDeserializadorUserId();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonUserId);

        android.support.design.widget.TextInputLayout tilUsuario;
        tilUsuario = (android.support.design.widget.TextInputLayout) findViewById(R.id.tilUsuario);
        final String nombreUsuario = tilUsuario.getEditText().getText().toString();
        //Toast.makeText(ConfigurarCuenta.this, nombreUsuario, Toast.LENGTH_SHORT).show();

        Call<UserResponse> userResponseCall = endPointsApi.getUserId(nombreUsuario ,ConstantesRestApi.ACCESS_TOKEN );

        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse  userResponse = response.body();
                usuarios =  userResponse.getUsuarios();


               // Toast.makeText(getBaseContext(), "Configurar Cuenta Usuario: " + usuarios.get(0).getId().toString(), Toast.LENGTH_SHORT).show();
               // Toast.makeText(getBaseContext(), "Configurar Cuenta Foto Perfil: " + usuarios.get(0).getUrlFotoPerfil().toString(), Toast.LENGTH_SHORT).show();
               // Toast.makeText(getBaseContext(), "Nombre Cuenta: " + nombreUsuario, Toast.LENGTH_SHORT).show();
                //mostrarContactosRV();

                Intent intent = new Intent(getBaseContext() ,MainActivity.class);
                intent.putExtra("userId",usuarios.get(0).getId().toString());
                intent.putExtra("fotoPerfil",usuarios.get(0).getUrlFotoPerfil().toString());
                intent.putExtra("nombreCuenta",nombreUsuario);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Intenta de nuevo!!!", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });


    }

}
