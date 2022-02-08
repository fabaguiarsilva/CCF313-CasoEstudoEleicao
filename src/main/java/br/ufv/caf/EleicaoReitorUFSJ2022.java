package br.ufv.caf;

import br.ufv.caf.controle.ControleEleicao;
import br.ufv.caf.modelo.entidade.Eleitor;
import br.ufv.caf.modelo.entidade.Candidato;
import br.ufv.caf.visao.TelaResultado;
import br.ufv.caf.visao.TelaVotacao;

/**
 *
 * @author fabriciosilva
 */
public class EleicaoReitorUFSJ2022 {
    
    public static void main(String[] args){
        ControleEleicao eleicao = new ControleEleicao();
        
        eleicao.addCandidato(new Candidato("UFSJ 1",111,"Computação",1));
        eleicao.addCandidato(new Candidato("UFSJ 2",222,"Física",2));
        eleicao.addCandidato(new Candidato("UFSJ 3",222,"Matemática",3));
        
        eleicao.addEleitor(new Eleitor("Aluno 1",111));
        eleicao.addEleitor(new Eleitor("Professor 2",222));        
        eleicao.addEleitor(new Eleitor("Tecnico 3",333));        
        eleicao.addEleitor(new Eleitor("Aluno 4",444));        
        eleicao.addEleitor(new Eleitor("Aluno 5",555));        
        
        TelaVotacao telaVotacao = new TelaVotacao();
        telaVotacao.mostrar(eleicao);
        
        TelaResultado telaResultado = new TelaResultado();
        telaResultado.mostrar(eleicao);


    }
}
