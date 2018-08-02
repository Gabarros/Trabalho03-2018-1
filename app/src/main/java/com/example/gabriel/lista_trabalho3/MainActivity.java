package com.example.gabriel.lista_trabalho3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gabriel.lista_trabalho3.activity.ListaOficina;

public class MainActivity extends AppCompatActivity {

Button btoficina, btmecanico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btoficina = (Button) findViewById(R.id.btOficina);
        btmecanico = (Button) findViewById(R.id.btMecanico);


    }

    public void proximaTela(View view){

        Intent intent = new Intent(this, ListaOficina.class);
        startActivity(intent);
    }


}
