package br.ufv.caf.controle;

import br.ufv.caf.modelo.entidade.Eleitor;
import br.ufv.caf.modelo.persistencia.DAOEleitor;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author fabriciosilva
 */
public class ControleEleitor {
    private static final Logger LOGGER = Logger.getLogger("br.ufv.caf.eleicao");    
    DAOEleitor daoEleitor;
    
    public ControleEleitor(){
        daoEleitor = new DAOEleitor();
    }
    
    public void inserir(String nome,
                        int matricula) throws Exception{
        if(pesquisar(matricula) == null){
            Eleitor e = new Eleitor(nome, matricula);
            daoEleitor.inserir(e);
        }else{
            throw new Exception("Candidato já existe!");
        }
    }
    
    public void remover(int matricula){
        daoEleitor.remover(matricula);
    }
    
    public Eleitor pesquisar(int matricula){
        return daoEleitor.pesquisar(matricula);
    }
    
    public List<Eleitor> listarTodos(){
        return daoEleitor.listarTodos();
    }
    
}
