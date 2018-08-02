package com.example.gabriel.lista_trabalho3.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.gabriel.lista_trabalho3.R;
import com.example.gabriel.lista_trabalho3.adapter.OficinaAdapter;
import com.example.gabriel.lista_trabalho3.model.Oficina;

import java.util.ArrayList;
import java.util.List;

public class ListaOficina extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_oficina);

        Button adicionar_oficina = (Button) findViewById(R.id.btAdicionaOficina);
        ListView lista_oficinas = (ListView) findViewById(R.id.lvOficinas);

        ArrayList<Oficina> oficinas = adicionar_oficinas();
        ArrayAdapter adapter = new OficinaAdapter(this, oficinas);
        lista_oficinas.setAdapter(adapter);

    }

    private ArrayList<Oficina> adicionar_oficinas(){

        ArrayList<Oficina> oficinas = new ArrayList<Oficina>();

        Oficina a = new Oficina("Teste", "Teste", "Teste", "Teste");
        oficinas.add(a);

        Oficina b = new Oficina("Teste", "Teste", "Teste", "Teste");
        oficinas.add(b);

        Oficina c = new Oficina("Teste", "Teste", "Teste", "Teste");
        oficinas.add(c);

        return oficinas;



    }
}
