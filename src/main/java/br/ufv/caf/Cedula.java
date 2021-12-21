package br.ufv.caf;

import java.util.Date;

/**
 *
 * @author fabriciosilva
 */
public class Cedula {
    private int numeroCandidato;
    private Date dataVoto;
    
    public Cedula(int numeroCandidato){
        //a data é o momento que a cedula foi criada
        dataVoto = new Date();        
        this.numeroCandidato=numeroCandidato;        
    }
    
    public int getNumeroCandidato(){
        return this.numeroCandidato;
    }    
}
