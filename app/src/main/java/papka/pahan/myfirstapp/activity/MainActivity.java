package papka.pahan.myfirstapp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import papka.pahan.myfirstapp.R;
import papka.pahan.myfirstapp.fragment.CreatePostFragment;
import papka.pahan.myfirstapp.fragment.MainFragment;
import papka.pahan.myfirstapp.fragment.ViewPostsFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnMainFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null) {
            changeFragment(new MainFragment(), MainFragment.class.getSimpleName(), false);
        }
    }

    private void changeFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tag);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    //region OnMainFragmentInteractionListener
    @Override
    public void openCreatePostFragment() {
        changeFragment(new CreatePostFragment(), CreatePostFragment.class.getSimpleName(), true);
    }

    @Override
    public void openViewPostsFragment() {
        changeFragment(ViewPostsFragment.newInstance("123"), ViewPostsFragment.class.getSimpleName(), true);
    }
    //endregion
}
