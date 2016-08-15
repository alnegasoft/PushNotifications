package mx.alnegasoft.mascotamd.restApi;

import mx.alnegasoft.mascotamd.R;
import mx.alnegasoft.mascotamd.restApi.model.MediaResponse;
import mx.alnegasoft.mascotamd.restApi.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ABITA on 12/08/2016.
 */
public interface EndPointsApi {


    @GET(ConstantesRestApi.KEY_USERS_SEARCH)
    Call<UserResponse> getUserId(@Query("q") String q ,@Query("access_token") String at);

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_ID)
    Call<MediaResponse> getRecentMediaUser(@Path("userid") String userid);
    //Call<MediaResponse> getRecentMediaUser();


    //users/3648605337/media/recent/?access_token=3648605337.bef215d.5a54ae5f797a4ec2b2b2fef2df1f5832

    //users/3648605337/media/recent/?access_token=3648605337.bef215d.5a54ae5f797a4ec2b2b2fef2df1f5832
    //public static final String URL_GET_USER_ID = KEY_USERS_SEARCH + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


/*    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);
    "q={nombre}&access_token=3648605337.9793ffe.823c3055a691442f94e08157e7c6fa34"*/
    //@GET("group/{id}/users")
    //Call<List<User>> groupList(@Path("id") int groupId);


//https://api.instagram.com/v1/users/search?q=alnegasoft&access_token=3648605337.9793ffe.823c3055a691442f94e08157e7c6fa34

}
