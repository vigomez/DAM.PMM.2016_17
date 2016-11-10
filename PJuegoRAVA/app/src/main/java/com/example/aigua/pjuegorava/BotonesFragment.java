package com.example.aigua.pjuegorava;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BotonesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BotonesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

    public class BotonesFragment extends android.app.Fragment implements View.OnClickListener {
        //Array de colores
        List<Integer> colores = new LinkedList<Integer>();
        Button b1,b2,b3,b4;


        private OnFragmentBotonListener mListener;


        public BotonesFragment() {
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
            View v=inflater.inflate(R.layout.fragment_botones, container, false);
            colores.add(new Integer(R.color.ROJO));
            colores.add(new Integer(R.color.AMARILLO));
            colores.add(new Integer(R.color.VERDE));
            colores.add(new Integer(R.color.AZUL));
            Collections.shuffle(colores);
            //Coloreamos los botones
            b1=(Button)v.findViewById(R.id.button1);
            b1.setBackgroundResource(colores.get(0));
            b1.setOnClickListener(this);
            b2=(Button)v.findViewById(R.id.button2);
            b2.setBackgroundResource(colores.get(1));
            b2.setOnClickListener(this);
            b3=(Button)v.findViewById(R.id.button3);
            b3.setBackgroundResource(colores.get(2));
            b3.setOnClickListener(this);
            b4=(Button)v.findViewById(R.id.button4);
            b4.setBackgroundResource(colores.get(3));
            b4.setOnClickListener(this);
            return v;
        }


        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            try {
                mListener = (OnFragmentBotonListener) activity;
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

        /**
         * ESTE ES EL INTERFAZ QUE EL ACTIVITY SUPOERIOR DEBE IMPLEMENTAR
         */
        public interface OnFragmentBotonListener {
            public void onFragmentInteraction(int color);
        }
        /**
         * ESTE ES EL LISTENER DEL BOTON
         */
        @Override
        public void onClick(View v) {
            //Llamamos al callback
            //Este a su vez pasa el color al activity
            Button b=(Button)v.findViewById(v.getId());
            mListener.onFragmentInteraction(((ColorDrawable)b.getBackground()).getColor());
        }

        //Barajamos los colores
        public void barajarColores(){
            Collections.shuffle(colores);
            //Coloreamos los botones
            b1.setBackgroundResource(colores.get(0));
            b2.setBackgroundResource(colores.get(1));
            b3.setBackgroundResource(colores.get(2));
            b4.setBackgroundResource(colores.get(3));
        }

    }