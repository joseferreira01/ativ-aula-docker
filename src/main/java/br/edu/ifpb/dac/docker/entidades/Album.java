/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.docker.entidades;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author jose
 */
public class Album {

    private int id;
    private String nome;
    private Estilo estilo; //Rock, Pop, Sertanejo
    private Banda banda;
    private LocalDate anoDeLancamento;

    public Album() {
    }

    private Album(int id, String nome, Estilo estilo, Banda banda, LocalDate anoDeLancamento) {
        this.id = id;
        this.nome = nome;
        this.estilo = estilo;
        this.banda = banda;
        this.anoDeLancamento = anoDeLancamento;
    }

    public static Album of(int id, String nome, Estilo estilo, Banda banda, LocalDate anoDeLancamento) {
        return new Album(id, nome, estilo, banda, anoDeLancamento);
    }

    public static Album of(String nome, Estilo estilo, Banda banda, LocalDate anoDeLancamento) {
        return new Album(-1, nome, estilo, banda, anoDeLancamento);
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

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public LocalDate getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(LocalDate anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", nome=" + nome + ", estilo=" + estilo + ", banda=" + banda + ", anoDeLancamento=" + anoDeLancamento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

}
