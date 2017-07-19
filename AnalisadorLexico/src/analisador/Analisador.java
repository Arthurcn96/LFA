package analisador;

/**
 * Classe abstrata de Analisador, servindo de base para os analisadores
 * @author Grupo6
 */
public abstract class Analisador implements Constantes {

    /**
     * O nome do arquivo a ser .txt a ser carregado.
     */
    protected String nomeArquivoEntrada;

    /**
     * Atribui a String _nomeArquivoEntrada a variavel nomeArquivoEntrada
     * @param _nomeArquivoEntrada Caminho do arquivo .txt
     */
    public Analisador(String _nomeArquivoEntrada) {
        this.nomeArquivoEntrada = _nomeArquivoEntrada;
    }

    /**
     * Caso nao seja passado nenhum arquivo, a variavel nomreArquivoEntrada
     * recebe um valor default NOME_DEFAULT_ARQUIVO_ENTRADA contido na interface
     * Constantes
     */
    public Analisador() {
        this.nomeArquivoEntrada = NOME_DEFAULT_ARQUIVO_ENTRADA;
    }
}
 
