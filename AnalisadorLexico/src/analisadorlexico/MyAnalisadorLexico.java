package analisadorlexico;

 
public class MyAnalisadorLexico extends AnalisadorLexico {
    public MyAnalisadorLexico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }
    public void s0() {
        if(this.proxCaractereIs(DIGITOS)) {
            leProxCaractere();
            s2();
        }
        else if(this.proxCaractere == ABREPAR) {
            leProxCaractere();
            s3();
        }
        else if(this.proxCaractere == FECHAPAR) {
            leProxCaractere();
            s4();
        }
        else if(this.proxCaractere == APOST) {
            leProxCaractere();
            s8();
        }
        else if(this.proxCaractere==ABRECHAVES) {  
            leProxCaractere();
            s5();
        }
        else if(this.proxCaractere==FECHACHAVES){
            leProxCaractere();;
            s6();
        }
        else if (this.proxCaractere==PTOVIRG){
            leProxCaractere();
            s10();
        }
        else if(this.proxCaractere==OPUNARIO){
            leProxCaractere();
            s11();
        }
        else if (this.proxCaractereIs(OPBINARIO)){
            if(this.proxCaractereIs(">")||this.proxCaractereIs("<")){
                leProxCaractere();
                s37();
            }
            else{
                leProxCaractere();
                s12();
            }
        }
        else if (this.proxCaractere==DOISPONTOS){
            leProxCaractere();
            s13();
        }
        else if(this.proxCaractereIs(OPBINUNARIO)){
            leProxCaractere();
            s36();
        }
        else if(this.proxCaractere==OPIGUAL){
            leProxCaractere();
            s7();
        }
        else if(this.proxCaractere==PONTO){
            leProxCaractere();
            s43();
        }
        else if(this.proxCaractere==E){
            leProxCaractere();
            s39();
        }
        else if(this.proxCaractere==OU){
            leProxCaractere();
            s40();
        }
        else if(this.proxCaractereIs(LETRAS)){
            if(this.proxCaractere=='d'){
                leProxCaractere();
                s34();
            }
            else if(this.proxCaractere=='i'){
                leProxCaractere();
                s19();
            }
            else if(this.proxCaractere=='f'){
                leProxCaractere();
                s27();
            }
            else if(this.proxCaractere=='c'){
                leProxCaractere();
                s30();
            }
            else if (this.proxCaractere=='w'){
                leProxCaractere();
                s14();
            }
            else if(this.proxCaractere=='s'){
                leProxCaractere();
                s20();
            }
            else{
                leProxCaractere();
                s1();
            }
        }
        else if(this.proxCaractereIs(VAZIOS)){
            leProxCaractere();
            s0();
        }
        else if(this.proxCaractere == EOF){
            this.tokenReconhecido = Token.EOF;
        }else
            throw new ErroLexico(this.proxCaractere,DIGITOS+LETRAS+VAZIOS+PTOVIRG+HIFEN);
    }
    
    public void s2() {
        this.tokenReconhecido = Token.NUM;
        if(this.proxCaractereIs(DIGITOS)) {
            leProxCaractere();
            s2();
        }
        else if(this.proxCaractere==PONTO){
            leProxCaractere();
            s41();
        }
    }
    
    public void s3() {
        this.tokenReconhecido = Token.AP;
        }
    public void s4() {
        this.tokenReconhecido = Token.FP;
    }
    public void s8() {
        this.tokenReconhecido = Token.APOST;
    }
    public void s5() {
        this.tokenReconhecido = Token.AC;
    }
    public void s6(){
        this.tokenReconhecido = Token.FC;
    }
    public void s7(){
        this.tokenReconhecido = Token.OPIG;
        if(this.proxCaractere==OPIGUAL){
            leProxCaractere();
            s38();
        }
    }
    public void s10(){
        this.tokenReconhecido = Token.PTOVIRG;
    }
    public void s11(){
        this.tokenReconhecido = Token.OPUN;
        leProxCaractere();
        if(this.proxCaractere==OPIGUAL){
            leProxCaractere();
            s44();
        }   
    }
    
    public void s44(){
        this.tokenReconhecido = Token.OPBI;
    }
    public void s12(){
        this.tokenReconhecido = Token.OPBI;
    }
    public void s13(){
        this.tokenReconhecido = Token.DP;
    }
    public void s36(){
        this.tokenReconhecido = Token.OPBIUN;
    }
    public void s38(){
        this.tokenReconhecido = Token.OPBI;
    }
   public void s37(){
       this.tokenReconhecido = Token.OPBI;
       if(this.proxCaractere==OPIGUAL){
           leProxCaractere();
           s38();
       }
   }
   public void s41(){
       this.tokenReconhecido = Token.NUM;
       if(this.proxCaractereIs(DIGITOS)){
           leProxCaractere();
           s42();
       }
   }
   public void s42(){
       this.tokenReconhecido = Token.NUM;
       if(this.proxCaractereIs(DIGITOS)){
           leProxCaractere();
           s42();
       }
   }
   public void s43(){
       if(this.proxCaractereIs(DIGITOS)){
           leProxCaractere();
           s42();
       }
   }
   public void s39(){
       if(this.proxCaractere==E){
           leProxCaractere();
           s38();
       }
   }
   public void s40(){
       if(this.proxCaractere==OU){
           leProxCaractere();
           s38();
       }
   }
   public void s1(){
       if(this.proxCaractereIs(LETRAS)){
           leProxCaractere();
           s1();
       }
       else{
           this.tokenReconhecido = Token.VAR;
        }
   }
   public void s34(){
        if(this.proxCaractere=='o'){
           leProxCaractere();
           s35();
        }
        else{
            leProxCaractere();
            s1();
        }
   }
   public void s35(){
       this.tokenReconhecido = Token.DO;
       if(this.proxCaractereIs(LETRAS)){
           leProxCaractere();
           s1();
       }
   }
   
   public void s19(){
       if(this.proxCaractere=='f'){
           leProxCaractere();
           s26();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s26(){
       this.tokenReconhecido = Token.IF;
       if(this.proxCaractereIs(LETRAS)){
           leProxCaractere();
           s1();
       }
   }
   public void s27(){
       if(this.proxCaractere=='o'){
           leProxCaractere();
           s28();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s28(){
       if(this.proxCaractere=='r'){
           leProxCaractere();
           s29();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s29(){
       this.tokenReconhecido = Token.FOR;
       if(this.proxCaractereIs(LETRAS)){
            leProxCaractere();
            s1();
       }
   }
   public void s30(){
       if(this.proxCaractere=='a'){
           leProxCaractere();
           s31();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s31(){
       if(this.proxCaractere=='s'){
           leProxCaractere();
           s32();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s32(){
       if(this.proxCaractere=='e'){
           leProxCaractere();
           s33();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s33(){
       this.tokenReconhecido = Token.CASE;
       if(this.proxCaractereIs(LETRAS)){
           leProxCaractere();
           s1();
       }
   }
   public void s14(){
       if(this.proxCaractere=='h'){
           leProxCaractere();
           s15();
       }
       else {
           leProxCaractere();
           s1();
       }
   }
   public void s15(){
       if(this.proxCaractere=='i'){
           leProxCaractere();
           s16();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s16(){
       if(this.proxCaractere=='l'){
           leProxCaractere();
           s17();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s17(){
       if(this.proxCaractere=='e'){
           leProxCaractere();
           s18();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s18(){
       this.tokenReconhecido = Token.WHILE;
       if(this.proxCaractereIs(LETRAS)){
           leProxCaractere();
           s1();
       }
   }
   public void s20(){
       if(this.proxCaractere=='w'){
           leProxCaractere();
           s21();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s21(){
       if(this.proxCaractere=='i'){
           leProxCaractere();
           s22();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s22(){
        if(this.proxCaractere=='t'){
            leProxCaractere();
            s23();
        }
        else{
            leProxCaractere();
            s1();
        }
   }
   public void s23(){
       if(this.proxCaractere=='c'){
           leProxCaractere();
           s24();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s24(){
       if(this.proxCaractere=='h'){
           leProxCaractere();
           s25();
       }
       else{
           leProxCaractere();
           s1();
       }
   }
   public void s25(){
       this.tokenReconhecido = Token.SWITCH;
       if(this.proxCaractereIs(LETRAS)){
            leProxCaractere();
            s1();
       }
   }
}
