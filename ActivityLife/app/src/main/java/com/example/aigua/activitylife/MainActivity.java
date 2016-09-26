package com.example.aigua.activitylife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="ActivityLife";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"Cargada mi APP");
    }

    protected void onResume(){
        super.onResume();
        Log.i(TAG,"Volvemos a la APP");
    }

    protected void onPause(){
        super.onPause();
        Log.i(TAG,"APP pasa a segundo plano");
    }
}
