package com.example.asistetrack;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Iniciar el servicio de localización
        Intent serviceIntent = new Intent(this, LocationService.class);
        startService(serviceIntent);

        // Cerrar la actividad
        finish();
    }
}