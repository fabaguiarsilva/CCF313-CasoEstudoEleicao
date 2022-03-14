package br.ufv.caf.modelo.persistencia;

import br.ufv.caf.modelo.entidade.Candidato;
import java.util.ArrayList;

public class DAOCandidato {
    private static ArrayList<Candidato> candidatos;
    
    static {
        candidatos = new ArrayList<Candidato>();
    }
        
    public void inserir(Candidato c){
        candidatos.add(c);
    }
    
    public void remover(int numero){
        for(int i=0; i<candidatos.size(); i++){
            if(candidatos.get(i).getNumero() ==
                    numero){
                candidatos.remove(i);
            }
        }
    }
    
    public Candidato pesquisar(int numero){
        for(Candidato c : candidatos){
            if(c.getNumero() == numero){
                return c;
            }
        }
        return null;
    }
    
    public ArrayList<Candidato> listarTodos(){
        return candidatos;
    }
    
    
}
