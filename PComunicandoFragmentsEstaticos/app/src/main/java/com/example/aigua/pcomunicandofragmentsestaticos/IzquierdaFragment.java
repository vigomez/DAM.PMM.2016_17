package com.example.aigua.pcomunicandofragmentsestaticos;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * Sencillo Fragment con un boton central
 */
public class IzquierdaFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button boton;
    TextView texto;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IzquierdaFragment.
     */
    // TODO: Rename and change types and number of parameters
    //La parte del Bundle se utilizaría si tuviésemos fragments dinámicos
    public static IzquierdaFragment newInstance(String param1, String param2) {
        IzquierdaFragment fragment = new IzquierdaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public IzquierdaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_izquierda, container, false);
        //Implementamos listener boton, implementado por el propio fragment
        boton = (Button) v.findViewById(R.id.bIzq);
        boton.setOnClickListener(this);
        //Capturamos el texto del TextView incluido en el Fragment
        texto = (TextView) v.findViewById(R.id.tIzq);
        return v;
    }

    //COMENTAMOS ESTE CÓDIGO YA QUE VAMOS A IMPLEMENTAR NUESTRO PROPIO CÓDIGO
    // TODO: Rename method, update argument and hook method into UI event
    //public void onButtonPressed(Uri uri) {
    //    if (mListener != null) {
    //        mListener.onFragmentInteraction(uri);
    //    }
    //}

    @Override
    //Comprobamos que el activity superior tenga implementado OnFragmentInteractionListener
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        //Llamamos al callback mListener, implementado en la parte superior activity
        //Este a su vez pasa el mensaje al activity
        //Llama al Activity superior
        mListener.onFragmentInteraction(0,"HOLA");
    }
    /**
     * ESTE ES EL METODO QUE PERMITE CAMBIAR EL MENSAJE DEL TEXTO
     */
    //Método propio usable por la activity para interactuar con el Fragment
    public void onText(String Mensage){
        texto.setText(Mensage);
    }

    /**
     * ESTE ES EL LISTENER DEL BOTON
     */

    /**
     * ESTE ES EL INTERFAZ QUE EL ACTIVITY SUPOERIOR DEBE IMPLEMENTAR
     */
    //pos identificará al fragment: 0 izquierda, 1 derecha
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(int pos,String mensage);
    }

}
