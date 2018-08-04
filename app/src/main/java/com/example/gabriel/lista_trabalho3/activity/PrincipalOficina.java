package com.example.gabriel.lista_trabalho3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gabriel.lista_trabalho3.R;

public class PrincipalOficina extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] activities = {"ListaOficina"};
    private String[] itemMenu = {"Adicionar Oficinas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_oficina);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemMenu);

        ListView listView = (ListView) findViewById(R.id.ListaOficina);
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
