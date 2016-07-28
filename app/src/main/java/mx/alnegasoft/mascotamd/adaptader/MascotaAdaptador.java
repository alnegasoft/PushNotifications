package mx.alnegasoft.mascotamd.adaptader;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.db.ConstructorBD;
import mx.alnegasoft.mascotamd.pojo.Mascota;
import mx.alnegasoft.mascotamd.R;

/**
 * Created by ABITA on 12/07/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaAdaptador(ArrayList<Mascota> mascotas ,  Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }




    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview , parent , false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        final ConstructorBD constructorBD = new ConstructorBD(activity);
        mascotaViewHolder.ivFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        //mascotaViewHolder.tvRaiting.setText(Integer.toString(mascota.getRaiting()));
        mascotaViewHolder.tvRaiting.setText(String.valueOf(constructorBD.obtenerLikesMascota(mascota)));

        mascotaViewHolder.btnRaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity , "Gracias por votar por: " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();

                //ConstructorBD constructorBD = new ConstructorBD(activity);
                constructorBD.darLikeMascota(mascota);

                mascotaViewHolder.tvRaiting.setText(String.valueOf(constructorBD.obtenerLikesMascota(mascota)));


//                int raiting;
//                raiting = mascota.getRaiting()+1;
//                mascota.setRaiting(raiting);
//                mascotaViewHolder.tvRaiting.setText(Integer.toString(raiting));

            }
        });


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
     }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFoto;
        private Button btnRaiting;
        private TextView tvNombre;
        private TextView tvRaiting;
        private Button btnRaitingAcum;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            ivFoto          = (ImageView) itemView.findViewById(R.id.ivFoto);
            btnRaiting      = (Button) itemView.findViewById(R.id.btnRaiting);
            tvNombre        = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRaiting       = (TextView) itemView.findViewById(R.id.tvRaiting);
            btnRaitingAcum  = (Button) itemView.findViewById(R.id.btnRaitingAcum);


        }
    }

}
