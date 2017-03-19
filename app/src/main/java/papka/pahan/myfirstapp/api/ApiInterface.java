package papka.pahan.myfirstapp.api;

import java.util.List;

import papka.pahan.myfirstapp.global.Constants;
import papka.pahan.myfirstapp.model.CreatePostRequest;
import papka.pahan.myfirstapp.model.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by admin on 14.03.2017.
 */

public interface ApiInterface {
    @GET("posts")
    Call<List<Post>> getPosts(@Query(Constants.PATH_PARAM_USER_ID) String userId);

    @POST("posts")
    Call<Post> createPost(@Body CreatePostRequest createPostRequest);
}
