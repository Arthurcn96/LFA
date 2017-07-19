package analisador;

/**
 * Contem as variaveis e metodos necessarios para iniciar e carregar o 
 * texto e ler os tokens recebidos.
 * @author Grupo6
 */
public class AnalisadorSintatico extends Analisador implements Constantes {

    /**
     * Variavel em que sera carregada o .txt
     */
    protected MyAnalisadorLexico scanner;
    
    /**
     * Carrega o arquivo passado no parametro e o carrega, entao salva em
     * 'scanner' e entao chama 'leProxToken()'
     * Erro: RuntimeException;
     * @param _nomeArquivoEntrada Caminho do arquivo .txt
     */
    public AnalisadorSintatico(String _nomeArquivoEntrada) {
        this.scanner = new MyAnalisadorLexico(_nomeArquivoEntrada);
        // lê o primeiro token e o coloca no campo tokenReconhecido
        this.leProxToken();
    }

    /**
     * Chama o metodo 'Analisador()'
     */
    public AnalisadorSintatico() {
        super();
    }

    /**
     *  Inicia a execucao da máquina de Moore 
     */
    public void leProxToken() {
        this.scanner.s0();
    }


    /**
     *  Verifica se o próximo token é t
     *  Avança o ponteiro para o próximo token
     * @param token Token contido na interface Constantes
     */
    public void reconhece(Token token) {
        if(token == this.scanner.tokenReconhecido) 
            this.leProxToken();
        else
            throw new ErroSintatico(this.scanner.tokenReconhecido, token);
    }

    /**
     * Verifica se o próximo token é t
     * avança o ponteiro de leitura
     * @param t Token a ser verificado
     * @return boolean true - caso t for o proximo token; false - se nao for
     */
    public boolean proxTokenIs(Token t) {
        if(t == this.scanner.tokenReconhecido) 
            return true;
        else
            return false;
    }
}
