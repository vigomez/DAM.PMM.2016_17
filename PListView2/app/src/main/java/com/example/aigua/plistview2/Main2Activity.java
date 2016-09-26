package com.example.aigua.plistview2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Recuperamos la información pasada por la primera actividad
        Intent intent=getIntent(); //Recuperamos el intent que pasa el mensaje
        String item= intent.getStringExtra("so"); //en getStringExtra, la etiqueta "so"

        //Mostramos el mensaje recibido de la primera actividad
        Toast.makeText(Main2Activity.this,item,Toast.LENGTH_LONG).show();
    }
}