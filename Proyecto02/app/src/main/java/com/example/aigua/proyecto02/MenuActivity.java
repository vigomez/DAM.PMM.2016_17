package com.example.aigua.proyecto02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //En primer lugar definimos el Array de Strings y lo convertimos a una Lista, en este caso ArrayList
        //opciones del menu
        String[] opcionesMenu = new String[] { "PERFIL", "JUEGO", "INSTRUCCIONES",
                "INFORMACION" };
        //Lo convertimos en una lista
        ArrayList<String>  listaMenu= new ArrayList<String>(Arrays.asList(opcionesMenu));

        //En segundo lugar enchufamos la lista al Adaptador
        //ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaSO);

        //Utilizamos nuestro Adapter customizado
        MenuAdapter adapter =  new MenuAdapter(this,listaMenu);

        //Por último enchufamos el adaptador a la Vista que es el ListView
        //INTERFAZ o la VISION
        final ListView listview= (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);

    }
}