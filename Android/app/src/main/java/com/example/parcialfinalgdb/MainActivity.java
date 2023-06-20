package com.example.parcialfinalgdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.parcialfinalgdb.Vista.Login;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 30; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Crear un objeto Handler para realizar la pausa y el cambio de vista
        Handler handler = new Handler();

        // Ejecutar el código después del retraso especificado
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Iniciar la actividad principal o cualquier otra actividad que desees mostrar después del splash screen
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);

                // Cerrar la actividad del splash screen para que no se pueda volver atrás
                finish();
            }
        }, SPLASH_DELAY);

    }
}