package com.example.aigua.plistview2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //En primer lugar definimos el Array de Strings y lo convertimos a una Lista, en este caso ArrayList
        //DATOS
        String[] sistemasOperativos = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };
        //Lo convertimos en una lista
        ArrayList<String> listaSO = new ArrayList<String>(Arrays.asList(sistemasOperativos));

        //En segundo lugar enchufamos la lista al Adaptador
        //ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaSO);

        //Utilizamos nuestro Adapter customizado
        MenuAdapter adapter =  new MenuAdapter(this,listaSO);

        //Por último enchufamos el adaptador a la Vista que es el ListView
        //INTERFAZ o la VISION
        final ListView listview= (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);

        //INTERACTUANDO
        listview.setOnItemClickListener(new nuestroListener());
    }

    //Implementamos el listener para nuestro listView
    //INNER CLASS
    private class nuestroListener implements AdapterView.OnItemClickListener{
        //Que pasará cuando cliquemos
        public void onItemClick (AdapterView<?> parent, View view, int position, long id){
            //Recuperamos posición dentro del String: string de la posición clickada
            String item= (String) parent.getItemAtPosition(position);

            //metodo makeText del widget Toast: (contexto, texto, duración_ventana_emergente)
            //Con show mostramos en un toast el contenido de lo clickado
            //Toast.makeText(MainActivity.this,item,Toast.LENGTH_LONG).show();

            //Enviar la información al otro activity:Paso de información

            Intent intent = new Intent(MainActivity.this, Main2Activity.class);

            //putExtra(string_etiqueta, mensaje pasado a otra actividad)
            intent.putExtra("so",item);
            startActivity(intent);
        }
    }
}