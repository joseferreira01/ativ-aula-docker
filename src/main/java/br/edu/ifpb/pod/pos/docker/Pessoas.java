/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.pos.docker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Pessoas {
     private Connection connection;

    public Pessoas() throws ClassNotFoundException {
         try {
             Class.forName("org.postgresql.Driver");
             connection = DriverManager.getConnection("jdbc:postgresql://host-banco:5432/pessoas", "postgres", "12345");
         } catch (SQLException ex) {
             Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void salvar(Pessoa pessoa) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into pessoa(nome,cpf) values (?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getCPF());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public List<Pessoa> todos() {
        List<Pessoa> lista = new ArrayList<Pessoa>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from pessoa");
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setCPF(rs.getString("cpf"));
                lista.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
