package com.example.aigua.pmultiplesdevices;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends android.app.Fragment {
    ListFragmentListener mCallback;
    // Container Activity must implement this interface
    public interface ListFragmentListener {
        public void onListSelected(int position,String item);

    }

    public MenuFragment() {
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
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //En primer lugar definimos el Array de Strings y lo convertimos a una Lista, en este caso ArrayList
        //DATOS
        String[] menu = new String[] { "Opcion 1", "Opcion 2", "Opcion 3"};
        ArrayList<String> listaMenu = new ArrayList<String>(Arrays.asList(menu));
        //En segundo lugar enchufamos la lista al Adaptador
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listaMenu);

        //Por último enchufamos el adaptador a la Vista que es el LsitView
        //INTERFAZ o la VISION
        final ListView listview = (ListView) getView().findViewById(R.id.listview);
        //INTERACTUANDO
        listview.setOnItemClickListener(new nuestroListener());
        listview.setAdapter(adapter);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (ListFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ListFragmentListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }
    //Implementamos el listener para nuestro listView
    //INNER CLASS
    private class nuestroListener implements AdapterView.OnItemClickListener{
        public void onItemClick (AdapterView<?> parent, View view, int position, long id){
            //String de la posicion clickada
            String item = (String) parent.getItemAtPosition(position);
            //Paso de informacion
            mCallback.onListSelected(position,item);
        }
    }
}
