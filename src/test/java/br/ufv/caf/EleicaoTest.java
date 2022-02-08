
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
        eleicao.contabilizaVoto(1);        
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(1);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 1);
        
    }
    
    @Test
    public void testApurarEleicao2() {
        
        initBeforeAll();
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(2);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 2);
        
    }    
    
    @Test
    public void testApurarEleicao3() {
        
        initBeforeAll();
        eleicao.contabilizaVoto(3);
        eleicao.contabilizaVoto(3);
        eleicao.contabilizaVoto(3);
        eleicao.contabilizaVoto(3);
        eleicao.contabilizaVoto(3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 3);
        
    }    
    
    @Test
    public void testApurarEleicao4() {
        
        initBeforeAll();
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 1);
        
    }    
    
    @Test
    public void testApurarEleicao5() {
        
        initBeforeAll();
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(3);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(2);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 2);
        
    }   
    
    @Test
    public void testApurarEleicao6() {
        
        initBeforeAll();
        eleicao.contabilizaVoto(3);
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(3);
        eleicao.contabilizaVoto(3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor.getNumero() == 3);
        
    }    

    @Test
    public void testApurarEleicao7() {
        
        initBeforeAll();
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        
    }
    
    @Test
    public void testApurarEleicao8() {
        
        initBeforeAll();
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(3);
        eleicao.contabilizaVoto(3);
        eleicao.contabilizaVoto(1);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        
    }    
    
    @Test
    public void testApurarEleicao9() {
        
        initBeforeAll();
        eleicao.contabilizaVoto(1);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(3);
        eleicao.contabilizaVoto(2);
        eleicao.contabilizaVoto(3);        
        
        Candidato vencedor = eleicao.apurarEleicao();
        
        assert(vencedor == null);
        
    }    
    
    
}
