package com.example.appdenuncia.Rest;

import android.os.AsyncTask;

import com.example.appdenuncia.IngresoDenunciaActivity;
import com.example.appdenuncia.Parametros.config;
import com.example.appdenuncia.RegistroActivity;
import com.example.appdenuncia.model.denuncia;
import com.example.appdenuncia.model.placa;
import com.example.appdenuncia.model.usuario;
import com.example.appdenuncia.model.usuarioRegistro;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PostRegistro  extends AsyncTask<String , Void , String> {
    private String nombre , apellido , correo ,paswword;;

    private RegistroActivity actividad;



    public PostRegistro(RegistroActivity actividad,String nombre , String apellido ,String  correo ,String paswword) {
        this.actividad  = actividad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.paswword = paswword;
    }

    protected void onPostExecute() {

        System.out.println("TERMINADO");
        //ingreso.accionGoPrincipal();
        //Toast.makeText(actividad.getApplicationContext(),"Datos ingredados exitosamente", Toast.LENGTH_LONG).show();
        RegistroActivity.mostrarResultado("Ingresado con exito");


    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            usuarioRegistro usuario = new usuarioRegistro();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setCorreo(correo);
            usuario.setPassword(paswword);
            usuario.setFechaalta(config.getFechaString());

            Gson gson = new Gson();
            String salida = "";
            salida = gson.toJson(usuario);
            URL url = null;
            url = new URL(config.ipserver + "usuario");
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
                onPostExecute();

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
