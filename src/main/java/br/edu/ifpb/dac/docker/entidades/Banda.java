/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.docker.entidades;

import java.util.List;

/**
 *
 * @author jose
 */
public class Banda {
    private int id;
     private String nome;
    private String localDeOrigem;
    private List<String> integrates;

    public Banda() {
    }

    public Banda(String nome, String localDeOrigem, List<String> integrates) {
        this.nome = nome;
        this.localDeOrigem = localDeOrigem;
        this.integrates = integrates;
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

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public List<String> getIntegrates() {
        return integrates;
    }

    public void setIntegrates(List<String> integrates) {
        this.integrates = integrates;
    }
    
}
