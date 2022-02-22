package br.ufv.caf.modelo.entidade;

/**
 *
 * @author fabriciosilva
 */
public class VotoConsolidado implements Comparable<VotoConsolidado>{
    private int numeroCandidato;
    private int votos;
    
    public VotoConsolidado(int numeroCandidato){
        this.numeroCandidato=numeroCandidato;
        this.votos = 0;
    }
    
    public int getNumeroCandidato(){
        return this.numeroCandidato;
    }
    
    public void incrementaVoto(){
        this.votos++;
    }
    
    public int getVotos(){
        return votos;
    }       

    @Override            
    /**
     * Ordena de forma descendente, já que o 
     * primeiro deve ser o com maior número de votos
     */
    public int compareTo(VotoConsolidado arg0) {
        if(this.votos < arg0.getVotos()){
            return 1;
        }else if(this.votos > arg0.getVotos()){
            return -1;
        }else{
            return 0;
        }        
    }
}
