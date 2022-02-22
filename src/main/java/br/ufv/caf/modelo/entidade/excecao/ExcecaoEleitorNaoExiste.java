package br.ufv.caf.modelo.entidade.excecao;

/**
 *
 * @author fabriciosilva
 */
public class ExcecaoEleitorNaoExiste extends Exception {
    
    public String getMessage(){
        return "Eleitor não existe!";
    }
}
