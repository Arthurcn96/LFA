package analisadorlexico;

 
public class MyAnalisadorLexico extends AnalisadorLexico {
    
    public MyAnalisadorLexico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }
    
    public void s0() {//Todas as primeiras opcoes possiveis
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
           //saida = saida + this.proxCaractere;
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
           //saida = saida + this.proxCaractere;
            leProxCaractere();
            q16();
        }
        else if(this.proxCaractere=='i'){//if
           //saida = saida + this.proxCaractere;
            leProxCaractere();
            q17();
        }
        else if(this.proxCaractere=='f'){//for
           //saida = saida + this.proxCaractere;
            leProxCaractere();
            q18();
        }
        else if(this.proxCaractere=='c'){//case
           //saida = saida + this.proxCaractere;
            leProxCaractere();
            q19();
        }
        else if (this.proxCaractere=='w'){//while
           //saida = saida + this.proxCaractere;
            leProxCaractere();
            q20();
        }
        else if(this.proxCaractere=='s'){//switch
           //saida = saida + this.proxCaractere;
            leProxCaractere();
            q21();
        }
        else if(this.proxCaractereIs(LETRAS)){
           //saida = saida + this.proxCaractere;
            leProxCaractere();
            q22();
        }
        
        else if(this.proxCaractereIs(DIGITOS)) {
           //saida = saida + this.proxCaractere;
            leProxCaractere();
            q23();
        }
        
        else if(this.proxCaractere == EOF){
            this.tokenReconhecido = Token.EOF;
        }else
            throw new ErroLexico(this.proxCaractere,DIGITOS+LETRAS+PTOVIRG+OPBINARIO+OPBINUNARIO+"\n"+DOISPONTOS+OPIGUAL+APOST+ABRECHAVES+FECHACHAVES+ABREPAR+FECHAPAR+OPUNARIO+PONTO+E+E+OU+OU);
        
    }
    
    public void q1() {
        //saida = saida + this.proxCaractere;
        this.tokenReconhecido = Token.AP;
        }
    public void q2() {
        //saida = saida + this.proxCaractere;
        this.tokenReconhecido = Token.FP;
    }
    public void q3() {
        //saida = saida + this.proxCaractere;
        this.tokenReconhecido = Token.APOST;
    }
    public void q4() {
        //saida = saida + this.proxCaractere;
        this.tokenReconhecido = Token.AC;
    }
    public void q5(){
        //saida = saida + this.proxCaractere;
        this.tokenReconhecido = Token.FC;
    }
    public void q6(){//Ponto e virgula
        //saida = saida + this.proxCaractere;
        this.tokenReconhecido = Token.PTVIRG;
    }
    public void q7(){//Operacoess unarias 
        //leProxCaractere();
        if(this.proxCaractere==OPIGUAL){
        saida = saida + this.proxCaractere;
            leProxCaractere();
            q40();
        }else
            this.tokenReconhecido = Token.OPUN;
    }
    public void q8(){
        //saida = saida + this.proxCaractere;
        this.tokenReconhecido = Token.DP;
    }
    public void q9(){
        //saida = saida + this.proxCaractere;
        this.tokenReconhecido = Token.OPBIUN;
    }
    public void q10(){
        if(this.proxCaractere==OPIGUAL){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q41();
        }
        else
            this.tokenReconhecido = Token.OPIG;
    }
   public void q11(){
        if(this.proxCaractereIs(DIGITOS)){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q43();
        }else
            this.tokenReconhecido = Token.PONTO;
   }
   public void q12(){
       if(this.proxCaractere==E){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q41();
       }else 
           throw new ErroLexico(this.proxCaractere,"&");
   }
   public void q13(){
       if(this.proxCaractere==OU){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q41();
       }else
           throw new ErroLexico(this.proxCaractere,"|");
   }
    public void q14(){
        if(this.proxCaractere==OPIGUAL){
           saida = saida + this.proxCaractere;
            leProxCaractere();
            q41();
        }else
            this.tokenReconhecido = Token.OPBI;
    }
    public void q15(){
        //saida = ""+this.proxCaractere;
        this.tokenReconhecido = Token.OPBI;
    }
   public void q16(){
        if(this.proxCaractere=='o'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q24();
        }
        else{
            //leProxCaractere();
            q22();
        }
   }
   public void q17(){
        if(this.proxCaractere=='f'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q25();
       }
       else{
           //leProxCaractere();
           q22();
       }
   }
   public void q18(){
       if(this.proxCaractere=='o'){
       saida = saida + this.proxCaractere;
           leProxCaractere();
           q26();
       }
       else{
           //leProxCaractere();
           q22();
       }
   }
   public void q19(){
       if(this.proxCaractere=='a'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q28();
       }
       else{
           //leProxCaractere();
           q22();
       }
   }
   public void q20(){
       if(this.proxCaractere=='h'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q31();
       }
       else {
           //leProxCaractere();
           q22();
       }
   }
   public void q21(){
       if(this.proxCaractere=='w'){
       saida = saida + this.proxCaractere;
           leProxCaractere();
           q35();
       }
       else{
           //leProxCaractere();
           q22();
       }
   }
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
   public void q24(){
       if(this.proxCaractereIs(LETRAS)){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q22();
       }else
           this.tokenReconhecido = Token.DO;
   }
   
   public void q25(){
        if(this.proxCaractereIs(LETRAS)){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q22();
       }else
           this.tokenReconhecido = Token.IF;
   }
   public void q26(){
       if(this.proxCaractere=='r'){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q27();
       }
       else{  
           //leProxCaractere();
           q22();
       }
   }
   public void q27(){
        if(this.proxCaractereIs(LETRAS)){
        saida = saida + this.proxCaractere;
            leProxCaractere();
            q22();
         }else
            this.tokenReconhecido = Token.FOR;
   }
   public void q28(){
        if(this.proxCaractere=='s'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q29();
       }
       else{
           //leProxCaractere();
           q22();
       }
   }
   public void q29(){
        if(this.proxCaractere=='e'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q30();
       }
       else{
           //leProxCaractere();
           q22();
       }
   }
   public void q30(){
        if(this.proxCaractereIs(LETRAS)){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q22();
       }else
            this.tokenReconhecido = Token.CASE;
            
   }
   public void q31(){
         if(this.proxCaractere=='i'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q32();
       }else{
           //leProxCaractere();
           q22();
       }
   }
   public void q32(){
        if(this.proxCaractere=='l'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q33();
       }else{
           //leProxCaractere();
           q22();
       }
   }
   public void q33(){
        if(this.proxCaractere=='e'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q34();
       }else{
           //leProxCaractere();
           q22();
       }
   }
   public void q34(){
       if(this.proxCaractereIs(LETRAS)){
       saida = saida + this.proxCaractere;
           leProxCaractere();
           q22();
       }else
           this.tokenReconhecido = Token.WHILE;
   }
   public void q35(){
       if(this.proxCaractere=='i'){
       saida = saida + this.proxCaractere;
           leProxCaractere();
           q36();
       }else{
           //leProxCaractere();
           q22();
       }
   }
   public void q36(){
        if(this.proxCaractere=='t'){
           saida = saida + this.proxCaractere;
            leProxCaractere();
            q37();
        }else{
            //leProxCaractere();
            q22();
        }
   }
   public void q37(){
        if(this.proxCaractere=='c'){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q38();
       }else{
           //leProxCaractere();
           q22();
       }
   }
   public void q38(){
       if(this.proxCaractere=='h'){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q39();
       }else{
           //leProxCaractere();
           q22();
       }
   }
   public void q39(){
       if(this.proxCaractereIs(LETRAS)){
            saida = saida + this.proxCaractere;
            leProxCaractere();
            q22();
       }else
           this.tokenReconhecido = Token.SWITCH;
   }
    public void q40(){
          // saida = saida + this.proxCaractere;
        this.tokenReconhecido = Token.OPBI;
    }
    public void q41(){
          // saida = saida + this.proxCaractere;
        this.tokenReconhecido = Token.OPBI;
    }
   public void q42(){
       if(this.proxCaractereIs(DIGITOS)){
           saida = saida + this.proxCaractere;
           leProxCaractere();
           q43();
       }else
           this.tokenReconhecido = Token.NUM;
   }
   public void q43(){
       if(this.proxCaractereIs(DIGITOS)){
        saida = saida + this.proxCaractere;
           leProxCaractere();
           q43();
       }else
           this.tokenReconhecido = Token.NUM;
   }
}
