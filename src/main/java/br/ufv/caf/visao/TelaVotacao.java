package br.ufv.caf.visao;

import br.ufv.caf.controle.ControleEleicao;
import br.ufv.caf.modelo.entidade.excecao.ExcecaoEleitorJaVotou;
import br.ufv.caf.modelo.entidade.excecao.ExcecaoEleitorNaoExiste;
import java.util.Scanner;
import javax.swing.JOptionPane;

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
            try{
                eleicao.votar(matricula, voto);
            }catch(ExcecaoEleitorNaoExiste ene){
                System.out.println("Matrícula inválida!");
            }catch(ExcecaoEleitorJaVotou ejv){
                JOptionPane.showMessageDialog(null, "Eleitor já votou! Denuncie!");
            }
            
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
