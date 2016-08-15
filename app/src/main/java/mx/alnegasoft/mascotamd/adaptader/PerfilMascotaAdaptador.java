package mx.alnegasoft.mascotamd.adaptader;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.pojo.Mascota;
import mx.alnegasoft.mascotamd.R;

/**
 * Created by NEO on 12/07/2016.
 */
public class PerfilMascotaAdaptador extends RecyclerView.Adapter<PerfilMascotaAdaptador.PerfilMascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;


    public PerfilMascotaAdaptador(ArrayList<Mascota> mascotas , Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }




    @Override
    public PerfilMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil , parent , false);
        return new PerfilMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PerfilMascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        //mascotaViewHolder.ivFotoPerfil.setImageResource(mascota.getFoto());
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.perro1)
                .into(mascotaViewHolder.ivFotoPerfil);

        //mascotaViewHolder.tvNombrePerfil.setText(mascota.getNombre());
        mascotaViewHolder.tvRaitingPerfil.setText(Integer.toString(mascota.getLikes()));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilMascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFotoPerfil;
        private TextView tvNombrePerfil;
        private TextView tvRaitingPerfil;



        public PerfilMascotaViewHolder(View itemView) {
            super(itemView);
            ivFotoPerfil          = (ImageView) itemView.findViewById(R.id.ivFotoPerfil);
            tvNombrePerfil        = (TextView) itemView.findViewById(R.id.tvNombrePerfil);
            tvRaitingPerfil       = (TextView) itemView.findViewById(R.id.tvRaitingPerfil);

        }
    }

}
