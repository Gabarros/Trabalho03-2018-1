package com.example.gabriel.lista_trabalho3.model;

import java.io.Serializable;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Mecanico extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String nome;
    private String funcao;
    private String rua;
    private String bairro;
    private String municipio;
    private Date data_nascimento;
    private long latitude;
    private long longitude;

    public Mecanico(){

    }

    public Mecanico(int id, String nome, Date data_nascimento, String rua, String bairro, String municipio){
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.rua = rua;
        this.bairro = bairro;
        this.municipio = municipio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
