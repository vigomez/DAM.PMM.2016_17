package com.example.aigua.pfragment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ListFragment.ListFragmentListener{

    //El main activity implementa el interface
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        //Que passará al hacer click sobre la lista

    public void onListSelected(int position,String item){
        //Log.i("FRAGENT", "Llego");
        //Toast.makeText(this,"TExto elegida: "+item,Toast.LENGTH_SHORT).show();
        //Lanzará Main2Activity
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("so", item);
        startActivity(intent);

    }
}
