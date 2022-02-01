package br.ufv.caf;

import br.ufv.caf.controle.ControleEleicao;
import br.ufv.caf.modelo.entidade.Candidato;
import br.ufv.caf.modelo.entidade.Eleitor;
import br.ufv.caf.visao.TelaResultado;
import br.ufv.caf.visao.TelaVotacao;


public class EleicaoReitorUFV2022 {
    public static void main(String[] args){
        ControleEleicao eleicao = new ControleEleicao();
        
        eleicao.addCandidato(new Candidato("Candidato 1",1));
        eleicao.addCandidato(new Candidato("Candidato 2",2));        
        eleicao.addCandidato(new Candidato("Candidato 3",3));        
        
        eleicao.addEleitor(new Eleitor("Aluno 1",111));
        eleicao.addEleitor(new Eleitor("Aluno 2",222));        
        eleicao.addEleitor(new Eleitor("Aluno 3",333));        
        eleicao.addEleitor(new Eleitor("Aluno 4",444));        
        eleicao.addEleitor(new Eleitor("Aluno 5",555));        
        
        TelaVotacao telaVotacao = new TelaVotacao();
        telaVotacao.mostrar(eleicao);
        
        TelaResultado telaResultado = new TelaResultado();
        telaResultado.mostrar(eleicao);
        
    }
}
