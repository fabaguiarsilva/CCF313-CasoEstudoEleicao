package br.ufv.caf.modelo.persistencia;
import br.ufv.caf.modelo.entidade.EntidadeBase;
import java.util.ArrayList;

/**
 *
 * @author fabriciosilva
 * @param <T>
 */
public class DAOGenerico<T extends EntidadeBase> {
     private ArrayList<T> elementos;

    public DAOGenerico(){
        elementos = new ArrayList<T>();
    }
    
    public void inserir(T e){
        elementos.add(e);
    }
    
    public void remover(int id){
        for(int i=0; i<elementos.size(); i++){
            if(elementos.get(i).getId()== id){
                elementos.remove(i);
                break;
            }
        }        
    }
    
    public T pesquisar(int id){
        for(T e : elementos){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }    

    public ArrayList<T> listarTodos() {
        return elementos;
    }
}
