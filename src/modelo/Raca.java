/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 600109
 */
public class Raca {
    private Long raccodigo;
    private Especie especie;
    private String racnome;

    public Raca() {
    }

    public Raca(Long raccodigo, Especie especie, String racnome) {
        this.raccodigo = raccodigo;
        this.especie = especie;
        this.racnome = racnome;
    }

    public Raca(Especie especie, String racnome) {
        this.especie = especie;
        this.racnome = racnome;
    }

    public Long getRaccodigo() {
        return raccodigo;
    }

    public void setRaccodigo(Long raccodigo) {
        this.raccodigo = raccodigo;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getRacnome() {
        return racnome;
    }

    public void setRacnome(String racnome) {
        this.racnome = racnome;
    }
    
    
}
