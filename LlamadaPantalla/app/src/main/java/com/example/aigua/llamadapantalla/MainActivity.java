package com.example.aigua.llamadapantalla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //MainActivity mActivity=this; //Creamos referencia para poderla pasar a Intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generar el listener del botón
        //El nombre por defecto del botón es button. Verlos activity_main.xml
        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click:llamada a la segunda pantalla
                //Intent(contexto, a quien se llama)
                //Llamamos desde MainActivity (referencia MainActivity) a SecondActivity

                //Intent llamada = new Intent(mActivity,SecondActivity.class);

                //Otra posibilidad es hacer directamente, sin necesidad de usar una referencia
                Intent llamada = new Intent(MainActivity.this,SecondActivity.class);

                startActivity(llamada);


            }
        });
    }
}
