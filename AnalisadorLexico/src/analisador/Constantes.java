package analisador;

/**
 * Contem todos os tokens junto com todos os caracteres que podem ser
 * interpretados pelo analisador
 * @author Grupo6
 */
public interface Constantes {
 
    /**
     * Contem todos os Tokens que podem ser interpretados pelo Analisador 
     * sintatico
     */
    enum Token { NUM,VAR,OPBI,OPBIUN, PONTO,OPUN, OPIG, DP,PTVIRG,APOST,AP,FP,AC,FC,WHILE,FOR,DO,IF,SWITCH,CASE, EOF};
    //String contando todos os caracteres(conjuntos) dos valores que podem ser recebidos/interpretados
    String     DIGITOS    = "0123456789",
                LETRAS    = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",
                VAZIOS    = " \r\n\t",
                OPBINARIO = "*/<>",
                OPBINUNARIO = "+-",
                DO ="do",
                WHILE = "while",
                FOR ="for",
                IF ="if",
                SWITCH ="switch",
                CASE = "case";
    
    //Char dos caracteres que podem ser recebidos/interpretados
    char    EOF    = 0,
            PTOVIRG    = ';',
            DOISPONTOS     = ':',
            OPIGUAL = '=',
            APOST = '\'',
            ABRECHAVES = '{',
            FECHACHAVES = '}',
            ABREPAR = '(',
            FECHAPAR = ')',
            OPUNARIO = '!',
            PONTO = '.',
            E ='&',
            OU ='|';
 
    //Nome Defaul do arquivo de entrada.(Usado quando criado a funcao 'Analisador')
    String   NOME_DEFAULT_ARQUIVO_ENTRADA = "entrada.txt";
    
}
