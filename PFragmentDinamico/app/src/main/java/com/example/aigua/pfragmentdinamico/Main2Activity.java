package com.example.aigua.pfragmentdinamico;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
            //Cargaremos de forma dinámica el TextFragment
            TextFragment firstFragment = new TextFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            //Pasaremos a nuestro firstFragment los parámetros que le pasemos del ListFragment
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            // Se lanza el Fragment Manager para cargar de forma dinámica los fragments
            // Añadirá donde está fragment_container nuestro firstFragment y lo ejecutará

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,firstFragment).commit();

            //En versiones superiores a la API 20 sería getFragmentManager().

        }
    }
}
