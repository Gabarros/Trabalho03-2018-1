package com.example.gabriel.lista_trabalho3.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gabriel.lista_trabalho3.R;
import com.example.gabriel.lista_trabalho3.model.Oficina;

import io.realm.Realm;

public class OficinaDetalhe extends AppCompatActivity {
    String nome, rua, bairro, municipio;

    EditText etnomeoficina = (EditText) findViewById(R.id.etNomeOficina);
    EditText etruaoficina = (EditText) findViewById(R.id.etRuaOficina);
    EditText etbairrooficina = (EditText) findViewById(R.id.etBairroOficina);
    EditText etmunicipiooficina = (EditText) findViewById(R.id.etMunicipioOficina);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficina_detalhe);

        final Realm realm = Realm.getDefaultInstance();

        Intent intent = getIntent();

        final int id = intent.getIntExtra("id", 0);
        final Oficina oficina = realm.where(Oficina.class).equalTo("id", id)
                .findFirst();

        Button btok = (Button) findViewById(R.id.btOkOficina);
        Button btlimpar = (Button) findViewById(R.id.btLimparOficina);

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome = etnomeoficina.getText().toString();
                rua = etruaoficina.getText().toString();
                bairro = etbairrooficina.getText().toString();
                municipio= etmunicipiooficina.getText().toString();

                Oficina a = new Oficina();

                a.setNome(nome);
                a.setRua(rua);
                a.setBairro(bairro);
                a.setMunicipio(municipio);

                realm.beginTransaction();
                realm.copyToRealm(a);
                realm.commitTransaction();
                realm.close();

            }
        });



    }
}
