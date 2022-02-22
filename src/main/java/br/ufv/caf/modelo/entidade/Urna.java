package br.ufv.caf.modelo.entidade;

import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author fabriciosilva
 */
public class Urna {
    private static final Logger LOGGER = Logger.getLogger("br.ufv.caf.eleicao");    
    private ArrayList<Cedula> listaCedulas;
    private ArrayList<VotoConsolidado> votosConsolidados;    
    
    public Urna(){
        listaCedulas = new ArrayList();
        votosConsolidados =
                new ArrayList<VotoConsolidado>();        
    }
    
    public boolean isVazia(){
        return listaCedulas.isEmpty();                
    }
    
    public void insereCedula(Cedula cedula){
        listaCedulas.add(cedula);
        adicionaVoto(cedula);
    }
    
    public void limpaUrna(){
        listaCedulas.clear();
    }
    
    public void adicionaCandidatoZerado(Candidato c){
        VotoConsolidado voto = 
                        new VotoConsolidado(c.getNumero());
        votosConsolidados.add(voto);        
    }
    
    /**
     * 
     * @return um hashmap em que a chave é o número do
     * candidato, e o valor é a quantidade de votos
     */
    public ArrayList<VotoConsolidado> contabilizaVotos(){
        
        for(VotoConsolidado voto : votosConsolidados){
            LOGGER.info("Candidato "+voto.getNumeroCandidato()+
                    " teve "+voto.getVotos()+ " votos!");
        }
        
        return votosConsolidados;
    }
        
    private void adicionaVoto(Cedula c){        
        for(VotoConsolidado voto : votosConsolidados){
            if(voto.getNumeroCandidato() ==
                        c.getNumeroCandidato()){
                voto.incrementaVoto();
                return;
            }
        } 
        //TODO tratar voto nulo
    }    
}
