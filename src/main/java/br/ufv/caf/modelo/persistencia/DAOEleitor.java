package br.ufv.caf.modelo.persistencia;

import br.ufv.caf.modelo.entidade.Eleitor;
import java.util.ArrayList;

public class DAOEleitor {
    private static ArrayList<Eleitor> eleitores;
    
    static {
        eleitores = new ArrayList<Eleitor>();
    }
        
    public void inserir(Eleitor e){
        eleitores.add(e);
    }
    
    public void remover(int matricula){
        for(int i=0; i<eleitores.size(); i++){
            if(eleitores.get(i).getMatricula() ==
                    matricula){
                eleitores.remove(i);
            }
        }
    }
    
    public Eleitor pesquisar(int matricula){
        for(Eleitor e : eleitores){
            if(e.getMatricula() == matricula){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList<Eleitor> listarTodos(){
        return eleitores;
    }
}
