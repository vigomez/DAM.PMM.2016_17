package com.example.aigua.pmultiplesdevices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    private String opcion_elegida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextoFragment tFragment = (TextoFragment)getFragmentManager().findFragmentById(R.id.fTexto);

        // Recogemos los datos del primer activity
        Bundle extras = getIntent().getExtras();
        opcion_elegida=extras.getString("item");
        tFragment.setTexto(opcion_elegida);
    }

    //Al vover atrás con el botón por defecto del dispositivo
    //Enviaremos un mensaje a la actividad principal

    @Override
    public void onBackPressed()
    {
        //super.onBackPressed();  // optional depending on your needs
        //Crear un nuevo intent de respuesta
        Intent databack = new Intent();

        //Añadir como Extra la opcion que habíamos elegido
        databack.putExtra("opcion",opcion_elegida);

        //Devolver por el canal de forma exitosa el mensaje del intent
        setResult(RESULT_OK,databack);

        //Terminar la actividad
        finish();
    }
}
