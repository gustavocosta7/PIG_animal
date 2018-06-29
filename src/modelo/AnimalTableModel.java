/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 600109
 */
public class AnimalTableModel extends AbstractTableModel{
    Animal a = new Animal();
    List<Animal> animais;

    public AnimalTableModel(List<Animal> animais) {
        this.animais = animais;
    }
    
    @Override
    public int getRowCount() {
        return animais.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Animal a = animais.get(linha);
        switch(coluna){
            case 0:
                return a.getAninome();
            case 1:
                return a.getAniproprietario();
            case 2:
                return a.getRaca().getRacnome();
        }
        return null;
    
    }
    
    @Override
    public String getColumnName(int coluna){
        switch (coluna) {
            case 0:
                return "Animal";
            case 1:
                return "Proprietario";
            case 2:
                return "Raca";
        }
        return null;
    }

    
    
}
