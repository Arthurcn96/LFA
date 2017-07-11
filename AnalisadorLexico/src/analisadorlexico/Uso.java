
import analisadorlexico.ErroLexico;
import analisadorlexico.ErroSintatico;
import analisadorlexico.MyAnalisadorSintatico;


public class Uso {
    static public MyAnalisadorSintatico parser;
    public static void main(String[] args) {
        try {
            if(args.length != 1)
                throw new RuntimeException("esqueceu de escrever o nome do arquivo de entrada! \n" + "No Eclipse insira em: Run - Open Run Dialog- Arguments");
            parser = new MyAnalisadorSintatico(args[0]);
            parser.inicio();
            System.out.println("Análise realizada com sucesso no arquivo "+parser.nomeArquivoEntrada);
        }
        catch(ErroLexico e) {
            System.out.println("Erro léxico: "+e.toString());
        }
        catch(ErroSintatico e) {
            System.out.println("Erro sintático: "+e.toString());
        }
        catch(RuntimeException e) {
            System.out.println("Erro: "+e.getMessage());
        }
    }
}
