package com.example.appdenuncia.Rest;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.appdenuncia.IngresoDenunciaActivity;
import com.example.appdenuncia.Parametros.config;
import com.example.appdenuncia.model.denuncia;
import com.example.appdenuncia.model.placa;
import com.example.appdenuncia.model.usuario;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PostDenuncia extends AsyncTask<String , Void , String> {


    private String placat, provincia , color,fecha,marca,modelo,valor;
    private usuario usuario;
    private IngresoDenunciaActivity actividad;



    public PostDenuncia(IngresoDenunciaActivity actividad,usuario usuario,String placa, String provincia,String color,String fecha,String marca, String modelo,String valor) {
        this.actividad  = actividad;
        this.usuario    = usuario  ;
        this.placat      = placa    ;
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
        //Toast.makeText(actividad.getApplicationContext(),"Datos ingredados exitosamente", Toast.LENGTH_LONG).show();
        IngresoDenunciaActivity.mostrarResultado("Ingresado con exito");


    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            usuario.setFechaalta(null);
            usuario.setFechabaja(null);
            placa placa = new placa();
            placa.setNumero(placat);
            placa.setProvincia(provincia);
            denuncia denuncia = new denuncia();
            denuncia.setColor(color);
            denuncia.setFechalta(config.getFechaString());
            denuncia.setFecharobo(config.fechaFotmateada(fecha));
            denuncia.setMarca(marca);
            denuncia.setModelo(modelo);
            denuncia.setValor(Double.parseDouble(valor));
            denuncia.setUsuario(usuario);
            denuncia.setPlaca(placa);


            Gson gson = new Gson();
            String salida = "";
            salida = gson.toJson(denuncia);
            URL url = null;
            url = new URL(config.ipserver + "denuncia");
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