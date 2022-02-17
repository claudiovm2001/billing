import java.io.IOException;
import java.util.Scanner;

public class Program {

    //Texto de cabeçalho ("título") da aplicação
    public static String header = "||Sistema de faturamento automático||";
    
    public void start(){

        Scanner keyboard = new Scanner(System.in);

        boolean loop = true;
        while (loop){

            Transaction trans = new Transaction();
            trans.begin();

            String choice = "n";

            System.out.println("\n|FECHAR CAIXA? (s)|");
            choice = keyboard.next();
            keyboard.reset();            

            if (choice.equals("s")){
                loop = false;
            }
        }
        
    }
}
