/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.pos.docker;

/**
 *
 * @author jose
 */
public class Pessoa {
    private int id;
    private String nome;
    private String CPF;

    public Pessoa() {
    }

    private Pessoa( String nome, String CPF) {
        this.id = -1;
        this.nome = nome;
        this.CPF = CPF;
    }
    public static Pessoa of( String nome, String CPF) {
      return new Pessoa(nome, CPF);
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    
}
