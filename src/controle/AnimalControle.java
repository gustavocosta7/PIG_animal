/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AnimalDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Animal;

/**
 *
 * @author 600109
 */
public class AnimalControle {
    private List<Animal> animals = new ArrayList();
    private Animal animal = new Animal();

    public AnimalControle() {
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public void inserir() throws SQLException{
        AnimalDao dao = new AnimalDao();
        dao.inserir(animal);
    }
    
    public void listar(){
        AnimalDao dao = new AnimalDao();
        this.animals = dao.listar();
    }
    
    public void remover(){
        AnimalDao dao = new AnimalDao();
        dao.remover(this.animal);
    }
}
