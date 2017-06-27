package analisadorlexico;

public interface Constantes {
 
    enum Token { NUM,VAR,OPBI,OPBIUN, PONTO,OPUN, OPIG, DP,PTOVIRG,APOST,AP,FP,AC,FC,WHILE,FOR,DO,IF,SWITCH,CASE, EOF};
 
    String     DIGITOS    = "0123456789",
                LETRAS    = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOQRSTUVWXYZ",
                VAZIOS    = " \r\n\t",
                OPBINARIO = "*/<>",
                OPBINUNARIO = "+-!";

    char    EOF    = 0,
            HIFEN     = '-',
            PTOVIRG    = ';',
            DOISPONTOS     = ':',
            OPIGUAL = '=',
            APOST = '\'',
            ABRECHAVES = '{',
            FECHACHAVES = '}',
            ABREPAR = '(',
            FECHAPAR = ')',
            //OPUNARIO = '',
            PONTO = '.',
            E ='&',
            OU ='|';
 
    String   NOME_DEFAULT_ARQUIVO_ENTRADA = "entrada.txt";
    
}
