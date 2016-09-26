package com.example.aigua.proyecto01;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    //Definimos una constante con el tiempo de retardo entre primera y sga pantalla
    //por defecto va en milisegundos

    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Ocultamos la barra del título
        //Hay un método de la clase Window requestWindowFeature(int feature_ID)
        //feature_ID es una constante definida en la clase Window
        //Para AppCompatActivity hay que usar supportRequestWindowFeature(int f_ID)
        //que: Enable extended support library window features

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.activity_splash);

        //Creamos una TimerTask: A task that can be scheduled for one-time or repeated execution by a Timer

        TimerTask task = new TimerTask() {
            @Override

            //Esto será lo que pasará en la tarea dependiente del tiempo
            //Lanzaremos MainActivity
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Creamos un objeto Timer:
        // Corresponding to each Timer object is a single background thread that
        // is used to execute all of the timer's tasks.

        Timer timer = new Timer();

        // schedule(TimerTask task, Date time)
        //Schedules the specified task for execution at the specified time.

        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
    }

