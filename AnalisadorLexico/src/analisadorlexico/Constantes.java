package analisadorlexico;

public interface Constantes {
 
    enum Token { NUM, ATRIB, IDENT, EOF, PTOVIRG, VAZIO };
 
    String     DIGITOS    = "0123456789",
                LETRAS    = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOQRSTUVWXYZ",
                ATRIB      = "-:",
                VAZIOS    = " \r\n\t",
                OPBINARIO = "*/%<>",//aqui tinha os operadores <= >= == && ||
                OPBINUNARIO = "+-",
                OPUNARIO = "!%",
                WHILE = "while",
                DO = "do",
                IF = "if",
                SWITCH = "switch",
                CASE = "case";
 
    char    EOF    = 0,
            HIFEN     = '-',
            PTOVIRG    = ';',
            DOISPONTOS     = ':',
            OPIGUAL = '=',
            ABREASPAS = '"',
            FECHAASPAS = '"',
            ABRECHAVES = '{',
            FECHACHAVES = '}',
            ABREPAR = '(',
            FECHAPAR = ')';
            
 
    String   NOME_DEFAULT_ARQUIVO_ENTRADA = "entrada.txt";
    
}
