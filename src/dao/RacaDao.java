/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Raca;

/**
 *
 * @author 600109
 */
public class RacaDao {

    public List<Raca> listar() {
        List<Raca> racas = new ArrayList();

        try {
            Connection connection = ControlaConexao.getConnection();
            String sql = "select raccodigo, racnome , racespcodigo from raca";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                EspecieDao dao = new EspecieDao();
                Raca raca = new Raca(rs.getLong("raccodigo"),dao.consultaEspecie(rs.getLong("racespcodigo")),rs.getString("racnome"));
                
                racas.add(raca);
                
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return racas;
    }

    public Raca consultaRaca(long id) {
      Connection conexao = null;
      Raca raca = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "select *from raca where raccodigo = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                EspecieDao dao = new EspecieDao();
                raca = new Raca(rs.getLong("raccodigo"),dao.consultaEspecie(rs.getLong("racespcodigo")),rs.getString("racnome"));
            }
            
            conexao.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        
        }
        return raca;
    }

}
