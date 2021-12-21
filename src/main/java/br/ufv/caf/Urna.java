package br.ufv.caf;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author fabriciosilva
 */
public class Urna {
    private ArrayList<Cedula> listaCedulas;
    
    public Urna(){
        listaCedulas = new ArrayList();
    }
    
    public boolean isVazia(){
        return listaCedulas.isEmpty();                
    }
    
    public void insereCedula(Cedula cedula){
        listaCedulas.add(cedula);
    }
    
    public void limpaUrna(){
        listaCedulas.clear();
    }
    
    /**
     * 
     * @return um hashmap em que a chave é o número do
     * candidato, e o valor é a quantidade de votos
     */
    public HashMap<Integer, Integer> contabilizaVotos(){
        HashMap<Integer, Integer> votosPorCandidato =
                new HashMap();
        
        for(Cedula c : listaCedulas){
            //verifica se o número já foi adicionado
            if(votosPorCandidato.get(c.getNumeroCandidato())
                    == null){
                votosPorCandidato.put(c.getNumeroCandidato(),1);
            }else{
                int votoAnterior = votosPorCandidato.get(c.getNumeroCandidato());
                votosPorCandidato.put(c.getNumeroCandidato(),votoAnterior+1);
            }
        }
        return votosPorCandidato;
    }    
}
