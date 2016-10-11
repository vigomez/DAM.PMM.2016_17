package com.example.aigua.pfragmentdinamico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ListFragment.ListFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Al clickar pasaremos a MainActivity2 la posición con su string correspondiente
    public void onListSelected(int position,String item){
        Log.i("FRAGENT", "Llego");
        //Toast.makeText(this,"TExto elegida: "+item,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("so", item);
        startActivity(intent);

    }
}
