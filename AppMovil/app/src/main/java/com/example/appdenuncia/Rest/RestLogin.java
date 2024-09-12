package com.example.appdenuncia.Rest;

import android.os.AsyncTask;

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
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("http://192.168.0.108:8088/denuncias/robo/usuario/login/prm/prm")

                    .build();
            Response response = client.newCall(request).execute();
            int a =1;
            System.out.println("EXITO"+ response.message());
        } catch (Exception e) {
            //throw new RuntimeException(e);
            int a =1;
            System.out.println("ERROR"+e.getMessage());
        }
        return "";
    }
}
