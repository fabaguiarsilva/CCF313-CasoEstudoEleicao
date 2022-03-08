package br.ufv.caf.visao;

import br.ufv.caf.controle.ControleEleitor;
import java.util.Scanner;

/**
 *
 * @author fabriciosilva
 */
class TelaCadastroEleitor {
    public void mostrar(ControleEleitor controle){
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        
        System.out.println("Digite o nome do candidato:");
        String nome = scan.next();
        
        System.out.println("Digite a matrícula do candidato:");
        int matricula = scan.nextInt();
                
        try{
            controle.inserir(nome, matricula);
        }catch(Exception e){
            System.err.println("Erro: "+e.getMessage());
        }        
    }
}
