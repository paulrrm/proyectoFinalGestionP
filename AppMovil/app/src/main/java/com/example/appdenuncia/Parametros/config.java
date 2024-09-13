package com.example.appdenuncia.Parametros;

import com.example.appdenuncia.model.usuario;

import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public  class config {

    public static usuario usr;
    public static String ipserver = "http://192.168.1.19:8088/denuncias/robo/";
    public static String fechaFotmateada(String actual){
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-M-d");

        // Define el formato de la fecha de salida (con ceros a la izquierda)
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        // La cadena de fecha que quieres convertir
        String fechaString = actual;

        try {
            // Convierte la cadena a un objeto java.util.Date
            Date fecha = inputFormat.parse(fechaString);

            // Formatea la fecha a 'yyyy-MM-dd'
            String fechaFormateada = outputFormat.format(fecha);

            // Muestra la fecha formateada
            return  fechaFormateada;
        } catch (ParseException e) {
            return actual;
        }
    }
    public static String getFechaString(){
        // Obtiene la fecha actual
        Calendar calendar = Calendar.getInstance();

        // Define el formato de la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Formatea la fecha actual
        String fechaActual = sdf.format(calendar.getTime());

        // Muestra la fecha en formato AAAA-MM-DD
        return fechaActual;
    }
    public static Date getFecha(){
        Date fechaActual = new Date();
        return  fechaActual;
    }
    public static Date fechaFromString(String fechastr) {
        // Define el formato de la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // La cadena de fecha que quieres convertir


        try {
            // Convierte la cadena a un objeto java.util.Date
            Date fecha = sdf.parse(fechastr);

            // Muestra la fecha convertida
            return fecha;
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

}
