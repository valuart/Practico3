package com.example.practico3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;



public class MainActivity extends AppCompatActivity {
    EditText etDolares, etEuros, etCambio;
    RadioButton rbA, rbB;
    Button btnConvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDolares = findViewById(R.id.etDolares);
        etEuros = findViewById(R.id.etEuros);
        etCambio= findViewById(R.id.etCambio);
        rbA = findViewById(R.id.rbA);
        rbA.setChecked(true);
        rbB = findViewById(R.id.rbB);
        btnConvertir = findViewById(R.id.btnConvertir);

        rbA.setOnClickListener(this::Euros);
        rbB.setOnClickListener(this::Dolar);
        btnConvertir.setOnClickListener(this::convertir);

    }

    public void Dolar(View v) {
        if (rbB.isChecked()) {
            rbA.setChecked(false);
        }
    }

    public void Euros(View v) {
        if (rbA.isChecked()) {
            rbB.setChecked(false);
        }
    }

    protected void EurosADolares() {

        double valor1;
        double valor2;

        if ("".equals(etEuros.getText().toString())){
            valor1 = 0;
        }
        else{
            valor1 = Double.parseDouble(etEuros.getText().toString());
        }

        if ("".equals(etCambio.getText().toString())){
            valor2 = 0;
        }
        else{
            valor2 = Double.parseDouble(etCambio.getText().toString());
        }



        etDolares.setText(Double.toString(valor1/valor2));
    }

    protected void DolaresAEuro() {

        double valor1;
        double valor2;


        if ("".equals(etDolares.getText().toString())){
            valor1 = 0;
        }
        else{
            valor1= Double.parseDouble(etDolares.getText().toString());
        }

        if ("".equals(etCambio.getText().toString())){
            valor2= 0;
        }
        else{
            valor2 = Double.parseDouble(etCambio.getText().toString());
        }


        etEuros.setText(Double.toString(valor1* valor2));
    }




    public void convertir(View v) {


        if (v == btnConvertir) {
            if (rbA.isChecked()) {
                EurosADolares();
            }
            if (rbB.isChecked()) {
                DolaresAEuro();
            }
        }

    }

}

