package com.example.aigua.pjuegorava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RavaActivity extends AppCompatActivity implements BotonesFragment.OnFragmentBotonListener{
        LetrasFragment lFragment;
        PuntuacionFragment pFragment;
        BotonesFragment bFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rava);

            lFragment = (LetrasFragment)
                    getFragmentManager().findFragmentById(R.id.letras_fragment);
            pFragment = (PuntuacionFragment)
                    getFragmentManager().findFragmentById(R.id.puntuacion_fragment);
            bFragment = (BotonesFragment)
                    getFragmentManager().findFragmentById(R.id.botones_fragment);
        }

        @Override
        public void onFragmentInteraction(int color) {
            //Comprobacion con el color del fragment de las letras
            if(lFragment.checkColor(color)) pFragment.addPuntuacion();
            //Barajamos colores y letra indipendientemente del resultado
            bFragment.barajarColores();
            //Cambiamos letras
            lFragment.cambiaLetras();

        }
    }
