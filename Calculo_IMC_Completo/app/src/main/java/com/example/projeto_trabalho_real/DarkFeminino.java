package com.example.projeto_trabalho_real;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DarkFeminino extends AppCompatActivity {

    TextView nome,peso, altura, imc, resultadofinal;
    Button voltar, sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darkfeminino);

        nome = (TextView) findViewById(R.id.MasculinotextViewNome);
        peso = (TextView) findViewById(R.id.MasculinotextViewPeso);
        altura = (TextView) findViewById(R.id.MasculinotextViewAltura);
        imc = (TextView) findViewById(R.id.MasculinotextViewIMC);
        resultadofinal = (TextView) findViewById(R.id.textViewResultadoFinal);
        voltar = (Button) findViewById(R.id.FemininobtVoltar);
        sair = (Button) findViewById(R.id.FemininobtSair);

        Intent masculino = getIntent();

        Bundle parametros = masculino.getExtras();

        nome.setText("Ola " + parametros.getString("nome") + ".");
        peso.setText("Seu peso é: " + parametros.getString("peso") + " KG.");
        altura.setText("Sua altura é: " + parametros.getString("altura") + " Metros.");
        imc.setText("Seu IMC é: " + parametros.getString("imc") + ".");

        Double resultado = Double.parseDouble(parametros.getString("imc"));

        if (resultado <= 0){
            resultadofinal.setText("Resultado de erro inesperado, favor tentar novamente.");
        }
        else if (resultado <= 18.4){
            resultadofinal.setText("Sua Classificação é de: 'Magresa'. Por gentileza aumente seu peso.");
        }
        else if (resultado <= 24.9){
            resultadofinal.setText("Sua Classificação é de: 'Normal'. Parabens! Continue assim.");
        }
        else if (resultado <= 29.0){
            resultadofinal.setText("Sua Classificação é de: 'Sobrepeso'. Por gentileza faça mais exercícios.");
        }
        else if (resultado <= 38.9){
            resultadofinal.setText("Sua Classificação é de: 'Obeso'. Por gentileza faça mais exercícios e um regime.");
        }
        else {
            resultadofinal.setText("Sua Classificação é de: 'Obesidade GRAVE'. Por gentileza faça mais exercícios e um regime imediatamente, pois sua vida pode estar em risco.");
        }

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

}}
