package br.ufv.caf.modelo.entidade.excecao;

/**
 *
 * @author fabriciosilva
 */
public class ExcecaoEleitorJaVotou extends Exception {
    
    public String getMessage(){
        return "Eleitor já votou!";
    }
}
