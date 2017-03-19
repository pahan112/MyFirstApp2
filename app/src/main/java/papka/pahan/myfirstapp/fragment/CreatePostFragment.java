package papka.pahan.myfirstapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import papka.pahan.myfirstapp.R;
import papka.pahan.myfirstapp.api.RetrofitMain;
import papka.pahan.myfirstapp.model.CreatePostRequest;
import papka.pahan.myfirstapp.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by admin on 14.03.2017.
 */

public class CreatePostFragment extends Fragment {

    @BindView(R.id.et_id_create_post)
    EditText mIdCreatePostEditText;
    @BindView(R.id.et_title_create_post)
    EditText mEtTitleCreatePost;
    @BindView(R.id.et_body_create_post)
    EditText mEtBodyCreatePost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_post, null);
        ButterKnife.bind(this, view);
        return view;
    }

    private void createPost() {
        Call<Post> createPost = RetrofitMain.getApiInterface().createPost(createPostRequest());
        createPost.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getActivity(), response.body().getTitle(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private CreatePostRequest createPostRequest() {
        CreatePostRequest createPostRequest1 = new CreatePostRequest();
        createPostRequest1.setUserId(Integer.parseInt(mIdCreatePostEditText.getText().toString()));
        createPostRequest1.setTitle(mEtTitleCreatePost.getText().toString());
        createPostRequest1.setBody(mEtBodyCreatePost.getText().toString());
        return createPostRequest1;
    }

    @OnClick(R.id.btn_ok_create_post)
    public void onClick() {
        if (mIdCreatePostEditText.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Enter at least one characters Id", Toast.LENGTH_LONG).show();
        } else if (mEtTitleCreatePost.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Enter at least five characters Title", Toast.LENGTH_LONG).show();
        } else {
            createPost();
        }
    }
}
