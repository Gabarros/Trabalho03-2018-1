package com.example.gabriel.lista_trabalho3.model;

public class Oficina {

    private String nome;
    private String rua;
    private String bairro;
    private String municipio;
    private long latitude;
    private long longitude;

    public Oficina(String nome, String rua, String bairro, String municipio){
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.municipio = municipio;

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
}
