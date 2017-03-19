package papka.pahan.myfirstapp.activity;

import android.app.Fragment;
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
        Fragment mainFragment = new MainFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frgmCont, mainFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
