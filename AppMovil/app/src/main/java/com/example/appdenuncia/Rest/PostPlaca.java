package com.example.appdenuncia.Rest;

import android.os.AsyncTask;

import com.example.appdenuncia.IngresoDenunciaActivity;
import com.example.appdenuncia.MainActivity;
import com.example.appdenuncia.Parametros.config;
import com.example.appdenuncia.model.placa;
import com.example.appdenuncia.model.usuario;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PostPlaca extends AsyncTask<String , Void , String> {


    private String placat, provincia , color,fecha,marca,modelo,valor;
    private usuario usuario;
    private IngresoDenunciaActivity actividad;




    public PostPlaca(IngresoDenunciaActivity actividad, usuario usuario,String placa, String provincia,String color,String fecha,String marca, String modelo,String valor) {

        this.actividad  = actividad;
        this.usuario    = usuario  ;
        this.placat     = placa    ;
        this.provincia  = provincia;
        this.color      = color    ;
        this.fecha      = fecha    ;
        this.marca      = marca    ;
        this.modelo     = modelo   ;
        this.valor      = valor    ;
    }

    protected void onPostExecute() {

        System.out.println("TERMINADO");
        //ingreso.accionGoPrincipal();
        //IngresoDenunciaActivity.set.setText("PLACA AGREGADA");

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {


                    new PostDenuncia(
                            actividad,
                            config.usr,
                            placat,
                            provincia,
                            color,
                            fecha,
                            marca,
                            modelo,
                            valor

                    ).execute();



                }
                catch (Exception e)
                {
                }

            }
        });


    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            placa placa = new placa();
            placa.setNumero(placat);
            placa.setProvincia(provincia);
            Gson gson = new Gson();
            String salida = "";
            salida = gson.toJson(placa);
            URL url = null;
            url = new URL( config.ipserver +    "placas");
            String server_response = "";
            HttpURLConnection urlConnection = null;

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("content-type", "application/json");
            urlConnection.setDoOutput(true);


            OutputStreamWriter wr = null;

            try {
                wr = new OutputStreamWriter(urlConnection.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                wr.write(salida);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                wr.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //urlConnection.addRequestProperty("Version", Parametros.version);
            int responseCode = urlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                int a =12;

            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);

        } catch (Exception e) {
            //throw new RuntimeException(e);
            int a =1;
            System.out.println("ERROR"+e.getMessage());
        }
        onPostExecute();
        return "";
    }
}
