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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PuntuacionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PuntuacionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PuntuacionFragment extends android.app.Fragment {
    int puntuacion =0;
    TextView tPunt;


    public PuntuacionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_puntuacion, container, false);
        tPunt = (TextView) v.findViewById(R.id.tPunt);
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

    public void addPuntuacion(){
        puntuacion=puntuacion+5;
        tPunt.setText(String.valueOf(puntuacion));
    }


}
