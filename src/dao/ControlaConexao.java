/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 600109
 */
public class ControlaConexao {
   public static Connection getConnection() throws SQLException{
       return DriverManager.getConnection("jdbc:mysql://localhost/pig","root","");
   }
   
   public static void closeConnection(Connection connection) throws SQLException{
       try {
           if(connection != null){
               connection.close();
           }
       } catch (SQLException e) {
           new DaoException("Erro ao fechar a conexao", e);
       }
   }
   
}
