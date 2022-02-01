package br.ufv.caf.modelo.entidade;

/**
 *
 * @author fabriciosilva
 */
public class Eleitor {
    private int matricula;
    private String nome;
    
    public Eleitor(String nome, int matricula){
        this.nome=nome;
        this.matricula=matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }       
}
