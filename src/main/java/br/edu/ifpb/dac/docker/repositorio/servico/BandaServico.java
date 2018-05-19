/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.docker.repositorio.servico;

import br.edu.ifpb.dac.docker.entidades.Banda;
import br.edu.ifpb.dac.docker.repositorio.Bandas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class BandaServico {
    private Bandas bandas;

    public BandaServico()  {
        try {
            this.bandas = new Bandas();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BandaServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Banda buscar(int id){
        return bandas.buscar(id);
    }
    public List<Banda> todos(){
        return bandas.todos();
    }
}
