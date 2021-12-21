package br.ufv.caf;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author fabriciosilva
 */
public class Eleicao {

    private ArrayList<Candidato> candidatos;
    private ArrayList<Eleitor> eleitores;
    private Urna urna;
    
    public Eleicao(){
        candidatos = new ArrayList();
        eleitores = new ArrayList();
        urna = new Urna();
    }
    
    public void addCandidato(Candidato c){
        candidatos.add(c);
    }
    
    public void addEleitor(Eleitor e){
        eleitores.add(e);
    }   
    
    void iniciarEleicao(){       
        
        coletarVotos();
        
        Candidato vencedor = apurarEleicao();
        if(vencedor != null){
            System.out.println("Vencedor: "+vencedor.getNome());
        }else{
            System.out.println("Empate!");
        }
    }
    
    void coletarVotos(){
        
        System.out.println("Bem-vindo! Digite: ");
        for(Candidato c : candidatos){
            System.out.println(c.getNumero() + " para votar no"
                    + "candidato "+c.getNome());
        }
                
        Scanner scan = new Scanner(System.in);
        
        for(Eleitor e : eleitores){
            System.out.println("Eleitor: "+e.getNome());
            int voto = scan.nextInt();
            contabilizaVoto(voto);
        }
    }

    void contabilizaVoto(int voto){
        for(Candidato c : candidatos){
           if(c.getNumero() == voto){
                Cedula cedula = new Cedula(voto);
                urna.insereCedula(cedula);
                break;
            }
        }        
    }
    
    Candidato apurarEleicao(){
        
        HashMap<Integer,Integer> votos = urna.contabilizaVotos();
        
        boolean houveEmpate = false;
        int numeroCandidatoVencedor = -1;
        int votosVencedor = -1;
        
        Iterator<Integer> it = votos.keySet().iterator();
        
        while(it.hasNext()){
            int numeroCandidato = it.next();
            int votosCandidato = votos.get(numeroCandidato);
            if(votosCandidato > votosVencedor){
                numeroCandidatoVencedor = numeroCandidato;
                votosVencedor = votosCandidato;
                houveEmpate = false;
            }else if(votosCandidato == votosVencedor){
                houveEmpate = true;
            }            
        }
                          
        
        if(houveEmpate){
            System.out.println("Empate! Rodar novamente!");
            return null;
        }else{
            for(Candidato c : candidatos){
                if(c.getNumero() == numeroCandidatoVencedor){
                    return c;
                }
            }
            return null;            
        }
    }
}
