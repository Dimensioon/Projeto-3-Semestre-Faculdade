package com.example.projeto_trabalho_real;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    // Variaveis
    Button btOK;
    Switch mod;

    // Codigo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btOK = (Button) findViewById(R.id.MainButton);
        mod = (Switch) findViewById(R.id.SwitchMod);

        mod.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean ModoEscuro) {
                if (ModoEscuro) {
                    // The toggle is enabled
                    btOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View test) {
                            Intent it = new Intent(getApplicationContext(), DarkInformation.class);
                            startActivity(it);

                        }
                    });
                } else {
                    // The toggle is disabled
                    btOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View test) {
                            Intent it = new Intent(getApplicationContext(), LightInformation.class);
                            startActivity(it);

                        }
                    });
                }
            }
        });

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View test) {
                Intent it = new Intent(getApplicationContext(), LightInformation.class);
                startActivity(it);

            }
        });


    }
}
