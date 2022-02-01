package br.ufv.caf.visao;

import br.ufv.caf.controle.ControleEleicao;

/**
 *
 * @author fabriciosilva
 */
public class TelaResultado {
    public void mostrar(ControleEleicao eleicao){
        String resultado = eleicao.resultado();
        System.out.println("## Resultado da Eleição ##");
        System.out.println(resultado);
    }
}
