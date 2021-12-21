package br.ufv.caf;


public class EleicaoReitorUFV2022 {
    public static void main(String[] args){
        Eleicao eleicao = new Eleicao();
        
        eleicao.addCandidato(new Candidato("Candidato 1",1));
        eleicao.addCandidato(new Candidato("Candidato 2",2));        
        eleicao.addCandidato(new Candidato("Candidato 3",3));        
        
        eleicao.addEleitor(new Eleitor("Aluno 1",111));
        eleicao.addEleitor(new Eleitor("Aluno 2",222));        
        eleicao.addEleitor(new Eleitor("Aluno 3",333));        
        eleicao.addEleitor(new Eleitor("Aluno 4",444));        
        eleicao.addEleitor(new Eleitor("Aluno 5",555));        
        
        eleicao.iniciarEleicao();
        
    }
}
