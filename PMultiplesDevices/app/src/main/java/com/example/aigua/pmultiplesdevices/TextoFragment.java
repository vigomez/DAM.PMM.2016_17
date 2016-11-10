package com.example.aigua.pmultiplesdevices;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TextoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TextoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextoFragment extends android.app.Fragment {

    TextView texto;
    // Parametros necesarios para rellenar la noticia
    static final String ARG_TEXTO = "texto";

    private String tTexto="";

    public TextoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tTexto = getArguments().getString(ARG_TEXTO);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_texto, container, false);
        texto = (TextView) v.findViewById(R.id.tTexto);
        if(tTexto.length()>0) texto.setText(tTexto);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    //Metodo para cambiar el texto del TextView
    public void setTexto(String t){
        this.texto.setText(t);
    }



}