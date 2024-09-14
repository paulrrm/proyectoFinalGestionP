package com.example.appdenuncia;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdenuncia.Parametros.config;
import com.example.appdenuncia.Rest.PostPlaca;
import com.example.appdenuncia.Rest.PostRegistro;

public class RegistroActivity extends AppCompatActivity {

    static EditText nombre , apellido , correo ,paswword;
    static TextView resultado;

    public static void mostrarResultado(String mensaje) {
        resultado.setText(mensaje);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nombre = findViewById(R.id.registro_etnombre);
        apellido = findViewById(R.id.registro_etapellidos);
        correo = findViewById(R.id.registro_etcorreo);
        paswword = findViewById(R.id.registro_etpwd);
        resultado = findViewById(R.id.registro_tvresultado);

    }
    public  void accionGuardar(View view){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {


                    new PostRegistro(
                            RegistroActivity.this,
                            nombre.getText().toString(),
                            apellido.getText().toString(),
                            correo.getText().toString(),
                            paswword.getText().toString()

                    ).execute();



                }
                catch (Exception e)
                {
                }

            }
        });

    }
    public void accionSalir(View view){
        this.finish();
    }
}