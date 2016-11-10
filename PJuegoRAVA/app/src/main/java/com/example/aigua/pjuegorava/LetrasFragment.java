package com.example.aigua.pjuegorava;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LetrasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LetrasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LetrasFragment extends android.app.Fragment {
    //Generamos un array que contendrá las posibilidades de letras
    String[] letras={"ROJO","AMARILLO","VERDE","AZUL"};
    int[] colores_resources=new int[4];
    int posicion;
    Random r=new Random();
    TextView tLetras;

    public LetrasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_letras, container, false);
        colores_resources[0]=v.getResources().getColor(R.color.ROJO);
        colores_resources[1]=v.getResources().getColor(R.color.AMARILLO);
        colores_resources[2]=v.getResources().getColor(R.color.VERDE);
        colores_resources[3]=v.getResources().getColor(R.color.AZUL);
        //Nuevo numero aleatorio
        posicion=r.nextInt(4);
        tLetras=(TextView) v.findViewById(R.id.tRava);
        //CAmbiamos las letras
        tLetras.setText(letras[posicion]);

        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //Metodo que comprueba si coincide el texto actual con el color elegido
    public boolean checkColor(int color){
        if(color==colores_resources[posicion]) return true;
        else return false;
    }

    //Metodo que cambia las letras
    public void cambiaLetras(){
        //Nuevo numero aleatorio
        posicion=r.nextInt(4);
        //CAmbiamos las letras
        tLetras.setText(letras[posicion]);
    }
}