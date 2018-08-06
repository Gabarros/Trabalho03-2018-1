package com.example.gabriel.lista_trabalho3.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Oficina extends RealmObject implements Serializable{

    @PrimaryKey
    private int id;
    private String nome;
    private String rua;
    private String bairro;
    private String municipio;
    private long latitude;
    private long longitude;

    public Oficina(){

    }

    public Oficina(int id, String nome, String rua, String bairro, String municipio){
        this.setId(id);
        this.setNome(nome);
        this.setRua(rua);
        this.setBairro(bairro);
        this.setMunicipio(municipio);

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
