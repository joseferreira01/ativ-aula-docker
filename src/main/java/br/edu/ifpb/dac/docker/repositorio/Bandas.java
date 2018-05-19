package br.edu.ifpb.dac.docker.repositorio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.edu.ifpb.dac.docker.entidades.Album;
import br.edu.ifpb.dac.docker.entidades.Banda;
import br.edu.ifpb.dac.docker.entidades.Estilo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Bandas {
     private Connection connection;

    public Bandas() throws ClassNotFoundException {
         try {
             Class.forName("org.postgresql.Driver");
             connection = DriverManager.getConnection("jdbc:postgresql://host-banco:5432/atividade-docker", "postgres", "12345");
         } catch (SQLException ex) {
             Logger.getLogger(Bandas.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

  
    
     public Banda buscar(int id) {
        List<Album> lista = new ArrayList<Album>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select b.nome, b.localDeOrigem, b.id, in.integrante innome "
                    + "from banda, integrante in where id ="+id+"");
             List<String> integrantes = new ArrayList<>();
            while (rs.next()) {
                integrantes.add("innome");
             Banda b =  Banda.of(rs.getInt("id"),rs.getString("nome"), rs.getString("localDeOrigem"), integrantes);
                 connection.close();
                 return b;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return Banda.of("none", "none", Collections.EMPTY_LIST);
     }
     public List<Banda> todos() {
        List<Banda> lista = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select b.nome, b.localDeOrigem, b.id, in.integrante innome "
                    + "from banda, integrante in ");
             List<String> integrantes = new ArrayList<>();
            while (rs.next()) {
                integrantes.add("innome");
             Banda b =  Banda.of(rs.getInt("id"),rs.getString("nome"), rs.getString("localDeOrigem"), integrantes);
             lista.add(b);
                 connection.close();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       

        return  lista;
    }
     public void delete(Album album){
           try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete Album where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1,album.getId());

            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
         
     }
}
