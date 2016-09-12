package mx.alnegasoft.mascotamd.restApi.deserializador;

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
import mx.alnegasoft.mascotamd.restApi.model.MediaResponse;


/**
 * Created by NEO on 15/08/2016.
 */
public class MediaDeserializador implements JsonDeserializer<MediaResponse> {
    @Override
    public MediaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MediaResponse mediaResponse = gson.fromJson(json,MediaResponse.class);
        JsonArray mediaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mediaResponse.setMascotas(deserializarMediaDeJson(mediaResponseData));

        return mediaResponse;
    }

    private ArrayList<Mascota> deserializarMediaDeJson(JsonArray mediaResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        for (int i = 0; i <mediaResponseData.size() ; i++) {
            JsonObject mediaResponseDataObject       = mediaResponseData.get(i).getAsJsonObject();
            String idFoto                            = mediaResponseDataObject.get(JsonKeys.MEDIA_ID).getAsString();
            JsonObject mediaJson                     = mediaResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id                                = mediaJson.get(JsonKeys.USER_ID).getAsString();
            String profilePicture                    = mediaJson.get(JsonKeys.USER_ID_PROFILE_PICTURE).getAsString();
            String nombre                            = mediaJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson                     = mediaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson             = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto                           = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson                     = mediaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes                                = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Mascota mascotaActual = new Mascota();

            mascotaActual.setIdFoto(idFoto);
            mascotaActual.setId(id);
            mascotaActual.setNombre(nombre);
            mascotaActual.setUrlFoto(urlFoto);
            mascotaActual.setLikes(likes);
            mascotaActual.setUrlFotoPerfil(profilePicture);

            mascotas.add(mascotaActual);

        }
        return mascotas;
    }


}
