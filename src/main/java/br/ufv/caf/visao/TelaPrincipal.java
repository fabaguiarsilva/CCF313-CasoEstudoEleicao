package br.ufv.caf.visao;

import br.ufv.caf.controle.ControleCandidato;
import java.util.Scanner;
import br.ufv.caf.controle.ControleEleicao;
import br.ufv.caf.controle.ControleEleitor;

public class TelaPrincipal {

    public static void main(String []args){

        ControleCandidato controleCandidato = new ControleCandidato();
        ControleEleitor controleEleitor = new ControleEleitor();

        ControleEleicao eleicao = new ControleEleicao();
        
        Scanner scan = new Scanner(System.in);
        int opcao;
        
        mostrarMenu();
        opcao=scan.nextInt();
        while(opcao != 0){
            switch(opcao){
                case 1:
                    TelaCadastroCandidato telaCandidato =
                            new TelaCadastroCandidato();
                    telaCandidato.mostrar(controleCandidato);
                    break;
                case 2:
                    TelaCadastroEleitor telaEleitor =
                            new TelaCadastroEleitor();
                    telaEleitor.mostrar(controleEleitor);
                    break;
                    
                case 3:
                    eleicao.addCandidatos();
                    TelaVotacao telaVotacao = new TelaVotacao();
                    telaVotacao.mostrar(eleicao);
                    break;
                case 4:
                    TelaResultado telaResultado = new TelaResultado();
                    telaResultado.mostrar(eleicao);                    
                    break;
                default:
                    System.err.println("Opção inválida!");
                
            }
            
            mostrarMenu();
            opcao=scan.nextInt();            
        }
        
        
        
        
    }    
    
    public static void mostrarMenu(){
        System.out.println("## Menu ##");
        System.out.println("0) Sair");
        System.out.println("1) Cadastrar Candidato");
        System.out.println("2) Cadastrar Eleitor");
        System.out.println("3) Iniciar Votação");
        System.out.println("4) Resultado");
    }
    
}
