package analisadorlexico;


public class MyAnalisadorSintatico extends AnalisadorSintatico {
    public String nomeArquivoEntrada;
    
    public MyAnalisadorSintatico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }
    public void listaCom() {
        comando();
        recursaoComand();
        //reconhece(Token.EOF);
    }
    public void comando() {
        if(proxTokenIs(Token.VAR)) {
            atribuicao();
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
        else {
            //Token[] tokensEsperados = {Token.IDENT,Token.EOF};
            throw new ErroSintatico(this.scanner.tokenReconhecido,tokensEsperados);
        }
    }
    public void recursaoComand() {
        if(proxTokenIs(Token.VAR)||proxTokenIs(Token.WHILE)||proxTokenIs(Token.FOR)||proxTokenIs(Token.SWITCH)||proxTokenIs(Token.IF)||proxTokenIs(Token.DO))
            listaCom();
        else if(proxTokenIs(Token.EOF))
            lambda();
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
        fcase();
    }
    public void fcase(){
        if(proxTokenIs(Token.CASE)){
            leProxToken();
            caractere();
            reconhece(Token.DP);
            listaCom();
            reconhece(Token.PTVIRG);
            fcase();
        }
        else if(proxTokenIs(Token.EOF))
            lambda();
        else
            ;
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
    }
    private void atribuicao() {
        reconhece(Token.VAR);
        reconhece(Token.OPIG);
        exp();
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
    }
    public void s(){
        if(proxTokenIs(Token.OPBI)){
            op();
            exp();
            s();
        }
        else if (proxTokenIs(Token.EOF))
            lambda();
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
   }
    
    }



