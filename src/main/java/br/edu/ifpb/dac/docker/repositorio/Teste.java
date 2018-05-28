/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.docker.repositorio;

import br.edu.ifpb.dac.docker.entidades.Album;
import br.edu.ifpb.dac.docker.entidades.Banda;
import br.edu.ifpb.dac.docker.entidades.Estilo;
import java.time.LocalDate;

/**
 *
 * @author jose
 */
public class Teste {

    public static void main(String[] args) throws ClassNotFoundException {

        Banda b = Banda.of("PiN2", "Sousa", null);
        b.setId(2);
        Albums as = new Albums();
//        as.salvar(Album.of("album2", Estilo.Pop, b, LocalDate.now()));
        Album z = as.buscar(3);
        z.setId(2);
        as.delete(z);
        System.out.println("busca "+z.getBanda().getId());
//        Bandas bandas = new Bandas();
//        Banda v = bandas.buscar(2);
//        System.err.println("vvv "+v.getNome());
    }
}
