package com.example.gabriel.lista_trabalho3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gabriel.lista_trabalho3.R;

public class PrincipalMecanico extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] activities = {"ListaMecanico"};
    private String[] itemMenu = {"Adicionar Mecânicos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_mecanico);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemMenu);

        ListView listView = (ListView) findViewById(R.id.ListaMecanico);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent intent = null;

        try {

            Class obj = Class.forName ("com.example.gabriel.lista_trabalho3.activity"+activities[position]);
            intent = new Intent(this, obj);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        startActivity(intent);

    }
}
