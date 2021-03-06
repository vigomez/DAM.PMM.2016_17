package com.example.aigua.pfragment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            TextoFragment firstFragment = new TextoFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            /*Si el .java que implementa el fragment, TextoFragment declara
            public class TextoFragment extends Fragment
            Habría que usar
            getSupportFragmentManager().beginTransaction()
            .add(R.id.fragment_container, firstFragment).commit();
            Para usar la siguiente opcion y dado que estamos en una appCompatActivity
            hay que declarar
            public class TextoFragment extends android.app.Fragment
            Esto también puede depender de la API utilizada*/

            getFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }
    }
}