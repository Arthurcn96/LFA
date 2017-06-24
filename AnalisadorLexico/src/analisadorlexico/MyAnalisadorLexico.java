package analisadorlexico;

 
public class MyAnalisadorLexico extends AnalisadorLexico {
    public MyAnalisadorLexico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }
    public void s0() {
        if(this.proxCaractereIs(DIGITOS)) {
            leProxCaractere();
            s1();
        }
        else if(this.proxCaractere == HIFEN) {
            leProxCaractere();
            s2();
        }
        else if(this.proxCaractereIs(LETRAS)) {
            leProxCaractere();
            s4();
        }
        else if(this.proxCaractere == PTOVIRG) {
            leProxCaractere();
            s5();
        }
        else if(this.proxCaractere == EOF) {
            leProxCaractere();
            s6();
        }
        else if(this.proxCaractereIs(VAZIOS)) {  
            leProxCaractere();
            s0();
        }
        else {
            throw new ErroLexico(this.proxCaractere,DIGITOS+LETRAS+VAZIOS+PTOVIRG+HIFEN);
        }
    }
    public void s1() {
        this.tokenReconhecido = Token.NUM;
        if(this.proxCaractereIs(DIGITOS)) {
            leProxCaractere();
            s1();
        }
    }
    public void s2() {
        if(this.proxCaractere == DOISPONTOS) {
            leProxCaractere();
            s3();
        }
        else if(this.proxCaractereIs(LETRAS)) {
            leProxCaractere();
            s4();
        }
        else
            throw new ErroLexico(this.proxCaractere,LETRAS+DOISPONTOS);
    }
    public void s3() {
        this.tokenReconhecido = Token.ATRIB;
    }
    public void s4() {
        this.tokenReconhecido = Token.IDENT;
        if(this.proxCaractereIs(LETRAS+HIFEN)) {
            leProxCaractere();
            s4();
        }
    }
    public void s5() {
        this.tokenReconhecido = Token.PTOVIRG;
    }
    public void s6() {
        this.tokenReconhecido = Token.EOF;
    }
}
