package br.ufv.caf;

import br.ufv.caf.controle.ControleEleicao;
import br.ufv.caf.modelo.entidade.Candidato;
import br.ufv.caf.modelo.entidade.Eleitor;
import br.ufv.caf.visao.TelaResultado;
import br.ufv.caf.visao.TelaVotacao;
import org.apache.log4j.Logger;


public class EleicaoReitorUFV2022 {
    private static final Logger LOGGER = Logger.getLogger("br.ufv.caf.eleicao");
    public static void main(String[] args){
        ControleEleicao eleicao = new ControleEleicao();
        
        LOGGER.info("Adicionando os Candidatos!");
        
        eleicao.addCandidato(new Candidato("Docente 3",34,"Biologia",3));
        LOGGER.debug("Candidato 3 adicionado!");
                       
        eleicao.addCandidato(new Candidato("Docente 2",22,"Engenharia",2));
        LOGGER.debug("Candidato 2 adicionado!");
        
        eleicao.addCandidato(new Candidato("Docente 1",111,"Computação",1));
        LOGGER.debug("Candidato 1 adicionado!");

        
        LOGGER.info("Candidatos Adicionados!");
        
        
        LOGGER.info("Adicionando Eleitores!");
        eleicao.addEleitor(new Eleitor("Aluno 1",111));
        eleicao.addEleitor(new Eleitor("Aluno 2",222));        
        eleicao.addEleitor(new Eleitor("Aluno 3",333));        
        eleicao.addEleitor(new Eleitor("Aluno 4",444));        
        eleicao.addEleitor(new Eleitor("Aluno 5",555));        
        LOGGER.info("Eleitores Adicionados!");
        
        
        TelaVotacao telaVotacao = new TelaVotacao();
        telaVotacao.mostrar(eleicao);
        
        TelaResultado telaResultado = new TelaResultado();
        telaResultado.mostrar(eleicao);
        
    }
}
