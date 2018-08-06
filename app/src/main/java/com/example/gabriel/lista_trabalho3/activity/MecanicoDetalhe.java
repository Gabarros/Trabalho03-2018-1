package com.example.gabriel.lista_trabalho3.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.gabriel.lista_trabalho3.R;
import com.example.gabriel.lista_trabalho3.model.Mecanico;

import io.realm.Realm;

public class MecanicoDetalhe extends AppCompatActivity {
    EditText etNome, etFuncao, etData, etRua, etBairro, etMunicipio;

    Button btsalvar, btalterar, btdeletar;

    int id;
    Mecanico mecanico;
    private Realm realm;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanico_detalhe);

        etNome = (EditText) findViewById(R.id.etNomeMecanico);
        etFuncao = (EditText) findViewById(R.id.etFuncaoMecanico);
        etRua = (EditText) findViewById(R.id.etRuaMecanico);
        etBairro = (EditText) findViewById(R.id.etBairroMecanico);
        etMunicipio = (EditText) findViewById(R.id.etMunicipioMecanico);
        etData = (EditText) findViewById(R.id.etDataMecanico);

        btsalvar = (Button) findViewById(R.id.btOkMecanico);
        btalterar = (Button) findViewById(R.id.btAlterarMecanico);
        btdeletar = (Button) findViewById(R.id.btDeletarMecanico);


        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            mecanico = realm.where(Mecanico.class).equalTo("id",id).findFirst();


            etNome.setText(mecanico.getNome());
            etFuncao.setText(mecanico.getFuncao());
            etData.setText(formato.format(mecanico.getData_nascimento()));
            etRua.setText(mecanico.getRua());
            etBairro.setText(mecanico.getBairro());
            etMunicipio.setText(mecanico.getMunicipio());

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
        mecanico.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Mecanico deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {

        int proximoID = 1;
        if(realm.where(Mecanico.class).max("id") !=null)
            proximoID = realm.where(Mecanico.class).max("id").intValue()+1;

        realm.beginTransaction();
        Mecanico mecanico = new Mecanico();
        mecanico.setId(proximoID);
        setEGrava(mecanico);

        realm.copyToRealm(mecanico);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Mecanico Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    private void setEGrava(Mecanico mecanico){

        mecanico.setNome(etNome.getText().toString());
        mecanico.setFuncao(etFuncao.getText().toString());
        mecanico.setRua(etRua.getText().toString());
        mecanico.setBairro(etBairro.getText().toString());
        mecanico.setMunicipio(etMunicipio.getText().toString());

        try {
            mecanico.setData_nascimento((Date) formato.parse(etData.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
    public void alterar() {

        realm.beginTransaction();

        setEGrava(mecanico);

        realm.copyToRealm(mecanico);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Mecanico Alterado",Toast.LENGTH_LONG).show();
        this.finish();

    }



    }


