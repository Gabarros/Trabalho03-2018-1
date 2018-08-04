package com.example.gabriel.lista_trabalho3.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import com.example.gabriel.lista_trabalho3.R;
import com.example.gabriel.lista_trabalho3.adapter.MecanicoAdapter;
import com.example.gabriel.lista_trabalho3.model.Mecanico;
import com.example.gabriel.lista_trabalho3.adapter.ClickRecyclerViewListener2;
import java.util.List;
import io.realm.Realm;


public class ListaMecanico extends AppCompatActivity implements ClickRecyclerViewListener2{

    private Realm realm2;
    Button adiciona_mecanico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mecanico);

        realm2 = Realm.getDefaultInstance();
        adiciona_mecanico = findViewById(R.id.btAdicionaMecanico) ;


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
        RecyclerView recyclerView = findViewById(R.id.rvMecanico);

        recyclerView.setAdapter(new MecanicoAdapter(getMecanicos(),this,this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Mecanico> getMecanicos(){

        return realm2.where(Mecanico.class).findAll();

    }
    @Override
    public void onClick(Object object) {
        Mecanico mecanico = (Mecanico) object;
        Intent intent = new Intent(ListaMecanico.this,MecanicoDetalhe.class);
        intent.putExtra("id",mecanico.getId());
        startActivity(intent);
    }

    public void finish(){
        super.finish();
        realm2.close();
    }
}
