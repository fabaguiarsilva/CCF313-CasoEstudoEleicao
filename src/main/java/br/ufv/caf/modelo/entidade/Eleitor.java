package br.ufv.caf.modelo.entidade;

public class Eleitor extends MembroAcademico {
    private boolean aptoVotar;    
    
    public Eleitor(String nome, 
                    int matricula){        
        super(nome, matricula);
        aptoVotar=false;
    }    
    
    @Override
    public String toString(){
        return super.toString()+
                "\tApto a Votar: "+(aptoVotar?"Sim":"Não")+"\n";
    }    
}
