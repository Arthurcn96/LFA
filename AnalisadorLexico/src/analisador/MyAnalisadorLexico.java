package analisador;

/**
 * Aonde esta convertido toda a maquina de Moore em codigo
 * @author Grupo6
 */
public class MyAnalisadorLexico extends AnalisadorLexico {
    
    /**
     * Construtor
     * @param _nomeArquivoEntrada Caminho do arquivo de entrada
     */
    public MyAnalisadorLexico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }
    
    /**
     * O estado inicial da maquina no qual a maquina pode ir para qualquer outro
     * estado reconhecivel
     */
    public void s0() {
        saida = "" + this.proxCaractere;
        
        if(this.proxCaractere == ABREPAR) {
            leProxCaractere();
            q1();
        }
        else if(this.proxCaractere == FECHAPAR) {
            leProxCaractere();
            q2();
        }
        else if(this.proxCaractere == APOST) {
            leProxCaractere();
            q3();
        }
        else if(this.proxCaractere==ABRECHAVES) {  
            leProxCaractere();
            q4();
        }
        else if(this.proxCaractere==FECHACHAVES){
            leProxCaractere();
            q5();
        }
        else if (this.proxCaractere==PTOVIRG){
            leProxCaractere();
            q6();
        }
        else if (this.proxCaractereIs(OPUNARIO)){
            leProxCaractere();
            q7();
        }
        else if (this.proxCaractere==DOISPONTOS){
            leProxCaractere();
            q8();
        }
        else if(this.proxCaractereIs(OPBINUNARIO)){// +|-
            leProxCaractere();
            q9();
        }
        else if(this.proxCaractere==OPIGUAL){
            leProxCaractere();
            q10();
        }
        else if(this.proxCaractere==PONTO){
            leProxCaractere();
            q11();
        }
        else if(this.proxCaractere==E){
            leProxCaractere();
            q12();
        }
        else if(this.proxCaractere==OU){
            leProxCaractere();
            q13();
        }
        else if(this.proxCaractereIs(VAZIOS)){
            leProxCaractere();
            s0();
        }
        else if (this.proxCaractereIs(OPBINARIO)){
            //Caso seja >|< podemos esperar um <=|>=
            if(this.proxCaractereIs(">")||this.proxCaractereIs("<")){
                leProxCaractere();
                q14();
            }
            else{
                leProxCaractere();
                q15();
            }
        }
        else if(this.proxCaractere=='d'){//do
            leProxCaractere();
            q16();
        }
        else if(this.proxCaractere=='i'){//if
            leProxCaractere();
            q17();
        }
        else if(this.proxCaractere=='f'){//for
            leProxCaractere();
            q18();
        }
        else if(this.proxCaractere=='c'){//case
            leProxCaractere();
            q19();
        }
        else if (this.proxCaractere=='w'){//while
            leProxCaractere();
            q20();
        }
        else if(this.proxCaractere=='s'){//switch
            leProxCaractere();
            q21();
        }
        else if(this.proxCaractereIs(LETRAS)){
            leProxCaractere();
            q22();
        }
        
        else if(this.proxCaractereIs(DIGITOS)) {
            leProxCaractere();
            q23();
        }
        
        else if(this.proxCaractere == EOF){
            this.tokenReconhecido = Token.EOF;
        }else
            throw new ErroLexico(this.proxCaractere,DIGITOS+LETRAS+PTOVIRG+OPBINARIO+OPBINUNARIO+"\n"+DOISPONTOS+OPIGUAL+APOST+ABRECHAVES+FECHACHAVES+ABREPAR+FECHAPAR+OPUNARIO+PONTO+E+E+OU+OU);
        
    }
    
    /**
     * Reconhece 'Abre Parenteses'
     */
    public void q1() {
        this.tokenReconhecido = Token.AP;
        }

    /**
     * Reconhece 'Fecha Parenteses'
     */
    public void q2() {
        this.tokenReconhecido = Token.FP;
    }

    /**
     * Reconhece 'Apostrofo'
     */
    public void q3() {
        this.tokenReconhecido = Token.APOST;
    }

    /**
     * Reconhece 'Abre chaves'
     */
    public void q4() {
        this.tokenReconhecido = Token.AC;
    }

    /**
     * Reconhece 'Fecha chaves'
     */
    public void q5(){
        this.tokenReconhecido = Token.FC;
    }

    /**
     *Reconhece 'Ponto e virgula'
     */
    public void q6(){
        this.tokenReconhecido = Token.PTVIRG;
    }

    /**
     * Reconhece Operacoes Unarias
     */
    public void q7(){ 
        if(this.proxCaractere==OPIGUAL){
        saida = saida + this.proxCaractere;
            leProxCaractere();
            q40();
        }else
            this.tokenReconhecido = Token.OPUN;
    }

    /**
     * Reconhece 'Dois Pontos'
     */
    public void q8(){
        this.tokenReconhecido = Token.DP;
    }

    /**
     * Reconhece Operador binario
     */
    public void q9(){
        this.tokenReconhecido = Token.OPBIUN;
    }

    /**
     * Reconhece = ou ==  
     */
    public void q10(){
        if(this.proxCaractere==OPIGUAL){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q41();
        }
        else
            this.tokenReconhecido = Token.OPIG;
    }

    /**
     * Reconhece Numeros
     */
    public void q11(){
        if(this.proxCaractereIs(DIGITOS)){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q43();
        }else
            this.tokenReconhecido = Token.PONTO;
   }

    /**
     * Reconhece 'e comercial'
     */
    public void q12(){
       if(this.proxCaractere==E){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q41();
       }else 
           throw new ErroLexico(this.proxCaractere,"&");
   }

    /**
     * Reconhece |
     */
    public void q13(){
       if(this.proxCaractere==OU){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q41();
       }else
           throw new ErroLexico(this.proxCaractere,"|");
   }

    /**
     * Reconhece 'maior igual' ou 'menor igual'
     */
    public void q14(){
        if(this.proxCaractere==OPIGUAL){
           saida = saida + this.proxCaractere;
            leProxCaractere();
            q41();
        }else
            this.tokenReconhecido = Token.OPBI;
    }

    /**
     * Reconhece Operadoes Binarios
     */
    public void q15(){
        this.tokenReconhecido = Token.OPBI;
    }

    /**
     * Reconhece 'o' (do)ou String
     */
    public void q16(){
        if(this.proxCaractere=='o'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q24();
        }
        else{
            q22();
        }
   }

    /**
     * Reconhece um 'f' (if) ou String
     */
    public void q17(){
        if(this.proxCaractere=='f'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q25();
       }
       else{
           q22();
       }
   }

    /**
     * Reconhece um 'o'(for) ou String
     */
    public void q18(){
       if(this.proxCaractere=='o'){
       saida = saida + this.proxCaractere;
           leProxCaractere();
           q26();
       }
       else{
           q22();
       }
   }

    /**
     * Reconhece 'a'(case) ou String
     */
    public void q19(){
       if(this.proxCaractere=='a'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q28();
       }
       else{
           q22();
       }
   }

    /**
     * Reconhece 'h'(while) ou String
     */
    public void q20(){
       if(this.proxCaractere=='h'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q31();
       }
       else {
           q22();
       }
   }

    /**
     * Reconhece 'w'(switch) ou String
     */
    public void q21(){
       if(this.proxCaractere=='w'){
       saida = saida + this.proxCaractere;
           leProxCaractere();
           q35();
       }
       else{
           q22();
       }
   }

    /**
     * Reconhece qualquer combinacao de letras
     */
    public void q22(){
       if(this.proxCaractereIs(LETRAS)){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q22();
       }
       else{
           this.tokenReconhecido = Token.VAR;
        }
   }

    /**
     * Reconhece numeros reais
     */
    public void q23(){  
        if(this.proxCaractereIs(DIGITOS)) {
           saida = saida + this.proxCaractere;
            leProxCaractere();
            q23();
        }
        else if(this.proxCaractere==PONTO){
           saida = saida + this.proxCaractere;
            leProxCaractere();
            q42();
        }else 
            this.tokenReconhecido = Token.NUM;
    }

    /**
     * Reconhece o token 'do' ou uma String
     */
    public void q24(){
       if(this.proxCaractereIs(LETRAS)){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q22();
       }else
           this.tokenReconhecido = Token.DO;
   }
   
    /**
     * Reconhece o token 'if' ou uma String qualquer
     */
    public void q25(){
        if(this.proxCaractereIs(LETRAS)){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q22();
       }else
           this.tokenReconhecido = Token.IF;
   }

    /**
     * Reconhece o 'r'(for) ou uma String qualquer
     */
    public void q26(){
       if(this.proxCaractere=='r'){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q27();
       }
       else{  
           q22();
       }
   }

    /**
     * Reconhece o 'for' ou uma string qualquer
     */
    public void q27(){
        if(this.proxCaractereIs(LETRAS)){
        saida = saida + this.proxCaractere;
            leProxCaractere();
            q22();
         }else
            this.tokenReconhecido = Token.FOR;
   }

    /**
     * Reconhece o 's'(case) ou uma string qualquer
     */
    public void q28(){
        if(this.proxCaractere=='s'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q29();
       }
       else{
           q22();
       }
   }

    /**
     * Reconhece 'e'(case) ou uma string qualquer
     */
    public void q29(){
        if(this.proxCaractere=='e'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q30();
       }
       else{
           q22();
       }
   }

    /**
     * Reconhece o token 'case' ou uma string qualquer
     */
    public void q30(){
        if(this.proxCaractereIs(LETRAS)){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q22();
       }else
            this.tokenReconhecido = Token.CASE;
            
   }

    /**
     * Reconhece 'i'(while) ou uma string qualquer
     */
    public void q31(){
         if(this.proxCaractere=='i'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q32();
       }else{
           q22();
       }
   }

    /**
     * Reconhece 'l'(while) ou uma string qualquer
     */
    public void q32(){
        if(this.proxCaractere=='l'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q33();
       }else{
           q22();
       }
   }

    /**
     * Reconhece 'e'(while) ou uma string qualquer
     */
    public void q33(){
        if(this.proxCaractere=='e'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q34();
       }else{
           q22();
       }
   }

    /**
     *Reconhece o token 'while' ou uma string qualquer
     */
    public void q34(){
       if(this.proxCaractereIs(LETRAS)){
       saida = saida + this.proxCaractere;
           leProxCaractere();
           q22();
       }else
           this.tokenReconhecido = Token.WHILE;
   }

    /**
     * Reconhece 'i'(switch) ou uma string qualquer
     */
    public void q35(){
       if(this.proxCaractere=='i'){
       saida = saida + this.proxCaractere;
           leProxCaractere();
           q36();
       }else{
           q22();
       }
   }

    /**
     * Reconhece o 't'(switch) ou uma string qualquer
     */
    public void q36(){
        if(this.proxCaractere=='t'){
           saida = saida + this.proxCaractere;
            leProxCaractere();
            q37();
        }else{
            q22();
        }
   }

    /**
     * Reconhece o 'c'(switch) ou uma string qualquer
     */
    public void q37(){
        if(this.proxCaractere=='c'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q38();
       }else{
           q22();
       }
   }

    /**
     *Reconhece o 'h'(switch) ou uma string qualquer
     */
    public void q38(){
       if(this.proxCaractere=='h'){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q39();
       }else{
           q22();
       }
   }

    /**
     * Reconhecer o token 'switch' ou uma string qualquer
     */
    public void q39(){
       if(this.proxCaractereIs(LETRAS)){
            saida = saida + this.proxCaractere;
            leProxCaractere();
            q22();
       }else
           this.tokenReconhecido = Token.SWITCH;
   }

    /**
     * Reconhece Operacao Binaria
     */
    public void q40(){
        this.tokenReconhecido = Token.OPBI;
    }

    /**
     * Reconhece Operacao Binaria
     */
    public void q41(){
        this.tokenReconhecido = Token.OPBI;
    }

    /**
     * Reconhece um conjunto de numeros ou um numero
     */
    public void q42(){
       if(this.proxCaractereIs(DIGITOS)){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q43();
       }else
           this.tokenReconhecido = Token.NUM;
   }

    /**
     * Reconhece um conjunto de numeros
     */
    public void q43(){
       if(this.proxCaractereIs(DIGITOS)){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q43();
       }else
           this.tokenReconhecido = Token.NUM;
   }
}
