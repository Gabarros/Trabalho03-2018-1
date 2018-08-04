package com.example.gabriel.lista_trabalho3.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


import com.example.gabriel.lista_trabalho3.R;
import com.example.gabriel.lista_trabalho3.adapter.OficinaAdapter;
import com.example.gabriel.lista_trabalho3.model.Oficina;
import com.example.gabriel.lista_trabalho3.adapter.ClickRecyclerViewListener;
import java.util.List;
import io.realm.Realm;


public class ListaMecanico extends AppCompatActivity implements ClickRecyclerViewListener{

    private Realm realm;
    Button adiciona_mecanico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_oficina);

        realm = Realm.getDefaultInstance();
        adiciona_mecanico = (Button) findViewById(R.id.btAdicionaOficina);


        adiciona_mecanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaMecanico.this, MecanicoDetalhe.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });


    }


    protected void onResume() {

        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvOficina);

        recyclerView.setAdapter(new OficinaAdapter(getOficinas(),this,this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Oficina> getOficinas(){

        return realm.where(Oficina.class).findAll();

    }
    @Override
    public void onClick(Object object) {
        Oficina oficina = (Oficina) object;
        Intent intent = new Intent(ListaMecanico.this,MecanicoDetalhe.class);
        intent.putExtra("id",oficina.getId());
        startActivity(intent);
    }


    public void finish(){
        super.finish();
        realm.close();
    }
}
