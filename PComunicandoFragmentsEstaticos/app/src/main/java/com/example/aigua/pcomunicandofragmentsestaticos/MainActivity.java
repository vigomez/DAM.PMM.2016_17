package com.example.aigua.pcomunicandofragmentsestaticos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements IzquierdaFragment.OnFragmentInteractionListener,DerechaFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //En el Fragment se define la plantilla de onFragmentInteraction
    //En el Activity se define la lógica.
    //pos identifica Fragment: 0 derecha, 1 izquierda
    //Si es 0, el fragment de la izquierda interactuará sobre el de la derecha pasándole
    //el texto, mensage, de la izquierda a la derecha; y viceversa
    @Override
    public void onFragmentInteraction(int pos,String mensage) {
        Log.i("MENSAJE FRAGMENT: ",mensage);
        //Cambiamos mensaje de la dercha
        //En versiones superiores a API 20 es: getFragmentManager() para encontrar fragment
        if(pos==0){
            DerechaFragment derecha = (DerechaFragment)
                    getSupportFragmentManager().findFragmentById(R.id.drcha_fragment);
            //utilizamos el método ontext implementado en el fragment
            derecha.onText(mensage);
        }else{
            IzquierdaFragment izqda = (IzquierdaFragment)
                    getSupportFragmentManager().findFragmentById(R.id.izda_fragment);
            izqda.onText(mensage);
        }
    }
}
