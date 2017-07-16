package analisador;

public interface Constantes {
 
    enum Token { NUM,VAR,OPBI,OPBIUN, PONTO,OPUN, OPIG, DP,PTVIRG,APOST,AP,FP,AC,FC,WHILE,FOR,DO,IF,SWITCH,CASE, EOF};
 
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
 
    String   NOME_DEFAULT_ARQUIVO_ENTRADA = "entrada.txt";
    
}
