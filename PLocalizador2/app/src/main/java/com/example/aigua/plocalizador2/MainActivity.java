package com.example.aigua.plocalizador2;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, OnMapReadyCallback {

    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    protected static final String TAG="Localizando";
    private GoogleMap mMap;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //llamada a los servicios de google para que carque el mapa
        setUpMapIfNeeded();

        // Create an instance of GoogleAPIClient.
        //Se conectará a los google play services
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
            Log.i(TAG,"Conectado a google services");
        }
    }

    //Cargar el mapa si no lo tenemos
    //Requiere implementar OnMapReadyCallback
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this); //Carga el mapa de forma asíncrona
        }
    }


    //Los listeners del google api client que se conectará a los servicios de google
    @Override
    public void onConnected(Bundle bundle) {

        Log.i(TAG,"Conectado con exito");
        try {
            //Obtenemos nuestra localización
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (mLastLocation != null) {
                Log.i(TAG, String.valueOf(mLastLocation.getLatitude()));
                Log.i(TAG, String.valueOf(mLastLocation.getLongitude()));
                //guardamos el valor de la latitud y longitud guardados
                double currentLatitude = mLastLocation.getLatitude();
                double currentLongitude = mLastLocation.getLongitude();
                //Mover el foco del mapa hacia la marca con la lat y long obtenida
                latLng = new LatLng(currentLatitude, currentLongitude);

                MarkerOptions options = new MarkerOptions()
                        .position(latLng)
                        .title("Aquí estoy!");
                mMap.addMarker(options);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            }
            //Si deniega la obtención de la localizacion
        }catch (SecurityException e){
            Log.i(TAG,"Denegada la localización");
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Finalizado o Suspendido");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(TAG,"Error en la conexion "+connectionResult.getErrorMessage());
    }

    //Lanzar la conexión con aplicación iniciada
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    //Desconectar con aplicación parada
    protected void onStop() {
        if(mGoogleApiClient.isConnected())
            mGoogleApiClient.disconnect();
        super.onStop();
    }

    //Callback para ver si ha cargado el mapa
    //Guardará el mapa
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}
