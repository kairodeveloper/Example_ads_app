package com.example.kairo.olxapp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kairo on 11/02/2018.
 */

public class Anuncio{

    private String nome;
    private Double valor;
    private String localizacao;
    private String dateFormated;
    private String descricao;
    private Date data;
    private SimpleDateFormat simpleDateFormat;

    public Anuncio(){}

    public Anuncio(String nome, Double valor, String localizacao, String descricao) {
        this.nome = nome;
        this.valor = valor;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.dateFormated = getData();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getData() {
        data = new Date();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return(simpleDateFormat.format(data));
    }
}
