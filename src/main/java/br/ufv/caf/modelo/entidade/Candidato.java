package br.ufv.caf.modelo.entidade;

/**
 *
 * @author fabriciosilva
 */
public class Candidato {
    private String nome;
    private int numero;
    
    public Candidato(String nome, int numero){
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }
}