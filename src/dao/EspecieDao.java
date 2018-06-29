/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Especie;

/**
 *
 * @author 600109
 */
public class EspecieDao {

    public List<Especie> listar(){

        List<Especie> especies = new ArrayList();
        Connection connection = null;
        try {
            connection = ControlaConexao.getConnection();
            String sql = "select espcodigo, espnome from especie";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Especie especie = new Especie(rs.getLong("espcodigo"), rs.getString("espnome"));
                especies.add(especie);
            }
             connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
       
        return especies;
    }

    public Especie consultaEspecie(Long id) throws SQLException{
        Especie e = new Especie();
        Connection connection = null;
   
            connection = ControlaConexao.getConnection();
            String sql = "select *from especie where espcodigo = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               Especie especie = new Especie(rs.getLong("espcodigo"),rs.getString("espnome"));
            }

             connection.close();
       
        return e;

    }
}
