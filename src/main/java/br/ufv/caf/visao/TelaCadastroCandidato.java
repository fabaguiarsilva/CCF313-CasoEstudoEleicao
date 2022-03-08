package br.ufv.caf.visao;

import br.ufv.caf.controle.ControleCandidato;
import java.util.Scanner;

/**
 *
 * @author fabriciosilva
 */
class TelaCadastroCandidato {
    public void mostrar(ControleCandidato controle){
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        
        System.out.println("Digite o nome do candidato:");
        String nome = scan.next();
        
        System.out.println("Digite a matrícula do candidato:");
        int matricula = scan.nextInt();
        
        System.out.println("Digite o departamento do candidato:");
        String departamento = scan.next();
        
        System.out.println("Digite o numero do candidato:");
        int numero = scan.nextInt();
        
        try{
            controle.inserir(nome, matricula, departamento, numero);
        }catch(Exception e){
            System.err.println("Erro: "+e.getMessage());
        }        
    }
}
