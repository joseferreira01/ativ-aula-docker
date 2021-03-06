/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.docker.view;

import br.edu.ifpb.dac.docker.entidades.Album;
import br.edu.ifpb.dac.docker.repositorio.servico.AlbumServico;
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
public class AlbumControler {
    @Inject
    private Mensagem  m;
    private Album album;
    private AlbumServico servico;
    @PostConstruct
    public void init(){
        this.servico = new AlbumServico();
        this.album = new Album();
    }
    public void salvar(){
        try {
            this.servico.salvar(album);
            m.addMessage("Album salvo com sucesso");
        } catch (Exception e) {
            m.addMessage("Erro ao salvo ");
        }
        
    }
    
}
