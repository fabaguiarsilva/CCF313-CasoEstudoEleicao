package br.ufv.caf;

/**
 *
 * @author fabriciosilva
 */
public class EleicaoReitorUFSJ2022 {
    
    public static void main(String[] args){
        Eleicao eleicao = new Eleicao();
        
        eleicao.addCandidato(new Candidato("UFSJ 1",1));
        eleicao.addCandidato(new Candidato("UFSJ 2",2));        
        eleicao.addCandidato(new Candidato("UFSJ 3",3));        
        
        eleicao.addEleitor(new Eleitor("Aluno 1",111));
        eleicao.addEleitor(new Eleitor("Professor 2",222));        
        eleicao.addEleitor(new Eleitor("Tecnico 3",333));        
        eleicao.addEleitor(new Eleitor("Aluno 4",444));        
        eleicao.addEleitor(new Eleitor("Aluno 5",555));        
        
        eleicao.iniciarEleicao();
    }
}
