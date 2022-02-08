package br.ufv.caf.modelo.entidade;

public class Docente extends MembroAcademico {
    private String departamento;
    
    public Docente(String nome,
                    int matricula,
                    String departamento){
        super(nome, matricula);
        this.departamento = departamento;
    }
    
    @Override
    public String toString(){
        return super.toString()+
                "\tDocente do departamento: "+departamento+"\n";
    }    
}
