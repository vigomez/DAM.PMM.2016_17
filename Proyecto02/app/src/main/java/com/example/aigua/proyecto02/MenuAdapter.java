package com.example.aigua.proyecto02;

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
 * Created by aigua on 19/09/2016.
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

    public View getView(int position, View convertView, ViewGroup parent){
        //Instanciamos un xml layout en el correspondiente View
        //Creamos un objeto de la clase inflater
        LayoutInflater inflater= (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        //Comprobamos que no existe ninguno previo para colocar nuestro Layout

        if(convertView==null){
            //atraves del metédo inflate, de la clase inflater, pasamos nuestro xml
            //indicamos quien es el padre (root jerarquía visual, lo pasa el getView
            //false: no dejamos que el padre lo maneje

            convertView=inflater.inflate(R.layout.item_menu,parent,false);
        }
        //Cogemos la imagen y el texto que tenemos en item_lista
        ImageView imagen= (ImageView) convertView.findViewById(R.id.imageView2);
        TextView texto= (TextView) convertView.findViewById(R.id.textView);

        //Colocamos el elemento de datos situado en la posicion que pasa el getView
        //texto.setText(datos.get(position));
        texto.setText(datos.get(position));

        switch (position){
            case 0:
                imagen.setImageResource(R.drawable.ic_face_black_24dp);
                break;
            case 1:
                imagen.setImageResource(R.drawable.ic_tap_and_play_black_24dp);
                break;
            case 2:
                imagen.setImageResource(R.drawable.ic_face_black_24dp);
                break;
            case 3:
                imagen.setImageResource(R.drawable.ic_tap_and_play_black_24dp);
                break;
            default:
                imagen.setImageResource(R.drawable.ic_face_black_24dp);
                break;
        }

        //Devuelve un nuevo View generado con el dato ya posicionado
        return convertView;
    }
}


