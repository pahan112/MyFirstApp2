package papka.pahan.myfirstapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import papka.pahan.myfirstapp.R;
import papka.pahan.myfirstapp.adapter.PostAdapter;
import papka.pahan.myfirstapp.api.RetrofitMain;
import papka.pahan.myfirstapp.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 14.03.2017.
 */

public class ViewPostsFragment extends Fragment {

    private static final String ARG_ID = "ARG_ID";

    @BindView(R.id.et_id_view_post)
    EditText mUserIdEditText;
    @BindView(R.id.rv_posts)
    RecyclerView mPostListRecyclerView;

    private String mId;

    private PostAdapter mPostAdapter;
    private List<Post> mPostList = new ArrayList<>();

    public static ViewPostsFragment newInstance(String id) {
        ViewPostsFragment fragment = new ViewPostsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mId = getArguments().getString(ARG_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_post, null);
        ButterKnife.bind(this, view);
        mUserIdEditText.setText(mId);
        mPostListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mPostAdapter = new PostAdapter(mPostList);
        mPostListRecyclerView.setAdapter(mPostAdapter);
        return view;
    }

    private void getPost() {
        String userId = mUserIdEditText.getText().toString();
        Call<List<Post>> getPostsCB = RetrofitMain.getApiInterface().getPosts(userId);
        getPostsCB.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    mPostList.clear();
                    mPostList.addAll(response.body());
                    mPostAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.bt_create_post)
    public void onClick() {
        getPost();
    }
}
