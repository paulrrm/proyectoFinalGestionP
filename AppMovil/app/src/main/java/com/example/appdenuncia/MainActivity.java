package com.example.appdenuncia;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdenuncia.Parametros.config;
import com.example.appdenuncia.Rest.RestLogin;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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


                    new RestLogin().postFactura();
                    int aaaa=122;
                    accionGoPrincipal();

                }
                catch (Exception e)
                {

                }

            }
        });
    }
}