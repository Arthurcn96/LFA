package analisador;

/**
 *
 * @author Grupo6
 */
public class MyAnalisadorLexico extends AnalisadorLexico {
    
    /**
     * Lexico
     * @param _nomeArquivoEntrada
     */
    public MyAnalisadorLexico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }
    
    /**
     *
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
        else if(this.proxCaractere==OPUNARIO){
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
     *
     */
    public void q1() {
        this.tokenReconhecido = Token.AP;
        }

    /**
     *
     */
    public void q2() {
        this.tokenReconhecido = Token.FP;
    }

    /**
     *
     */
    public void q3() {
        this.tokenReconhecido = Token.APOST;
    }

    /**
     *
     */
    public void q4() {
        this.tokenReconhecido = Token.AC;
    }

    /**
     *
     */
    public void q5(){
        this.tokenReconhecido = Token.FC;
    }

    /**
     *
     */
    public void q6(){//Ponto e virgula
        this.tokenReconhecido = Token.PTVIRG;
    }

    /**
     *
     */
    public void q7(){//Operacoess unarias 
        if(this.proxCaractere==OPIGUAL){
        saida = saida + this.proxCaractere;
            leProxCaractere();
            q40();
        }else
            this.tokenReconhecido = Token.OPUN;
    }

    /**
     *
     */
    public void q8(){
        this.tokenReconhecido = Token.DP;
    }

    /**
     *
     */
    public void q9(){
        this.tokenReconhecido = Token.OPBIUN;
    }

    /**
     *
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
     *
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
     *
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
     *
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
     *
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
     *
     */
    public void q15(){
        this.tokenReconhecido = Token.OPBI;
    }

    /**
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
     */
    public void q22(){//Todas as combinacoes de letras
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
     */
    public void q40(){
        this.tokenReconhecido = Token.OPBI;
    }

    /**
     *
     */
    public void q41(){
        this.tokenReconhecido = Token.OPBI;
    }

    /**
     *
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
     *
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
