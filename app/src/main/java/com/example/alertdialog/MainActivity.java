package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    ImageButton btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.result);

        btnEnviar = findViewById(R.id.BtEnviar);
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final View layout = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                alerta.setView(layout);
                alerta.setTitle("Calculo Salário");
                alerta.setMessage("Insira os valores abaixo para calcular");
                alerta.setCancelable(false);
                alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                }).setPositiveButton("Calcular", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DecimalFormat arrededondar = new DecimalFormat("#.##");
                        EditText inputNome = layout.findViewById(R.id.entradaNome);
                        EditText horasAula = layout.findViewById(R.id.horasTrabalhadas);
                        EditText precoHora = layout.findViewById(R.id.horaAula);

                        String nome = inputNome.getText().toString();
                        double horas = Double.parseDouble(horasAula.getText().toString());
                        double vlrHora = Double.parseDouble(precoHora.getText().toString());

                        Double valor = Double.valueOf(arrededondar.format(horas * vlrHora));
                        resultado.setText("Olá " + nome + "! O salário a ser recebido é de R$ "+ valor);

                    }
                });
                alerta.setCancelable(false);
                alerta.create().show();


                //double horaAula = Double.parseDouble(inputHora.getText().toString());
                //double horasTrabalhadas = Double.parseDouble(inputHoraMensal.getText().toString());
                //String salario = arrededondar.format(horaAula * horasTrabalhadas);

                //String nome = entrada.getText().toString();
                //novoAlerta.setTitle("Alerta!");
                // novoAlerta.setMessage("Olá "+nome+"! O salário a ser recebido é de R$ " + salario);
                // novoAlerta.setCancelable(false);
                // novoAlerta.setPositiveButton("ok",null);
                // novoAlerta.create().show();
                //Toast toast = Toast.makeText(MainActivity.this, "Olá " + nome + "! O salário a ser recebido é de R$ " + salario, Toast.LENGTH_LONG);
                //toast.setGravity(Gravity.TOP, 10, 10);
                //toast.show();


            }

        });
    }
}