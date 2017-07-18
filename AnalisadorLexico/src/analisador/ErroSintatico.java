package analisador;

/**
 * Responsavel pelos erros Sintaticos existente; Exemplo: Uso de tokens 
 * que nao consta na gramatica.
 * @author Grupo6
 */
public class ErroSintatico extends RuntimeException implements Constantes {
    private Token tokenEncontrado;
    private Token[] tokensEsperados;

    /**
     * O metodo salva um tokens recebidos e conjunto de esperados em uma
     * variavel array da classe.
     * 
     * @param _tokenEncontrado
     * @param _tokensEsperados
     */
    public ErroSintatico(Token _tokenEncontrado, Token[] _tokensEsperados) {
        this.tokenEncontrado = _tokenEncontrado;
        this.tokensEsperados = _tokensEsperados;
    }

    /**
     * O metodo salva o Token recebidos e esperados nas variaveis da
     * classe.
     * @param _tokenEncontrado
     * @param _tokenEsperado
     */
    public ErroSintatico(Token _tokenEncontrado, Token _tokenEsperado) {
        this.tokenEncontrado = _tokenEncontrado;
        this.tokensEsperados = new Token[1];
        tokensEsperados[0] = _tokenEsperado;
    }

    /**
     * Transforma o erro lexico em uma String aonde contem os token
     * encontrado(o erro) e os esperados 
     * @return String ErroSintatico
     */
    public String toString() {
        String listaDeTokensEsperados = "";
        for(int i=0; i<this.tokensEsperados.length; i++)
            listaDeTokensEsperados += this.tokensEsperados[i] + " ";
        return "token encontrado: "+this.tokenEncontrado+
               "\nera(m) esperado(s): "+listaDeTokensEsperados;
    }
}
