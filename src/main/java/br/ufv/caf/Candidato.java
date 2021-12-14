package br.ufv.caf;

/**
 *
 * @author fabriciosilva
 */
public class Candidato {
    private String nome;
    private int numero;
    private int nVotos;
    
    public Candidato(String nome, int numero){
        this.nome = nome;
        this.numero = numero;
        this.nVotos = 0;
    }

    public void incrementaVoto(){
        this.nVotos++;
    }
    
    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public int getnVotos() {
        return nVotos;
    }
    
    
    
}
