package br.ufv.caf.modelo.entidade;

/**
 *
 * @author fabriciosilva
 */
public class Candidato extends Docente {
    private int numero;
    
    public Candidato(String nome, 
                    int matricula,
                    String departamento,
                    int numero){
        super(nome, matricula, departamento);
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }
   
    @Override
    public String toString(){
        return super.toString()+
                "\tCandidato: "+numero+"\n";
    }
}