package analisador;


public class MyAnalisadorSintatico extends AnalisadorSintatico {
    public String nomeArquivoEntrada;
    Token tokenReconhecido;
    
    public MyAnalisadorSintatico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }
    public void listaCom() {
        if(proxTokenIs(Token.VAR)||proxTokenIs(Token.WHILE)|| proxTokenIs(Token.FOR)||proxTokenIs(Token.SWITCH)||proxTokenIs(Token.IF)||proxTokenIs(Token.DO)){
            comando();
            listaCom();
        }
        else if (proxTokenIs(Token.EOF)){
        tokenReconhecido = Token.EOF;
        reconhece(Token.EOF);
        }
    }
    public void comando() {
        if(proxTokenIs(Token.VAR)) {
            atribuicao();
            reconhece(Token.PTVIRG);
        }
        else if(proxTokenIs(Token.WHILE))
            fwhile();
        else if(proxTokenIs(Token.FOR))
            ffor();
        else if(proxTokenIs(Token.SWITCH))
            fswitch();
        else if(proxTokenIs(Token.IF))
            fif();
        else if(proxTokenIs(Token.DO))
            fdowhile();
        else
            ; 
    }

    public void fwhile(){
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        bloco();
    }
    public void ffor(){
        reconhece(Token.FOR);
        reconhece(Token.AP);
        atribuicao();
        reconhece(Token.PTVIRG);
        exp();
        reconhece(Token.PTVIRG);
        atribuicao();
        reconhece(Token.FP);
        bloco();
    }
    public void fswitch() {
        reconhece(Token.SWITCH);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        reconhece(Token.AC);
        fcase();
        reconhece(Token.FC);
    }
    public void fcase(){
        if(proxTokenIs(Token.CASE)){
            leProxToken();
            caractere();
            reconhece(Token.DP);
            listaCom();
            fcase();
        }
        else if(proxTokenIs(Token.FC))
            lambda();
        else{
            Token[] tokensEsperados = {Token.CASE,Token.FC};
            throw new ErroSintatico(this.scanner.tokenReconhecido,tokensEsperados);
        }
    }
    public void caractere(){
        if(proxTokenIs(Token.APOST)){
            leProxToken();
            reconhece(Token.VAR);
            reconhece(Token.APOST);
        }
        else if(proxTokenIs(Token.NUM)){
            leProxToken();
        }
        else if (proxTokenIs(Token.VAR))
            leProxToken();
        else{
            Token[] tokensEsperados = {Token.NUM,Token.APOST,Token.VAR};
            throw new ErroSintatico(this.scanner.tokenReconhecido,tokensEsperados);
        }
    }
    private void fif() {
        reconhece(Token.IF);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        bloco();
    }
    private void fdowhile() {
        reconhece(Token.DO);
        bloco();
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        reconhece(Token.PTVIRG);
    }
    private void lambda() { }
    
    private void bloco() {
        if(proxTokenIs(Token.AC)){
            leProxToken();
            listaCom();
            reconhece(Token.FC);
        }
        else if(proxTokenIs(Token.VAR)||proxTokenIs(Token.WHILE)||proxTokenIs(Token.FOR)||proxTokenIs(Token.SWITCH)||proxTokenIs(Token.IF)||proxTokenIs(Token.DO)){
            comando();
        }
        else{
            Token[] tokensEsperados = {Token.AC,Token.VAR,Token.DO,Token.FOR,Token.IF,Token.SWITCH,Token.WHILE};
            throw new ErroSintatico(this.scanner.tokenReconhecido,tokensEsperados);
        }
    }
    
    public void atribuicao() {
        reconhece(Token.VAR);
        elemento();
    }
    public void elemento(){
        if(proxTokenIs(Token.OPIG)){
            leProxToken();
            exp();
        }
        else if(proxTokenIs(Token.OPBIUN)){
            leProxToken();
            reconhece(Token.OPBIUN);
        }
        else{
            Token[] tokensEsperados = {Token.OPBIUN,Token.OPIG};
            throw new ErroSintatico(this.scanner.tokenReconhecido,tokensEsperados);
        }
    }
    public void exp() {
        if(proxTokenIs(Token.AP)){ 
            leProxToken();
            exp();
            reconhece(Token.FP);
            s();
        }
        else if(proxTokenIs(Token.NUM)){ 
            leProxToken();
            s();
        }
        else if(proxTokenIs(Token.VAR)){
            leProxToken();
            s();
        }
        else if(proxTokenIs(Token.OPUN)){
            leProxToken();
            exp();
            s();
        }
        else if(proxTokenIs(Token.OPBIUN)){
            leProxToken();
            exp();
            s();
        }
        else{
            Token[] tokensEsperados = {Token.NUM,Token.OPUN,Token.VAR,Token.OPBIUN,Token.AP};
            throw new ErroSintatico(this.scanner.tokenReconhecido,tokensEsperados);
        }
    }
    public void s(){
        if(proxTokenIs(Token.OPBI)||proxTokenIs(Token.OPBIUN)){
            op();
            exp();
            s();
        }
        else{
            ;
        }
    }
    public void op(){
        if(proxTokenIs(Token.OPBI)){
            leProxToken();
        }
        else if(proxTokenIs(Token.OPBIUN))
            leProxToken();
        else{
            Token[] tokensEsperados = {Token.OPBIUN,Token.OPBI};
            throw new ErroSintatico(this.scanner.tokenReconhecido,tokensEsperados);
        }
    }
    
    }



