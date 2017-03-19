package papka.pahan.myfirstapp.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import papka.pahan.myfirstapp.R;
import papka.pahan.myfirstapp.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null) {
            setMainFragment();
        }
    }

    private void setMainFragment() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new MainFragment(), MainFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
