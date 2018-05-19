/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.docker.view;

import br.edu.ifpb.dac.docker.entidades.Album;
import br.edu.ifpb.dac.docker.entidades.Banda;
import br.edu.ifpb.dac.docker.repositorio.servico.AlbumServico;
import br.edu.ifpb.dac.docker.repositorio.servico.BandaServico;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jose
 */
@Named
@RequestScoped
public class BandaControler {
    @Inject
    private Mensagem  m;
    private BandaServico servico;
    @PostConstruct
    public void init(){
        this.servico = new BandaServico();
        
    }
    public Banda buscar(int id){
       return servico.buscar(id);
        
    }
      public List<Banda> todos(){
        return servico.todos();
    }
    
}
