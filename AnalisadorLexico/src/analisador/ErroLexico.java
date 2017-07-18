package analisador;

/**
 * Responsavel por cuidar do erro Lexico existente; 
 * Exemplo: Uso de caracteres que nao consta na gramatica. 
 * @author Grupo6
 */
public class ErroLexico extends RuntimeException {
    private char caractereEncontrado;
    private String caracteresEsperados;
 
    /**
     * O metodo salva o caractere recebidos e esperados nas variaveis da
     * classe.
     * @param _caracterEncontrado
     * @param _caracteresEsperados
     */
    public ErroLexico(char _caracterEncontrado, String _caracteresEsperados) {
        this.caractereEncontrado = _caracterEncontrado;
        this.caracteresEsperados = _caracteresEsperados;
    }

    /**
     * Transforma o erro lexico em uma String aonde contem os caracteres
     * encontrado(o erro) e os esperados 
     * @return String ErroLexico
     */
    @Override
    public String toString() {
        return "caractere encontrado: "+((char)this.caractereEncontrado)+"\nera(m) esperado(s): "+this.caracteresEsperados;
    }
}
