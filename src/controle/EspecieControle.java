/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.EspecieDao;
import java.util.ArrayList;
import java.util.List;
import modelo.Especie;

/**
 *
 * @author 600109
 */
public class EspecieControle {
    private Especie especie = new Especie();
    private List<Especie> especies = new ArrayList();

    public EspecieControle() {
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public List<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }
    
    public void listar(){
        EspecieDao dao = new EspecieDao();
        this.especies = dao.listar();
    }
}
