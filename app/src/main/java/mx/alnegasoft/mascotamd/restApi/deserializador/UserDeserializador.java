package mx.alnegasoft.mascotamd.restApi.deserializador;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import mx.alnegasoft.mascotamd.pojo.Mascota;
import mx.alnegasoft.mascotamd.restApi.JsonKeys;
import mx.alnegasoft.mascotamd.restApi.model.UserResponse;

/**
 * Created by NEO on 12/08/2016.
 */
public class UserDeserializador implements JsonDeserializer<UserResponse> {
    @Override
    public UserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        UserResponse userResponse = gson.fromJson(json,UserResponse.class);
        JsonArray userResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.USER_RESPONSE_ARRAY);

        userResponse.setUsuarios(deserializarUsuarioDeJson(userResponseData));


        return userResponse;
    }

    private ArrayList<Mascota> deserializarUsuarioDeJson(JsonArray userResponseData){
        ArrayList<Mascota> usuarios = new ArrayList<>();

        for (int i = 0; i <userResponseData.size() ; i++) {
            JsonObject userResponseDataObject       = userResponseData.get(i).getAsJsonObject();
            //JsonObject userJson                         = contactoResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id                                   = userResponseDataObject.get(JsonKeys.USER_RESPONSE_ID).getAsString();
            String profilePicture                       = userResponseDataObject.get(JsonKeys.USER_ID_PROFILE_PICTURE).getAsString();

            //usuarios.add(id);
            Mascota usuarioActual = new Mascota();

            usuarioActual.setId(id);
            usuarioActual.setUrlFotoPerfil(profilePicture);

            usuarios.add(usuarioActual);

        }
        return usuarios;
    }


}
