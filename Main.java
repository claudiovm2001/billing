import java.util.Scanner;

public class Main {

    //Texto de cabeçalho ("título") da aplicação
    public static String header = "||Sistema de faturamento automático||";
    
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        boolean loop = true;
        while (loop){

            Transaction trans = new Transaction();
            trans.begin();

            String choice = "n";

            System.out.println("\n|FECHAR CAIXA? (s)|");
            choice = keyboard.next();
            keyboard.reset();            

            if (choice.toLowerCase().equals("s")){
                loop = false;
            }
        }
        
    }
}
