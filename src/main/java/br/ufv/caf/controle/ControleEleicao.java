package br.ufv.caf.controle;

import br.ufv.caf.modelo.entidade.Urna;
import br.ufv.caf.modelo.entidade.Cedula;
import br.ufv.caf.modelo.entidade.Eleitor;
import br.ufv.caf.modelo.entidade.Candidato;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.log4j.Logger;
import java.util.Collections;

/**
 *
 * @author fabriciosilva
 */
public class ControleEleicao {
    private static final Logger LOGGER = Logger.getLogger("br.ufv.caf.eleicao");
    private ArrayList<Candidato> candidatos;
    private ArrayList<Eleitor> eleitores;
    private Urna urna;
    
    public ControleEleicao(){
        candidatos = new ArrayList<Candidato>();
        eleitores = new ArrayList();
        urna = new Urna();
    }
    
    public void addCandidato(Candidato c){
        candidatos.add(c);
    }
    
    public void addEleitor(Eleitor e){
        eleitores.add(e);
    }   
    
    /**
     * 
     * @return String com nomes e números
     * dos candidatos
     */
    public String listarCandidatos(){
        String candidatosStr = "";
        
        Collections.sort(candidatos);
        
        for(Candidato c : candidatos){
            candidatosStr += c.toString();           
        }
        return candidatosStr;
    }
    
    public void votar(int matricula, int voto){
        Eleitor eleitor = recuperaEleitor(matricula);
        if(eleitor != null){
            if(eleitor.isAptoVotar()){
                contabilizaVoto(voto);
                eleitor.aposVotar();
            }else{
                LOGGER.warn("Eleitor já votou!");
            }
        }else{
            LOGGER.warn("Eleitor não existe!");
        }
    }
    
    private Eleitor recuperaEleitor(int matricula){
        for(Eleitor e : eleitores){
            if(e.getMatricula() == matricula){
                return e;
            }
        }
        return null;
    }
    
    
    public String resultado(){
        Candidato vencedor = apurarEleicao();
        if(vencedor != null){            
            return "Vencedor: "+vencedor.toString();
        }else{
            return "Empate!";
        }
    }
    
    public void contabilizaVoto(int voto){
        for(Candidato c : candidatos){
           if(c.getNumero() == voto){
                Cedula cedula = new Cedula(voto);
                urna.insereCedula(cedula);
                break;
            }
        }        
    }
    
    public Candidato apurarEleicao(){
        
        HashMap<Integer,Integer> votos = urna.contabilizaVotos();
        
        boolean houveEmpate = false;
        int numeroCandidatoVencedor = -1;
        int votosVencedor = -1;
        
        Iterator<Integer> it = votos.keySet().iterator();
        
        while(it.hasNext()){
            int numeroCandidato = it.next();
            int votosCandidato = votos.get(numeroCandidato);
            if(votosCandidato > votosVencedor){
                numeroCandidatoVencedor = numeroCandidato;
                votosVencedor = votosCandidato;
                houveEmpate = false;
            }else if(votosCandidato == votosVencedor){
                houveEmpate = true;
            }            
        }
                          
        
        if(houveEmpate){
            //System.out.println("Empate! Rodar novamente!");
            return null;
        }else{
            for(Candidato c : candidatos){
                if(c.getNumero() == numeroCandidatoVencedor){
                    return c;
                }
            }
            return null;            
        }
    }
}
