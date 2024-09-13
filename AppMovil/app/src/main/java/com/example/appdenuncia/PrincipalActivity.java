package com.example.appdenuncia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdenuncia.Parametros.config;

public class PrincipalActivity extends AppCompatActivity {

    TextView nombre , correo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        correo = findViewById(R.id.principal_tb_correo);
        nombre = findViewById(R.id.principal_tb_nombre);
        mapDatos();
    }
    public void mapDatos(){
          nombre.setText(" "+config.usr.getNombre() + " "+config.usr.getApellido());
          correo.setText("CORREO: "+config.usr.getCorreo());
    }
    public void accionSalir(View view){
        this.finish();
    }

    public void accionSDenuncia(View view){
        Intent i = new Intent(this, IngresoDenunciaActivity.class);

        startActivity(i);
    }
    public void accionReporte(View view){
        Intent i = new Intent(this, ReporteActivity.class);

        startActivity(i);
    }

}