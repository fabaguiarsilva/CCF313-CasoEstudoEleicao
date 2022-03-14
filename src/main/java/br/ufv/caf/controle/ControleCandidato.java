package br.ufv.caf.controle;

import br.ufv.caf.modelo.entidade.Candidato;
import br.ufv.caf.modelo.persistencia.DAOGenerico;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author fabriciosilva
 */
public class ControleCandidato {
    private static final Logger LOGGER = Logger.getLogger("br.ufv.caf.eleicao");    
    DAOGenerico<Candidato> daoCandidato;
    
    public ControleCandidato(){
        daoCandidato = new DAOGenerico<Candidato>();
    }
    
    public void inserir(String nome,
                        int matricula,
                        String departamento,
                        int numero) throws Exception{
        if(pesquisar(numero) == null){
            Candidato c = new Candidato(nome, matricula,
                                departamento, numero);
            daoCandidato.inserir(c);
        }else{
            throw new Exception("Candidato já existe!");
        }
    }
    
    public void remover(int numero){
        daoCandidato.remover(numero);
    }
    
    public Candidato pesquisar(int numero){
        return daoCandidato.pesquisar(numero);
    }
    
    public List<Candidato> listarTodos(){
        return daoCandidato.listarTodos();
    }
    
}
