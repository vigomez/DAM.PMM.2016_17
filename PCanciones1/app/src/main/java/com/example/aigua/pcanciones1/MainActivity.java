package com.example.aigua.pcanciones1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.AudioManager.OnAudioFocusChangeListener;


public class MainActivity extends AppCompatActivity {
    //Control de volumen
    private int mVolume = 6, mVolumeMax = 10, mVolumeMin = 0;
    //Control sonando
    private int sonando=0; //0=cancion no comenzada; 1=comenzada; 2=pause;
    private SoundPool mSoundPool;
    private int mSoundId;
    private AudioManager mAudioManager;
    private boolean mCanPlayAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Capturamos el servicio que nos proporciona manejar Sonidos
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Volumen actual programado
        final TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(String.valueOf(mVolume));

        // Subir volumen
        final Button upButton = (Button) findViewById(R.id.button2);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Hacer sonar el efecto de click
                mAudioManager.playSoundEffect(AudioManager.FX_KEY_CLICK,mVolume);

                if (mVolume < mVolumeMax) {
                    mVolume += 2;
                    tv.setText(String.valueOf(mVolume));
                }
            }
        });

        // Bajar Volumne
        final Button downButton = (Button) findViewById(R.id.button1);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Hacer sonar el efecto de click
                mAudioManager.playSoundEffect(AudioManager.FX_KEY_CLICK,mVolume);

                if (mVolume > mVolumeMin) {
                    mVolume -= 2;
                    tv.setText(String.valueOf(mVolume));
                }

            }
        });

        // Desactivamos el boton del play
        final Button playButton = (Button) findViewById(R.id.button3);
        playButton.setEnabled(false);

        // Creamos el manejador del sonido
        //Manerajaremos en paralelo solo uno (1), de tipo MUSIC, el tercer parámetro es la calidad
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        // Cargamos la cancion (contexto, recurso, 1 por defecto para prioridad)
        mSoundId = mSoundPool.load(this, R.raw.cancion2, 1);

        // Esperamos a que se cargue la cancion completa
        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                Log.d("AUDIO", "Cargada la cancion");
                if (0 == status) {
                    //Si se ha cargado la canción reactivamos el boton play
                    playButton.setEnabled(true);
                    Log.d("AUDIO", "Cargada correctamente");
                }
            }
        });

        // Suena la cancion
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sonando==0){
                    playButton.setText("||");
                    sonando=1;
                    Log.d("AUDIO: ", "SONANDO");
                    if (mCanPlayAudio)
                        //play (id_del_sonido,vlumen izquierdo, vlumen dcho,prioridad, modo loop,
                        //,velocidad de reproducción)
                        //la ponemos en modo loop porque si la cancion termina, el metodo pause
                        //resume no funciona
                        //Reproduce el sonido con el volumen escogido anteriormente
                        //no cambia dinámicamente el volumen
                        mSoundPool.play(mSoundId, (float) mVolume/mVolumeMax,
                                (float) mVolume/mVolumeMax, 1, -1, 1.0f);
                }else if(sonando==1){
                    Log.d("AUDIO", "EN PAUSA");
                    playButton.setText("Play");
                    sonando=2;
                    mSoundPool.pause(mSoundId);
                }else{
                    Log.d("AUDIO:", "VOLVIENDO A TOCAR");
                    playButton.setText("||");
                    sonando=1;
                    mSoundPool.resume(mSoundId);
                }
            }

        });

        // Request audio focus
        //Varios servicios pueden requerir la reproducción de audio
        //Solicitamos "el foco" para que se repruzca la canción
        int result = mAudioManager.requestAudioFocus(afChangeListener,
                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
        //Si hemos cogido el foco, sonará
        mCanPlayAudio = AudioManager.AUDIOFOCUS_REQUEST_GRANTED == result;
    }

    // Get ready to play sound effects
    @Override
    protected void onResume() {
        Log.d("Activity: ", "REINICIADA");
        super.onResume();
        mAudioManager.setSpeakerphoneOn(true);
        mAudioManager.loadSoundEffects();
    }

    // Release resources & clean up
    @Override
    protected void onPause() {
        Log.d("Activity: ", "EN PAUSA");
        /*Normalmente al pausar una activity es recomendable liberar los recursos utilizados
        por si son necesarios para otra. Pero al hacerlo requiría que en onResume cargásemos
        de nuevo esos recursos, en este caso la canción*/
        if (null != mSoundPool) {
            mSoundPool.unload(mSoundId);
            mSoundPool.release();
            mSoundPool = null;
        }
        mAudioManager.setSpeakerphoneOn(false);
        mAudioManager.unloadSoundEffects();
        super.onPause();

    }

    // Listen for Audio focus changes
    //Implemetamos el listener del "Focus" para que se situe en nuestra actividad
    OnAudioFocusChangeListener afChangeListener = new OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mAudioManager.abandonAudioFocus(afChangeListener);
                mCanPlayAudio = false;
            }
        }
    };

/* Por si quisiésemos añadir un menú tipo toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
