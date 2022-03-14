package br.ufv.caf.controle;

import br.ufv.caf.modelo.entidade.Urna;
import br.ufv.caf.modelo.entidade.Cedula;
import br.ufv.caf.modelo.entidade.Eleitor;
import br.ufv.caf.modelo.entidade.Candidato;
import br.ufv.caf.modelo.entidade.VotoConsolidado;
import br.ufv.caf.modelo.entidade.excecao.ExcecaoEleitorJaVotou;
import br.ufv.caf.modelo.entidade.excecao.ExcecaoEleitorNaoExiste;
import br.ufv.caf.modelo.entidade.excecao.ExcecaoEmpate;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author fabriciosilva
 */
public class ControleEleicao {
    private static final Logger LOGGER = Logger.getLogger("br.ufv.caf.eleicao");
    ControleCandidato controleCandidato = new ControleCandidato();
    ControleEleitor controleEleitor = new ControleEleitor();
    
    private Urna urna;
    
    public ControleEleicao(){
        urna = new Urna();
    }
    
    
    public void addCandidatos(){
        //TODO
        List<Candidato> candidatos = 
                controleCandidato.listarTodos();
        for(Candidato c : candidatos){
            urna.adicionaCandidatoZerado(c);
        }
    }
    
    
    
    /**
     * 
     * @return String com nomes e números
     * dos candidatos
     */
    public String listarCandidatos(){
        String candidatosStr = "";
        
        List<Candidato> candidatos = 
                controleCandidato.listarTodos();
        
        Collections.sort(candidatos);
        
        for(Candidato c : candidatos){
            candidatosStr += c.toString();           
        }
        return candidatosStr;
    }
    
    public void votar(int matricula, int voto) 
            throws ExcecaoEleitorNaoExiste, 
                   ExcecaoEleitorJaVotou{
        Eleitor eleitor = recuperaEleitor(matricula);
        if(eleitor != null){
            if(eleitor.isAptoVotar()){
                contabilizaVoto(voto);
                eleitor.aposVotar();
            }else{
                LOGGER.warn("Eleitor já votou!");
                throw new ExcecaoEleitorJaVotou();
            }
        }else{
            LOGGER.warn("Eleitor não existe!");
            throw new ExcecaoEleitorNaoExiste();
        }
    }
    
    private Eleitor recuperaEleitor(int matricula){
        List<Eleitor> eleitores = controleEleitor.listarTodos();
        for(Eleitor e : eleitores){
            if(e.getMatricula() == matricula){
                return e;
            }
        }
        return null;
    }
    
    private Candidato recuperaCandidato(int numero){
        List<Candidato> candidatos = 
                controleCandidato.listarTodos();
        
        for(Candidato c: candidatos){
            if(c.getNumero() == numero){
                return c;
            }
        }
        return null;
    }
    
    
    public String resultado() throws ExcecaoEmpate{
        Candidato vencedor = apurarEleicao();
        return "Vencedor: "+vencedor.toString();
    }
    
    public void contabilizaVoto(int voto){
        List<Candidato> candidatos = 
                controleCandidato.listarTodos();
        
        for(Candidato c : candidatos){
           if(c.getNumero() == voto){
                Cedula cedula = new Cedula(voto);
                urna.insereCedula(cedula);
                break;
            }
        }        
    }
    
    public Candidato apurarEleicao() 
                        throws ExcecaoEmpate{
        
        ArrayList<VotoConsolidado> votos = 
                        urna.contabilizaVotos();
        
        Collections.sort(votos);
        
        if(votos.size() == 1){
            return recuperaCandidato(votos.get(0).getNumeroCandidato());
        }
        
        //Empate
        if(votos.get(0).getVotos() ==
                votos.get(1).getVotos()){
            //Empate
            throw new ExcecaoEmpate();
        }
        
        return recuperaCandidato(
                votos.get(0).getNumeroCandidato());        
    }
}
