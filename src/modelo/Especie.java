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
public class Especie {
    private Long espcodigo;
    private String espnome;

    public Especie() {
    }

    public Especie(Long espcodigo, String espnome) {
        this.espcodigo = espcodigo;
        this.espnome = espnome;
    }

    public Long getEspcodigo() {
        return espcodigo;
    }

    public void setEspcodigo(Long espcodigo) {
        this.espcodigo = espcodigo;
    }

    public String getEspnome() {
        return espnome;
    }

    public void setEspnome(String espnome) {
        this.espnome = espnome;
    }
    
    
}
