package analisadorlexico;

public interface Constantes {
 
    enum Token { NUM, ATRIB, IDENT, EOF, PTOVIRG, VAZIO };
 
    String     DIGITOS    = "0123456789",
                LETRAS    = "abcdefghijklmnopqrstuvwxyz",
                ATRIB      = "-:",
                VAZIOS    = " \r\n\t";
 
    char    EOF    = 0,
            HIFEN     = '-',
            PTOVIRG    = ';',
            DOISPONTOS     = ':';
 
    String   NOME_DEFAULT_ARQUIVO_ENTRADA = "entrada.txt";
}
