package analisador;
import java.io.FileReader;
import java.io.IOException;
 
/**
 * Contem as variaveis e metodos necessarios para iniciar e carregar o 
 * texto e ler os caracteres recebidos.
 * @author Grupo6
 */
public class AnalisadorLexico extends Analisador {

    /**
     * Caractere disponível no cabeçote de leitura
     */
    protected char proxCaractere;  

    /**
     * Linha atual do arquivo fonte
     */

    /**
     * Armazena o conteúdo do arquivo
     */
    protected StringBuffer entrada = new StringBuffer(); 

    /**
     * Posição do caractere a ser lido na entrada  
     */
    protected int posicao = 0; 

    /**
     * Ultimo token lido
     */
    public Token tokenReconhecido;  

    /**
     * Transfere o arquivo para o buffer ‘entrada’
     */
    protected static String saida;
    

    /**
     * Carrega o arquivo passado no parametro e o carrega, entao salva em
     * 'entrada' e entao chama 'leProxCaractere()'
     * Erro: RuntimeException;
     * @param nomeArquivodeEntrada
     */
    public AnalisadorLexico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
        try {
            FileReader file = new FileReader(_nomeArquivoEntrada);
            int c;
            while((c = file.read()) != -1) {
                this.entrada.append((char)c);
            }
            file.close();
            leProxCaractere();
        }
        catch (IOException e) {
            throw new RuntimeException("Erro de leitura no arquivo " +_nomeArquivoEntrada);
        }
    }
    

    /**
     * lê o próximo caractere do buffer. Se fim, retorna EOF
     *  avança o ponteiro de leitura 1 posição
     */
    public void leProxCaractere() {
        try {
            this.proxCaractere = this.entrada.charAt(this.posicao++);
        }
        catch(IndexOutOfBoundsException e) {
            this.proxCaractere = EOF;
        }
    }
    
    //

    /**
     * verifica se o próximo caractere é um dos que estão em ‘s’
     * entao avança o ponteiro de leitura
     * @param String s
     * @return boolean
     */
    public boolean proxCaractereIs(String s) {
        if (s.indexOf(this.proxCaractere) != -1)
            return true;
        else
            return false;
    }
}
 
 
