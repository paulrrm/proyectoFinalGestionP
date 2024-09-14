package com.example.appdenuncia;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdenuncia.Parametros.config;
import com.example.appdenuncia.Rest.PostPlaca;
import com.example.appdenuncia.Rest.RestLogin;

import java.util.Calendar;

public class IngresoDenunciaActivity extends AppCompatActivity {

    static EditText color,fecha,marca,modelo,valor,placa,provincia;
    static TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ingreso_denuncia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        color = findViewById(R.id.denuncia_etcolor);
        fecha = findViewById(R.id.denuncia_etfecha);
        marca = findViewById(R.id.denuncia_etmarca);
        modelo = findViewById(R.id.denuncia_etmodelo);
        valor = findViewById(R.id.denuncia_etvalor);
        placa = findViewById(R.id.denuncia_etvplaca);
        provincia = findViewById(R.id.denuncia_etvprovincia);
        resultado = findViewById(R.id.denuncia_tvresultado);
    }
    public void accion_pickdate(View view){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        fecha.setText(year+ "-" + (monthOfYear + 1)+"-"+dayOfMonth  );

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }
    public void accionSalir(View view){
        this.finish();
    }
    public void accionGuardas(View view){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {


                    new PostPlaca(
                            IngresoDenunciaActivity.this,
                            config.usr,
                            placa.getText().toString(),
                            provincia.getText().toString(),
                            color.getText().toString(),
                            fecha.getText().toString(),
                            marca.getText().toString(),
                            modelo.getText().toString(),
                            valor.getText().toString()

                    ).execute();



                }
                catch (Exception e)
                {
                }

            }
        });

    }
    public static void mostrarResultado(String texto){
        resultado.setText(texto);
        accionLimpiarCampos();
    }
    public static void accionLimpiarCampos(){
        color.setText("");
        fecha.setText("");
        marca.setText("");
        modelo.setText("");
        valor.setText("");
        placa.setText("");
        provincia.setText("");
    }
}