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
import modelo.Animal;

/**
 *
 * @author 600109
 */
public class AnimalDao {

    public void inserir(Animal animal) {
        Connection connection = null;
        
        try {
            connection = ControlaConexao.getConnection();
            String sql = "insert into animal (aninome, aniproprietario, aniraccodigo) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, animal.getAninome());
            ps.setString(2, animal.getAniproprietario());
            ps.setLong(3, animal.getRaca().getRaccodigo());
            
            ps.execute();
            
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }

    public List<Animal> listar() {
        
        List<Animal> animals = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ControlaConexao.getConnection();
            String sql = "select *from animal";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                RacaDao dao = new RacaDao();
                Animal animal = new Animal(rs.getLong("anicodigo"),dao.consultaRaca(rs.getLong("aniraccodigo")),
                                            rs.getString("aninome"),rs.getString("aniproprietario"));
                
                animals.add(animal);
            }
             connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return animals;
    }

    public void remover(Animal animal) {
       Connection conexao = null;
        try {
            conexao = ControlaConexao.getConnection();
            String sql = "delete from animal where anicodigo = ?";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setLong(1, animal.getAnicodigo());
            st.execute();
            
            conexao.close();
            
        } catch (SQLException ex) {
            System.out.println("erro ao remover animal" + ex.getMessage());
        } 
    }
    
}
