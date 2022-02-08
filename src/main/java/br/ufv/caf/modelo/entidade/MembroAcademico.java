package br.ufv.caf.modelo.entidade;

public class MembroAcademico {
    private String nome;
    private int matricula;
    
    public MembroAcademico(String nome,
                            int matricula){
        this.nome=nome;
        this.matricula=matricula;
    }
    
    public int getMatricula(){
        return this.matricula;
    }
    
    
    @Override
    public String toString(){
        return "Membro Acadêmico:\n"+
                "\tNome: "+nome+"\n"+
                "\tMatrícula: "+matricula+"\n";                                 
    }
}
