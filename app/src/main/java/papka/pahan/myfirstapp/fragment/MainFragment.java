package papka.pahan.myfirstapp.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import papka.pahan.myfirstapp.R;

/**
 * Created by admin on 17.03.2017.
 */

public class MainFragment extends Fragment {

    private Fragment createPostFragment;
    private Fragment viewPostFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        createPostFragment = new CreatePostFragment();
        viewPostFragment = new ViewPostFragment();
        fragmentTransaction = getFragmentManager().beginTransaction();
        return view;
    }

    @OnClick(R.id.btn_view_posts)
    public void onClickView() {
        fragmentTransaction.replace(R.id.frgmCont, viewPostFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.btn_create_post)
    public void onClickCreate() {
        fragmentTransaction.replace(R.id.frgmCont, createPostFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
