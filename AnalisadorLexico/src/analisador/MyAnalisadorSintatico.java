package analisador;

/**
 * Aonde esta convertido toda a gramatica livre de contexto(GLC) em codigo
 * @author Grupo6
 */
public class MyAnalisadorSintatico extends AnalisadorSintatico {

    /**
     * 
     */
    public String nomeArquivoEntrada;
    Token tokenReconhecido;
    
    /**
     * Construtor
     * @param _nomeArquivoEntrada Caminho do arquivo .txt
     */
    public MyAnalisadorSintatico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }
    

    /**
     * O estado inicial da gramatica no qual a maquina pode ir para qualquer 
     * outro estado reconhecivel
     */
    public void listaCom() {
        if(proxTokenIs(Token.VAR)||proxTokenIs(Token.WHILE)|| proxTokenIs(Token.FOR)||proxTokenIs(Token.SWITCH)||proxTokenIs(Token.IF)||proxTokenIs(Token.DO)){
            comando();
            listaCom();
        }
        else if (proxTokenIs(Token.EOF)){
        tokenReconhecido = Token.EOF;
        reconhece(Token.EOF);
        }
        else if(proxTokenIs(Token.FC)){
            //Permite o bloco estar vazio
            lambda();
        }
        else{
            Token[] tokensEsperados = {Token.IF,Token.FOR,Token.DO,Token.SWITCH,Token.WHILE};
            throw new ErroSintatico(this.scanner.tokenReconhecido,tokensEsperados);
        }
    }

    /**
     * Estado reconhecedor de todos os Tokens
     */
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
        else{
            //Permite o programa ser vazio.
            lambda();
        }
    }

    /**
     * Reconhece o comando 'while'
     */
    public void fwhile(){
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        bloco();
    }
    
    /** 
     * Reconhece o comando 'for'
     */
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
    
    /**
     * Reconhece o comando 'switch'
     */
    public void fswitch() {
        reconhece(Token.SWITCH);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        reconhece(Token.AC);
        fcase();
        reconhece(Token.FC);
    }
    
    /**
     * Reconhece o comando 'case'
     */
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
    
    /**
     * Reconhece caracteres, numeros ou caracteres entre aspas simples
     */
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
    
    /**
     * Reconhece o comando 'if'
     */
    private void fif() {
        reconhece(Token.IF);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        bloco();
    }
    
    /**
     *  Reconhece o comando 'do while'
     */
    private void fdowhile() {
        reconhece(Token.DO);
        bloco();
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        reconhece(Token.PTVIRG);
    }
    
    /**
     * Implementacao do lambda da GLC
     */
    private void lambda() { }//Lambda sendo um metodo que nao faz nada.
    
    /**
     * Reconhece infinitos comandos
     */
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
    
    /**
     * Reconhece a atribuicao
     */
    public void atribuicao() {
        if(proxTokenIs(Token.VAR)){
            leProxToken();
            elemento();
        }
        else{
            lambda();
        }
    }

    /**
     * Tira a recursao de atribuicao
     */
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
    
    /**
     * Reconhece expressoes
     */
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
    
    /**
     * Tira a recursao do exp(expressao)
     */
    public void s(){
        if(proxTokenIs(Token.OPBI)||proxTokenIs(Token.OPBIUN)){
            op();
            exp();
            s();
        }
        else{
            //Atribuicao se torna vazio, possibilitanto for(;i<10;){...}
            lambda();
        }
    }
    
    /**
     * Reconhece Operacoes Binarias e Unarias
     */
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