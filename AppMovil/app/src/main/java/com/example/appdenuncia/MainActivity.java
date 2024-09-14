package com.example.appdenuncia;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdenuncia.Parametros.config;
import com.example.appdenuncia.Rest.RestLogin;
import com.example.appdenuncia.model.usuario;


import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;





public class MainActivity extends AppCompatActivity {

    EditText etusr,etpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etpwd = findViewById(R.id.main_etpwd);
        etusr= findViewById(R.id.main_etmail);
    }
    public void accionGoPrincipal(){
            int a=1;
        if(config.usr == null)
        {

        }
        else if(config.usr.getId()>0){
            Intent i = new Intent(this, PrincipalActivity.class);

            startActivity(i);
        }

    }
    public void accionLogin(View view){
        AsyncTask.execute(new Runnable() {
           @Override
            public void run() {

              try {


                   new RestLogin(MainActivity.this , etusr.getText().toString(), etpwd.getText().toString()).execute();



               }
               catch (Exception e)
              {
              }

           }
        });


    }
    public void accionRegistro(View view){
        Intent i = new Intent(this, RegistroActivity.class);

        startActivity(i);
    }
}