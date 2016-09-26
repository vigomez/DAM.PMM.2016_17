package com.example.aigua.pfragment1;

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
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    ListFragmentListener mCallback;

    // Container Activity must implement this interface
    public interface ListFragmentListener {
        public void onListSelected(int position,String item);
    }

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        /*try {
            mCallback = (ListFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }*/
    }

    @Override
    //El Fragment depende de la Actividad creada por tanto se usa onActivityCreated
    //y no procede ponerlo dentro de OnCreateView()
    //Cargamos nuestro ListView en el Fragment con la Actividad creada.

    public void onActivityCreated (Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        //En primer lugar definimos el Array de Strings y lo convertimos a una Lista, en este caso ArrayList
        //DATOS
        String[] sistemasOperativos = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };
        ArrayList<String> listaSO = new ArrayList<String>(Arrays.asList(sistemasOperativos));

        //En segundo lugar enchufamos la lista al Adaptador
        //ArrayAdapter necesita de una activity: getActivity() devuelve el activity del Fragment
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listaSO);


        //Por último enchufamos el adaptador a la Vista que es el ListView
        //INTERFAZ o la VISION
        //Volvemos a utilizar getActivity() pues ListView es un método de una activity
        //El listview estará definido en el fragment_list.xml

        final ListView listview = (ListView) getActivity().findViewById(R.id.listview);
        listview.setAdapter(adapter);
    }

}
