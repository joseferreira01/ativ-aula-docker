package br.edu.ifpb.dac.docker.repositorio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.edu.ifpb.dac.docker.entidades.Album;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Albums {
     private Connection connection;
     private bandas bandas;
      

    public Albums() throws ClassNotFoundException {
        this.bandas = new bandas();
         try {
             Class.forName("org.postgresql.Driver");
             connection = DriverManager.getConnection("jdbc:postgresql://host-banco:5432/atividade-docker", "postgres", "12345");
         } catch (SQLException ex) {
             Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void salvar(Album album) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into album(anoDeLancamento) values (?, ?)");
            // Parameters start with 1
            preparedStatement.setDate(1,Date.valueOf(album.getAnoDeLancamento()));
            preparedStatement.setString(2, album.getEstilo().toString());
            preparedStatement.setInt(3,album.getBanda().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public List<Album> todos() {
        List<Album> lista = new ArrayList<Album>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Album");
            while (rs.next()) {
                Album album = new Album(Estilo.valueOf(rs.getString("estilo")), bandas.buscar(rs.getInt("banda")), rs.getDate("anoDeLancamento").toLocalDate());
                
                
                lista.add(album);
                 connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       

        return lista;
    }
     public Album buscar(int id) throws ClassNotFoundException {
         bandas = new bandas();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Album where id "+id+"");
            while (rs.next()) {
                Album album = new Album(Estilo.valueOf(rs.getString("estilo")), bandas.buscar(rs.getInt("banda")), rs.getDate("anoDeLancamento").toLocalDate());
                 connection.close();
                 return album;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
