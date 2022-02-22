package br.ufv.caf.modelo.entidade.excecao;

/**
 *
 * @author fabriciosilva
 */
public class ExcecaoEmpate extends Exception {
    
    @Override
    public String getMessage(){
        return "Empate!";
    }
}
