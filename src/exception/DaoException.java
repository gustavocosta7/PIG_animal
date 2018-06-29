/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author 600109
 */
public class DaoException extends Exception{
     public DaoException(String texto){
        super(texto);
    }
    
    public DaoException(Exception e){
        super(e);
    }
    
    public DaoException(String texto, Exception e){
        super(texto,e);
    }
}
