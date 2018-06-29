/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.RacaDao;
import java.util.ArrayList;
import java.util.List;
import modelo.Raca;

/**
 *
 * @author 600109
 */
public class RacaControle {
    private Raca raca = new Raca();
    private List<Raca>racas = new ArrayList();

    public RacaControle() {
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public List<Raca> getRacas() {
        return racas;
    }

    public void setRacas(List<Raca> racas) {
        this.racas = racas;
    }
    
    public void listar(){
        RacaDao racaDAO = new RacaDao();
        this.racas = racaDAO.listar();
    }

}
