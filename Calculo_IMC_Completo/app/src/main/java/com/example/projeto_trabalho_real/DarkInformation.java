package com.example.projeto_trabalho_real;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DarkInformation extends AppCompatActivity {

    EditText nome, peso, altura;
    ImageButton masculino, feminino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darkinformation);

        nome = (EditText) findViewById(R.id.InformationeditTextNome);
        peso = (EditText) findViewById(R.id.InformationeditTextPeso);
        altura = (EditText) findViewById(R.id.InformationeditTextAltura);
        masculino = (ImageButton) findViewById(R.id.InformationbtMasculino);
        feminino = (ImageButton) findViewById(R.id.InformationbtFeminino);

        masculino.setOnClickListener(new View.OnClickListener() {

            // Irá verificar se os campos então vazios
            public String validar(){
                String texto_erros="";
                if (nome.getText().toString().equals("")){
                    texto_erros = "Campo nome é obrigatório\n";
                    nome.setError("Este campo é obrigatório");
                }
                if (peso.getText().toString().equals("")){
                    texto_erros = "Campo peso é obrigatório\n";
                    peso.setError("Este campo é obrigatório");
                }
                if (altura.getText().toString().equals("")){
                    texto_erros = "Campo altura é obrigatório\n";
                    altura.setError("Este campo é obrigatório");
                }
                return texto_erros;
            }
            @Override
            public void onClick(View v) {

                String erros = validar();
                if (erros.equals("")){
                String txtNome = nome.getText().toString();
                String txtPeso = peso.getText().toString().trim();
                String txtAltura = altura.getText().toString().trim();

                Double peso = Double.parseDouble(txtPeso);
                Double altura = Double.parseDouble(txtAltura);

                Double imc = peso/(altura*altura);

                Intent masculino = new Intent(getApplicationContext(), DarkMasculino.class);

                Bundle dadosM = new Bundle();

                dadosM.putString("nome", txtNome);
                dadosM.putString("peso", txtPeso);
                dadosM.putString("altura", txtAltura);
                dadosM.putString("imc", String.valueOf(imc));

                masculino.putExtras(dadosM);

                startActivity(masculino);
            }else {
                Toast.makeText(DarkInformation.this, "Verifique os erros: "+ erros, Toast.LENGTH_SHORT).show();//Detectado erros
            }}
        });

        feminino.setOnClickListener(new View.OnClickListener() {

            public String validar() {
                String texto_erros = "";
                if (nome.getText().toString().equals("")) {
                    texto_erros = "Campo nome é obrigatório\n";
                    nome.setError("Este campo é obrigatório");
                }
                if (peso.getText().toString().equals("")) {
                    texto_erros = "Campo peso é obrigatório\n";
                    peso.setError("Este campo é obrigatório");
                }
                if (altura.getText().toString().equals("")) {
                    texto_erros = "Campo altura é obrigatório\n";
                    altura.setError("Este campo é obrigatório");
                }
                return texto_erros;
            }
            @Override
            public void onClick(View v) {

                String erros = validar();
                if (erros.equals("")){
                String txtNome = nome.getText().toString();
                String txtPeso = peso.getText().toString();
                String txtAltura = altura.getText().toString();

                Double peso = Double.parseDouble(txtPeso);
                Double altura = Double.parseDouble(txtAltura);

                Double imc = peso/(altura*altura);

                Intent feminino = new Intent(getApplicationContext(), DarkFeminino.class);

                Bundle dadosF = new Bundle();

                dadosF.putString("nome", txtNome);
                dadosF.putString("peso", txtPeso);
                dadosF.putString("altura", txtAltura);
                dadosF.putString("imc", String.valueOf(imc));

                feminino.putExtras(dadosF);

                startActivity(feminino);

            }else {
                Toast.makeText(DarkInformation.this, "Verifique os erros: "+ erros, Toast.LENGTH_SHORT).show();//Detectado erros
            }
            }
        });
}}

