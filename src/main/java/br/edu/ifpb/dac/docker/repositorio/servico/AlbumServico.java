/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.docker.repositorio.servico;

import br.edu.ifpb.dac.docker.entidades.Album;
import br.edu.ifpb.dac.docker.repositorio.Albums;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class AlbumServico {
    private Albums albums;

    public AlbumServico()  {
        try {
            this.albums = new Albums();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlbumServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void salvar(Album album){
        albums.salvar(album);
    }
    
}
