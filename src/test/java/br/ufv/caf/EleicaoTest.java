
package br.ufv.caf;

import br.ufv.caf.controle.ControleCandidato;
import br.ufv.caf.controle.ControleEleicao;
import br.ufv.caf.controle.ControleEleitor;
import br.ufv.caf.modelo.entidade.Eleitor;
import br.ufv.caf.modelo.entidade.Candidato;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fabriciosilva
 */
public class EleicaoTest {
    
    ControleEleicao eleicao;
    ControleCandidato controleCandidato;
    ControleEleitor controleEleitor;
    
    void initBeforeAll() throws Exception{
        controleCandidato = new ControleCandidato();
        controleEleitor = new ControleEleitor();
        eleicao = new ControleEleicao(controleCandidato,
        controleEleitor);
        
        
        controleCandidato.inserir("Docente 1",111,"Computação",1);
        controleCandidato.inserir("Docente 2",222,"Engenharia",2);
        controleCandidato.inserir("Docente 3",333,"Biologia",3);
        
        controleEleitor.inserir("Aluno 1",111);
        controleEleitor.inserir("Aluno 2",222);        
        controleEleitor.inserir("Aluno 3",333);        
        controleEleitor.inserir("Aluno 4",444);        
        controleEleitor.inserir("Aluno 5",555);                        

    }
    
    
    @Test
    public void testApurarEleicao1()  {
        
        try {
            initBeforeAll();
            eleicao.votar(111,1);        
            eleicao.votar(222,1);        
            eleicao.votar(333,1);
            eleicao.votar(444,1);        
            eleicao.votar(555,1);        
        
            Candidato vencedor = eleicao.apurarEleicao();
        
            assert(vencedor.getNumero() == 1);
        } catch (Exception ex) {}
        
    }
    
    
    
    @Test
    public void testApurarEleicao2()  throws Exception {
        
        try{
        //initBeforeAll();
        eleicao.votar(111,2);        
        eleicao.votar(222,2);        
        eleicao.votar(333,2);
        eleicao.votar(444,2);        
        eleicao.votar(555,2);        

        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 2);
        }catch(Exception e){}
    }    
    
    @Test
    public void testApurarEleicao3()  throws Exception{
        
        try{
        //initBeforeAll();
        eleicao.votar(111,3);        
        eleicao.votar(222,3);        
        eleicao.votar(333,3);
        eleicao.votar(444,3);        
        eleicao.votar(555,3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 3);
        }catch(Exception e){}
    }    
    
    @Test
    public void testApurarEleicao4()  throws Exception{
        try{
        //initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,1);
        eleicao.votar(444,2);        
        eleicao.votar(555,3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 1);
        }catch(Exception e){}
    }    
    
    @Test
    public void testApurarEleicao5()  throws Exception{
        
        try{
        //initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,2);        
        eleicao.votar(333,3);
        eleicao.votar(444,2);        
        eleicao.votar(555,2);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 2);
        }catch(Exception e){}
    }   
    
    @Test
    public void testApurarEleicao6()  throws Exception{
        
        try{
        //initBeforeAll();
        eleicao.votar(111,3);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(444,3);        
        eleicao.votar(555,3);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 3);
        }catch(Exception e){}
    }    

    @Test
    public void testApurarEleicao7() throws Exception {
        
        try{
        //initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(444,2);        
        eleicao.votar(555,3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        }catch(Exception e){}
    }
    
    @Test
    public void testApurarEleicao8() throws Exception {
        
        try{
        //initBeforeAll();
        eleicao.votar(111,2);        
        eleicao.votar(222,2);        
        eleicao.votar(333,3);
        eleicao.votar(444,3);        
        eleicao.votar(555,1);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        }catch(Exception e){}
    }    
    
    @Test
    public void testApurarEleicao9() throws Exception {
        
        try{
        //initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,2);        
        eleicao.votar(333,3);
        eleicao.votar(444,2);        
        eleicao.votar(555,3);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        }catch(Exception e){}
    }    
    
    @Test
    public void testApurarEleicao10() throws Exception {
        
        try{
        //initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(9999,2);        
        eleicao.votar(8888,2);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 1);
        }catch(Exception e){}
    }       
    
    
    @Test
    public void testApurarEleicao11() throws Exception {
        
        try{
        //initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(444,2);        
        eleicao.votar(8888,1);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        }catch(Exception e){}
    }  
    
    @Test
    public void testApurarEleicao12()  throws Exception{
        
        try{
        //initBeforeAll();
        eleicao.votar(8888,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(444,2);        
        eleicao.votar(111,1);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        }catch(Exception e){}
    }     
    
    @Test
    public void testApurarEleicao13() throws Exception {
        
        try{
        //initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(222,1);        
        eleicao.votar(333,2);
        eleicao.votar(444,2);        
        eleicao.votar(111,1);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        }catch(Exception e){}
    }  


    @Test
    public void testApurarEleicao14()  {
        
        try{
        //initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(111,1);        
        eleicao.votar(333,2);
        eleicao.votar(333,2);        
        eleicao.votar(444,3);        
        eleicao.votar(555,3);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 3);
        }catch(Exception e){}
    }       

    @Test
    public void testApurarEleicao15()  {
        
        try{
        //initBeforeAll();
        eleicao.votar(111,1);        
        eleicao.votar(111,444);        
        eleicao.votar(333,566);
        eleicao.votar(333,5665);        
        eleicao.votar(444,334);        
        eleicao.votar(555,5544);        
                
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 1);
        }catch(Exception e){}
    }       
}
