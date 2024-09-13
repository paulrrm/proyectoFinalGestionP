package com.example.appdenuncia.Rest;

import android.os.AsyncTask;


import com.example.appdenuncia.MainActivity;
import com.example.appdenuncia.Parametros.config;
import com.example.appdenuncia.model.usuario;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestLogin extends AsyncTask <String , Void , String> {

    private MainActivity mainActivity;
    private String usr;
    private String pwd;




    public RestLogin(MainActivity activity, String usr, String pwd) {
        this.mainActivity = activity;
        this.usr = usr;
        this.pwd = pwd;
    }

    protected void onPostExecute() {

        System.out.println("TERMINADO");
        mainActivity.accionGoPrincipal();


    }

    @Override
    protected String doInBackground(String... strings) {
        try {

            URL url = null;
            url = new URL(config.ipserver +  "usuario/login/"+usr+"/"+pwd);
            String server_response = "";
            HttpURLConnection urlConnection = null;
            urlConnection = (HttpURLConnection) url.openConnection();


            //urlConnection.addRequestProperty("Version", Parametros.version);
            int responseCode = urlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("OKKKK   "+ urlConnection.getInputStream());
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(
                            new InputStreamReader(urlConnection.getInputStream())

                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String line = null;

                StringBuilder sb = new StringBuilder();
                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (line != null) {
                    sb.append(line);
                    try {
                        line = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                ///gson to objet
                Gson gson = new Gson();
                usuario usr = gson.fromJson(String.valueOf(sb), usuario.class);
                int aa =12;
                config.usr = usr;

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
