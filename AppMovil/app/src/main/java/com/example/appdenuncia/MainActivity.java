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
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;



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
//        AsyncTask.execute(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//
//
//                    new RestLogin().postFactura();
//                    int aaaa=122;
//                    accionGoPrincipal();
//
//                }
//                catch (Exception e)
//                {
//
//                }
//
//            }
//        });
        RequestParams params = new RequestParams();
        //params.put("usr","p@gmail.com");
       // params.put("password", "123123123");
        AsyncHttpClient cliente = new AsyncHttpClient();
        cliente.get("http://192.168.1.19:8088/denuncias/robo/usuario/login/p@gmail.com/123123123", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                int a =1;
                Intent i = new Intent(getApplicationContext(), PrincipalActivity.class);

                startActivity(i);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                System.out.println("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
            }
        });

    }
}