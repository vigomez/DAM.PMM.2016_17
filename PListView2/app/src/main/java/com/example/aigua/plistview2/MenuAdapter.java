package com.example.aigua.plistview2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Clase MenuAdapter extends ArrayAdapter para generar un menu.
 * Decimos específicamente que el array de objetos será de Strings
 */
public class MenuAdapter extends ArrayAdapter<String> {

    //guardamos nuestro contexto y nuestros datos
    private Context context;
    private ArrayList<String> datos;

    //Constructor MenuAdapter(Context context, int resource, Object[] objects)
    //Especificamos que será de strings
    public MenuAdapter(Context context, ArrayList<String> datos) {
        //Usamos un ListView en concreto y no que se pase como referencia
        super(context, 0, datos);
        this.context=context;
        this.datos=datos;
    }

    //Sobreescribimos getView para indicar donde visualizaremos los elementos
    //getView(posicion, nuevo view, contexto donde se colocará)

    public View getView(int position,View convertView,ViewGroup parent){
        //Instanciamos un xml layout en el correspondiente View
        //Creamos un objeto de la clase inflater
        LayoutInflater inflater= (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        //Comprobamos que no existe ninguno previo para colocar nuestro Layout

        if(convertView==null){
            //Visualizamos la jerarquía de los Views
            Log.i("INFO_DAM", parent.toString());
            //atraves del metédo inflate, de la clase inflater, pasamos nuestro xml
            //indicamos quien es el padre (root jerarquía visual, lo pasa el getView
            //false: no dejamos que el padre lo maneje

            convertView=inflater.inflate(R.layout.item_lista,parent,false);
        }
        //Cogemos la imagen y el texto que tenemos en item_lista
        ImageView imagen= (ImageView) convertView.findViewById(R.id.imageView);
        TextView texto= (TextView) convertView.findViewById(R.id.textView);

        //Colocamos el elemento de datos situado en la posicion que pasa el getView
        texto.setText(datos.get(position));

        //Devuelve un nuevo View generado con el dato ya posicionado
        return convertView;
    }
}
