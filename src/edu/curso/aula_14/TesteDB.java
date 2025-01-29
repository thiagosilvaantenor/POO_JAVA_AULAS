package edu.curso.aula_14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteDB {
  final static String URL = "jdbc:mariadb://localhost:3306/agendadb?allowMultiQueries=true";
  final static String USER = "root";
  final static String PASS = "123456";

  public static void main(String[] args) {
    System.out.println("Ola mundo");
    try {
      //Driver do mariadb
      Class.forName("org.mariadb.jdbc.Driver");
      Connection con = DriverManager.getConnection(URL, USER, PASS);
      System.out.println("Conectando no database");

      PreparedStatement stm = con.prepareStatement("SELECT * FROM contatos");
      ResultSet rs = stm.executeQuery();
      while (rs.next()) {
        String nome = rs.getString("nome");
        String email = rs.getString("email");
        String telefone = rs.getString("telefone");
        System.out.printf("Nome: %s  Email: %s Tel: %s%n", nome, email, telefone);
      }
    } catch (SQLException e) {
      System.out.println("Erro ao conectar");
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.out.println("Erro ao carregar a classe");
      e.printStackTrace();
    } 
  }
}
