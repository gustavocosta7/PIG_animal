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
public class Animal {
    private Long anicodigo;
    private Raca raca;
    private String aninome;
    private String aniproprietario;

    public Animal() {
    }

    public Animal(Long anicodigo, Raca raca, String aninome, String aniproprietario) {
        this.anicodigo = anicodigo;
        this.raca = raca;
        this.aninome = aninome;
        this.aniproprietario = aniproprietario;
    }

    public Animal(Raca raca, String aninome, String aniproprietario) {
        this.raca = raca;
        this.aninome = aninome;
        this.aniproprietario = aniproprietario;
    }

    public Long getAnicodigo() {
        return anicodigo;
    }

    public void setAnicodigo(Long anicodigo) {
        this.anicodigo = anicodigo;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public String getAninome() {
        return aninome;
    }

    public void setAninome(String aninome) {
        this.aninome = aninome;
    }

    public String getAniproprietario() {
        return aniproprietario;
    }

    public void setAniproprietario(String aniproprietario) {
        this.aniproprietario = aniproprietario;
    }
    
    
}
