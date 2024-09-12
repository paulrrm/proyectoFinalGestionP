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

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RestLogin extends AsyncTask <String , Void , String> {

    public void postFactura() {

        doInBackground();
    }

        protected void onPostExecute(Long result) {

        System.out.println("TERMINADO");
        if(config.usr == null ){

        }
        else{

        }


    }

    @Override
    protected String doInBackground(String... strings) {
        try {
//            OkHttpClient client = new OkHttpClient().newBuilder()
//                    .build();
//            MediaType mediaType = MediaType.parse("text/plain");
//            RequestBody body = RequestBody.create(mediaType, "");
//            Request request = new Request.Builder()
//                    .url("http://192.168.0.108:8088/denuncias/robo/usuario/login/prm/prm")
//
//                    .build();
//            Response response = client.newCall(request).execute();
//            int a =1;
//            System.out.println("EXITO"+ response.message());
            URL url = null;
            url = new URL("http://192.168.1.19:8088/denuncias/robo/usuario/login/p@gmail.com/123123123");
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
        return "";
    }
}
