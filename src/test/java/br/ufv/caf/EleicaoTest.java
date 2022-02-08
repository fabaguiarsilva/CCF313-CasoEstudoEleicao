
package br.ufv.caf;

import br.ufv.caf.controle.ControleEleicao;
import br.ufv.caf.modelo.entidade.Eleitor;
import br.ufv.caf.modelo.entidade.Candidato;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fabriciosilva
 */
public class EleicaoTest {
    
    ControleEleicao eleicao;
    
    void initBeforeAll(){
        eleicao = new ControleEleicao();
        
        eleicao.addCandidato(new Candidato("Docente 1",111,"Computação",1));
        eleicao.addCandidato(new Candidato("Docente 2",222,"Engenharia",2));
        eleicao.addCandidato(new Candidato("Docente 3",333,"Biologia",3));
        
        eleicao.addEleitor(new Eleitor("Aluno 1",111));
        eleicao.addEleitor(new Eleitor("Aluno 2",222));        
        eleicao.addEleitor(new Eleitor("Aluno 3",333));        
        eleicao.addEleitor(new Eleitor("Aluno 4",444));        
        eleicao.addEleitor(new Eleitor("Aluno 5",555));                        

    }
    
    
    @Test
    public void testApurarEleicao1() {
        
        initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,1);
        eleicao.votar(444,1);        
        eleicao.votar(555,1);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 1);
        
    }
    
    @Test
    public void testApurarEleicao2() {
        
        initBeforeAll();
        eleicao.votar(111,2);        
        eleicao.votar(222,2);        
        eleicao.votar(333,2);
        eleicao.votar(444,2);        
        eleicao.votar(555,2);        

        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 2);
        
    }    
    
    @Test
    public void testApurarEleicao3() {
        
        initBeforeAll();
        eleicao.votar(111,3);        
        eleicao.votar(222,3);        
        eleicao.votar(333,3);
        eleicao.votar(444,3);        
        eleicao.votar(555,3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 3);
        
    }    
    
    @Test
    public void testApurarEleicao4() {
        
        initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,1);
        eleicao.votar(444,2);        
        eleicao.votar(555,3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 1);
        
    }    
    
    @Test
    public void testApurarEleicao5() {
        
        initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,2);        
        eleicao.votar(333,3);
        eleicao.votar(444,2);        
        eleicao.votar(555,2);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 2);
        
    }   
    
    @Test
    public void testApurarEleicao6() {
        
        initBeforeAll();
        eleicao.votar(111,3);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(444,3);        
        eleicao.votar(555,3);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 3);
        
    }    

    @Test
    public void testApurarEleicao7() {
        
        initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(444,2);        
        eleicao.votar(555,3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        
    }
    
    @Test
    public void testApurarEleicao8() {
        
        initBeforeAll();
        eleicao.votar(111,2);        
        eleicao.votar(222,2);        
        eleicao.votar(333,3);
        eleicao.votar(444,3);        
        eleicao.votar(555,1);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        
    }    
    
    @Test
    public void testApurarEleicao9() {
        
        initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,2);        
        eleicao.votar(333,3);
        eleicao.votar(444,2);        
        eleicao.votar(555,3);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        
    }    
    
    @Test
    public void testApurarEleicao10() {
        
        initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(9999,2);        
        eleicao.votar(8888,2);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 1);
        
    }       
    
    
    @Test
    public void testApurarEleicao11() {
        
        initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(444,2);        
        eleicao.votar(8888,1);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        
    }  
    
    @Test
    public void testApurarEleicao12() {
        
        initBeforeAll();
        eleicao.votar(8888,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(444,2);        
        eleicao.votar(111,1);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        
    }     
    
    @Test
    public void testApurarEleicao13() {
        
        initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(444,2);        
        eleicao.votar(111,1);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        
    }  


    @Test
    public void testApurarEleicao14() {
        
        initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(111,1);        
        eleicao.votar(333,2);
        eleicao.votar(333,2);        
        eleicao.votar(444,3);        
        eleicao.votar(555,3);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 3);
        
    }       
}
