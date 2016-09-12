package mx.alnegasoft.mascotamd;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import java.util.ArrayList;

import mx.alnegasoft.mascotamd.pojo.Mascota;
import mx.alnegasoft.mascotamd.restApi.ConstantesRestApi;
import mx.alnegasoft.mascotamd.restApi.EndPointsApi;
import mx.alnegasoft.mascotamd.restApi.adapter.RestApiAdapter;
import mx.alnegasoft.mascotamd.restApi.model.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NEO on 02/09/2016.
 */
public class NotificationService extends FirebaseMessagingService {

    public static final String TAG = "FIREBASE";
    String nombreUsuario    = "";
    String userId           = "";
    String fotoPerfil       = "";
    private Mascota usuarioLike;
    ArrayList<Mascota> usuarios;
    Intent i;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());


        i = new Intent(this, MainActivity.class);

        if (remoteMessage.getData().size() > 0) {


            Log.d(TAG, "Datos: " + remoteMessage.getData());

            usuarioLike =  new Mascota();

            userId = remoteMessage.getData().get("id_instagram");
            nombreUsuario = remoteMessage.getData().get("nombre_usuario");
            fotoPerfil= remoteMessage.getData().get("url_foto_perfil");

            i.putExtra("userId",userId);
            i.putExtra("nombreCuenta",nombreUsuario);
            i.putExtra("fotoPerfil",fotoPerfil);

//            i.putExtra("userId","3671713044");
//            i.putExtra("fotoPerfil","https://scontent.cdninstagram.com/t51.2885-19/s150x150/14033496_1668478746806697_667474009_a.jpg");
//            i.putExtra("nombreCuenta","mi_lucho_xd");
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("Notificación")
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                ;

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification.build());


    }


}
