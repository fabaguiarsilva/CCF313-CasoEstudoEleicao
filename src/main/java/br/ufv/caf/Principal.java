package br.ufv.caf;

import java.util.Scanner;

/**
 *
 * @author fabriciosilva
 */
public class Principal {

    public static void main(String[] args) {
       Principal principal = new Principal();
       principal.configurarEleicao();
    }
    
    void configurarEleicao(){
        Candidato c1 = new Candidato("Candidato 1", 1);
        Candidato c2 = new Candidato("Candidato 2", 2);
        Candidato c3 = new Candidato("Candidato 3", 3);      
        
        Candidato candidatos[] = {c1, c2, c3};
        
        int nEleitores = 5;
        
        coletarVotos(candidatos, nEleitores);
        
        Candidato vencedor = apurarEleicao(candidatos);
        
    }
    
    void coletarVotos(Candidato[] candidatos, int nEleitores){
        
        System.out.println("Bem-vindo! Digite: ");
        for(Candidato c : candidatos){
            System.out.println(c.getNumero() + " para votar no"
                    + "candidato "+c.getNome());
        }
                
        Scanner scan = new Scanner(System.in);
        
        for(int i=0; i<nEleitores; i++){
            System.out.println("Eleitor: "+(i+1));
            int voto = scan.nextInt();
            for(Candidato c : candidatos){
                if(c.getNumero() == voto){
                    c.incrementaVoto();
                    break;
                }
            }
        }
    }
    
    Candidato apurarEleicao(Candidato[] candidatos){
        
        boolean houveEmpate = false;
        int indiceVencedor = 0;        
        for(int i=1; i<candidatos.length; i++){
            if(candidatos[i].getnVotos() > 
                    candidatos[indiceVencedor].getnVotos()){
                indiceVencedor=i;
                houveEmpate = false;
            }else if(candidatos[i].getnVotos() == 
                        candidatos[indiceVencedor].getnVotos()){
                houveEmpate = true;
            }            
        }             
        
        if(houveEmpate){
            System.out.println("Empate! Rodar novamente!");
            return null;
        }else{
            System.out.println("O vencedor é: "
                +candidatos[indiceVencedor].getNome());        
            return candidatos[indiceVencedor];
        }        
    }
}
