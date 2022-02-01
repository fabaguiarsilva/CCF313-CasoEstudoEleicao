package br.ufv.caf.visao;

import br.ufv.caf.controle.ControleEleicao;
import java.util.Scanner;

/**
 *
 * @author fabriciosilva
 */
public class TelaVotacao {
    Scanner scan;
    
    public TelaVotacao(){
        scan = new Scanner(System.in);
    }
    
    public void mostrar(ControleEleicao eleicao){        
        int opcao;        
        
        opcao = mostrarMenu();
        
        while(opcao != 1){
            System.out.println("Digite a sua matrícula:");
            int matricula = scan.nextInt();
            //TODO verificar se matricula é válida??
            
            System.out.println("Digite o seu voto:");
            System.out.println(eleicao.listarCandidatos());
            int voto = scan.nextInt();
            eleicao.votar(matricula, voto);
            
            opcao = mostrarMenu();            
        }
        
    }

    private int mostrarMenu() {
        int opcao;
        System.out.println("Digite: ");
        System.out.println("1) Sair");
        System.out.println("2) Votar");
        opcao = scan.nextInt();
        return opcao;
    }
}
