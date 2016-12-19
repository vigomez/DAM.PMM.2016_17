package com.example.aigua.pmultiplesdevices;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MenuFragment.ListFragmentListener {


    public final static int BACK_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Checkamos si estamos en un dispositivo grande o no
        if (findViewById(R.id.fragment_container) != null) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            // Cargamos el fragment del texto
            TextoFragment text = new TextoFragment();
            //CApturamos el cargador dinámico
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            // Reemplazamos la noticia
            transaction.replace(R.id.fragment_container, text);
            transaction.addToBackStack(null);
            // REalizamos el reemplazo
            transaction.commit();
        }
    }


    @Override
    public void onListSelected(int position, String item) {
        //Checkamos si estamos en un dispositivo grande o no
        if (findViewById(R.id.fragment_container) != null) {
            // Cargamos el fragment del texto
            TextoFragment text = new TextoFragment();
            Bundle args = new Bundle();
            args.putString(TextoFragment.ARG_TEXTO, item);
            text.setArguments(args);
            //CApturamos el cargador dinámico
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            // Reemplazamos el texto
            transaction.replace(R.id.fragment_container, text);
            transaction.addToBackStack(null);
            // REalizamos el reemplazo
            transaction.commit();


        }else{//Dispositivo pequeño
            Intent mainIntent = new Intent(this,Main2Activity.class);
            mainIntent.putExtra("item", item);
            //startActivity(mainIntent);
            //Esperando que la otra actividad nos devuelva información
            //BACK_CODE:codigo identificador de la recepción
            startActivityForResult(mainIntent,BACK_CODE);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == BACK_CODE) {

            if (resultCode == RESULT_OK) {

                String result = data.getStringExtra("opcion");
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Habias elegido "+result, Toast.LENGTH_SHORT);

                toast1.show();


            }
        }
    }

}