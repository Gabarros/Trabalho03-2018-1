package com.example.gabriel.lista_trabalho3.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import com.example.gabriel.lista_trabalho3.R;
import com.example.gabriel.lista_trabalho3.adapter.OficinaAdapter;
import com.example.gabriel.lista_trabalho3.model.Oficina;


import java.util.ArrayList;
import java.util.List;


import io.realm.Realm;


public class ListaOficina extends AppCompatActivity{

    private List<Oficina> listaOficinas;

   private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        realm = Realm.getDefaultInstance();
        setContentView(R.layout.activity_lista_oficina);

    }

    public void onStart(){
        super.onStart();
        ListView lista = (ListView) findViewById(R.id.lvOficinas);

       listaOficinas = (List)realm.where(Oficina.class).findAll();
        OficinaAdapter adapter = new OficinaAdapter(this, (ArrayList<Oficina>) listaOficinas);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaOficina.this, OficinaDetalhe.class);

                intent.putExtra("id",listaOficinas.get(i).getId());
                startActivity(intent);

            }
        });

        Button adicionar_oficina = (Button) findViewById(R.id.btAdicionaOficina);

        Realm realm = Realm.getDefaultInstance();

        adicionar_oficina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaOficina.this, OficinaDetalhe.class);
                intent.putExtra("id",0);
                startActivity(intent);

            }
        });
    }

    public void finish(){
        super.finish();
           realm.close();

    }
}
