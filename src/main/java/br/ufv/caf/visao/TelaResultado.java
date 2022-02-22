package br.ufv.caf.visao;

import br.ufv.caf.controle.ControleEleicao;
import br.ufv.caf.modelo.entidade.excecao.ExcecaoEmpate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author fabriciosilva
 */
public class TelaResultado {
    public void mostrar(ControleEleicao eleicao){
        String resultado="";
        System.out.println("## Resultado da Eleição ##");        
        try {
            resultado = eleicao.resultado();
        } catch (ExcecaoEmpate ex) {
            resultado = "Empate!";
            JOptionPane.showMessageDialog(null, "Eleição terminou em empate!");
        }
        System.out.println(resultado);

    }
}
