package mx.alnegasoft.mascotamd.restApi.deserializador;

import android.util.Log;

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
 * Created by NEO on 08/09/2016.
 */
public class UsersTimelineDeserializador implements JsonDeserializer<UserResponse> {
    @Override
    public UserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        UserResponse userResponse = gson.fromJson(json,UserResponse.class);
        JsonArray userResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.USER_RESPONSE_ARRAY);

        userResponse.setUsuarios(deserializarUsuariosDeJson(userResponseData));

        return userResponse;


    }

    private ArrayList<Mascota> deserializarUsuariosDeJson(JsonArray userResponseData){
        ArrayList<Mascota> usuarios = new ArrayList<>();

        for (int i = 0; i <userResponseData.size() ; i++) {

            JsonObject userResponseDataObject       = userResponseData.get(i).getAsJsonObject();
            String id                                   = userResponseDataObject.get(JsonKeys.USER_RESPONSE_ID).getAsString();

            Mascota usuarioActual = new Mascota();

            usuarioActual.setId(id);

            usuarios.add(usuarioActual);

        }
        return usuarios;
    }

}
