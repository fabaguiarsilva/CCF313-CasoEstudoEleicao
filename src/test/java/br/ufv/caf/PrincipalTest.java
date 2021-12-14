/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fabriciosilva
 */
public class PrincipalTest {
    @Test
    public void testApurarEleicao1() {
        
        Candidato c1 = new Candidato("Candidato 1",1);
        Candidato c2 = new Candidato("Candidato 2",2);
        Candidato c3 = new Candidato("Candidato 3",3);
        
        Candidato candidatos[] = {c1,c2,c3};
        
        Principal p = new Principal();
        Candidato vencedor;
            
        c1.incrementaVoto();
        c1.incrementaVoto();
        c1.incrementaVoto();
        c1.incrementaVoto();
        c1.incrementaVoto();
        
        vencedor = p.apurarEleicao(candidatos);
        
        assert(vencedor.getNumero() == c1.getNumero());
        
    }
    
    
    @Test
    public void testApurarEleicao2() {
        
        Candidato c1 = new Candidato("Candidato 1",1);
        Candidato c2 = new Candidato("Candidato 2",2);
        Candidato c3 = new Candidato("Candidato 3",3);
        
        Candidato candidatos[] = {c1,c2,c3};
        
        Principal p = new Principal();
        Candidato vencedor;
            
        c2.incrementaVoto();
        c2.incrementaVoto();
        c2.incrementaVoto();
        c2.incrementaVoto();
        c2.incrementaVoto();
        
        vencedor = p.apurarEleicao(candidatos);
        
        assert(vencedor.getNumero() == c2.getNumero());
    }
    
    @Test
    public void testApurarEleicao3() {
        
        Candidato c1 = new Candidato("Candidato 1",1);
        Candidato c2 = new Candidato("Candidato 2",2);
        Candidato c3 = new Candidato("Candidato 3",3);
        
        Candidato candidatos[] = {c1,c2,c3};
        
        Principal p = new Principal();
        Candidato vencedor;
            
        c1.incrementaVoto();
        c2.incrementaVoto();
        c3.incrementaVoto();
        c2.incrementaVoto();
        c2.incrementaVoto();
        
        vencedor = p.apurarEleicao(candidatos);
        
        assert(vencedor.getNumero() == c2.getNumero());
    }    
    
    @Test
    public void testApurarEleicao4() {
        
        Candidato c1 = new Candidato("Candidato 1",1);
        Candidato c2 = new Candidato("Candidato 2",2);
        Candidato c3 = new Candidato("Candidato 3",3);
        
        Candidato candidatos[] = {c1,c2,c3};
        
        Principal p = new Principal();
        Candidato vencedor;
            
        c1.incrementaVoto();
        c1.incrementaVoto();
        c2.incrementaVoto();
        c2.incrementaVoto();
        c3.incrementaVoto();
        
        vencedor = p.apurarEleicao(candidatos);
        
        assert(vencedor == null);
    }    
    
    
        
}
