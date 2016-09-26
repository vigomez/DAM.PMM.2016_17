package com.example.aigua.llamadamapa;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Boton que en el interface al apretarlo nos lleva a Google MAps
        //Para que funcione en emulación debemos tener un emulador con APIS de Google

        //Generamos el listener del boton Lanzar Mapa

        //Recogemos en un objeto Button nuestro botón
        final Button button = (Button) findViewById(R.id.button);

        //Programamos un listener para saber cuando se aprieta el botón

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Generamos la Uri para la llamada Intent implícita usando método Uri.parse
                Uri direccion= Uri.parse("geo:0,0?q=Catarroja");
                //Llamada a Maps una vez apretado el botón
                //Intent implícito Intent(String action, Uri uri)
                //Para mapas, action es ACTION_VIEW, es una cte del método Intent, Intent.ACTION_VIEW
                //La Uri cosultar opciones para mapas, se pone entre comillas
                Intent llamada = new Intent(Intent.ACTION_VIEW,direccion);

                //Otra opcion
                //Intent setData (Uri data): Set the data this intent is operating on.
                /*
                Intent llamada = new Intent(Intent.ACTION_VIEW);
                llamada.setData(direccion);
                if (llamada.resolveActivity(getPackageManager()) != null) {
                    startActivity(llamada);
                }
                */


                startActivity(llamada);
            }
        });


    }
}
