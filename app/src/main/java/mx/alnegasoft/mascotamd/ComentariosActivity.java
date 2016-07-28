package mx.alnegasoft.mascotamd;

import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.security.auth.Subject;

import mx.alnegasoft.mascotamd.R;

public class ComentariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);

        Button btnEnviarComentarios = (Button) findViewById(R.id.btnEnviarComentarios);

        btnEnviarComentarios.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {


                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                StrictMode.setThreadPolicy(policy);

                Properties props = new Properties();

                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                props.setProperty("mail.user", "user");
                props.setProperty("mail.password", "pwd");

                Session mailSession = Session.getInstance(props,null);

                Message msg = new MimeMessage(mailSession);

                TextInputLayout tilNombre = (TextInputLayout) findViewById(R.id.tilNombre);
                TextInputLayout tilCorreo = (TextInputLayout) findViewById(R.id.tilCorreo);
                TextInputLayout tilComentarios = (TextInputLayout) findViewById(R.id.tilComentarios);

                String nombre, correo, mensaje;

                nombre = tilNombre.toString();
                correo = tilCorreo.toString();
                mensaje = tilComentarios.toString();

                //Toast.makeText(getBaseContext(),"1 Correo Enviado..",Toast.LENGTH_SHORT).show();

                try {
                    msg.setSubject("Prueba");
                    msg.setFrom(new InternetAddress(correo, "NEO"));
                    msg.setSubject(nombre);
                    msg.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(correo)});


                    DataHandler dh = new DataHandler(mensaje,"text/plain");
                    try {
                        msg.setDataHandler(dh);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }

                    //Toast.makeText(getBaseContext(),"2 Correo Enviado..",Toast.LENGTH_SHORT).show();

                    try{
                        Transport.send(msg);
                    }catch (MessagingException e) {
                        e.printStackTrace();
                    }


                    Toast.makeText(getBaseContext(),"Correo Enviado..",Toast.LENGTH_SHORT).show();

                }catch(Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }



}
