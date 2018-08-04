package com.example.gabriel.lista_trabalho3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.gabriel.lista_trabalho3.activity.ListaMecanico;
import com.example.gabriel.lista_trabalho3.activity.ListaOficina;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity{

Button btoficina, btmecanico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btoficina = (Button) findViewById(R.id.btOficina);
        btmecanico = (Button) findViewById(R.id.btMecanico);

        Realm realm = Realm.getDefaultInstance();

        realm.close();


        btoficina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaOficina.class);
                startActivity(intent);
            }
        });

        btmecanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaMecanico.class);
                startActivity(intent);
            }
        });
    }




}
