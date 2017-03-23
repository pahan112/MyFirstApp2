package papka.pahan.myfirstapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    private OnMainFragmentInteractionListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMainFragmentInteractionListener) {
            mListener = (OnMainFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnMainFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_create_post)
    public void onClickCreate() {
        mListener.openCreatePostFragment();
    }

    @OnClick(R.id.btn_view_posts)
    public void onClickView() {
        mListener.openViewPostsFragment();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnMainFragmentInteractionListener {
        void openCreatePostFragment();

        void openViewPostsFragment();
    }
}
