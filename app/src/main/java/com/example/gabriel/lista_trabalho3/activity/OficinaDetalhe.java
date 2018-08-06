package com.example.gabriel.lista_trabalho3.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gabriel.lista_trabalho3.R;
import com.example.gabriel.lista_trabalho3.model.Oficina;

import io.realm.Realm;

public class OficinaDetalhe extends AppCompatActivity {



    Button btsalvar, btalterar, btdeletar;
    EditText etnomeoficina, etruaoficina, etbairrooficina, etmunicipiooficina;

    int id;
    Oficina oficina;
    private Realm realm;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficina_detalhe);


       etnomeoficina = (EditText) findViewById(R.id.etNomeMecanico);
       etruaoficina = (EditText) findViewById(R.id.etRuaOficina);
       etbairrooficina = (EditText) findViewById(R.id.etBairroOficina);
       etmunicipiooficina = (EditText) findViewById(R.id.etMunicipioOficina);

        btsalvar = (Button) findViewById(R.id.btOkOficina);
        btdeletar = (Button) findViewById(R.id.btDeletarOficina);
        btalterar = (Button) findViewById(R.id.btDeletarOficina);

        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            oficina = realm.where(Oficina.class).equalTo("id",id).findFirst();


            etnomeoficina.setText(oficina.getNome());
            etruaoficina.setText(oficina.getRua());
            etbairrooficina.setText(oficina.getBairro());
            etmunicipiooficina.setText(oficina.getMunicipio());

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }

        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }
    public void deletar(){
        realm.beginTransaction();
        oficina.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Oficina deletada",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Oficina.class).max("id") !=null)
            proximoID = realm.where(Oficina.class).max("id").intValue()+1;

        realm.beginTransaction();
        Oficina oficina = new Oficina();
        oficina.setId(proximoID);
        setEGrava(oficina);

        realm.copyToRealm(oficina);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Oficina Cadastrada",Toast.LENGTH_LONG).show();
        this.finish();

    }

    private void setEGrava(Oficina oficina){

        oficina.setNome(etnomeoficina.getText().toString());
        oficina.setRua(etruaoficina.getText().toString());
        oficina.setBairro(etbairrooficina.getText().toString());
        oficina.setMunicipio(etbairrooficina.getText().toString());

        realm.copyToRealm(oficina);
        realm.commitTransaction();
        realm.close();

    }
    public void alterar() {

        realm.beginTransaction();

        setEGrava(oficina);

        realm.copyToRealm(oficina);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Oficina Alterada",Toast.LENGTH_LONG).show();
        this.finish();

    }

}
