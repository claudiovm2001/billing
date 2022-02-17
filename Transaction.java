import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transaction {
    
    private List<Item> items;
    private Scanner keyboard;

    public void begin(){
        
        this.items = new ArrayList<Item>();
        keyboard = new Scanner(System.in);

        Boolean loop = true;
        while(loop){

            //Limpar tela
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.println(Program.header);
            System.out.println(); System.out.println(); System.out.println();

            insert();

        
            String choice = "n";

            System.out.println();
            System.out.println("Finalizar? (s)");
            choice = keyboard.next();
            keyboard.reset();
            
        
            if (choice.equals("s")){
                loop = false;
            }
            
        }

        System.out.print("\033[H\033[2J");  
            System.out.flush();

        System.out.println(Program.header);
        System.out.println(); System.out.println();

        review();
    
    }

    public void insert(){

        //Scanner keyboard = new Scanner(System.in);

        int code;
        String name;
        float price;
        int quantity;

        //Capturar dados do produto atual:
        System.out.println("Insira os dados do produto: ");
        System.out.println();

            System.out.print("    - Código: ");
            code = keyboard.nextInt();
            keyboard.reset();

            System.out.print("    - Nome: ");
            name = keyboard.next();
            keyboard.reset();

            System.out.print("    - Preço: ");
            price = keyboard.nextFloat();
            keyboard.reset();

            System.out.print("    - Quantidade: ");
            quantity = keyboard.nextInt();
            keyboard.reset();

        Item item = new Item(code, name, price, quantity);
        this.items.add(item);
    }

    public void review(){

        System.out.println("**REVISAR**");
        System.out.println();

        for (Item item: this.items){
            System.out.println("    *"+item.getName()+":");
                System.out.println("        - COD "+item.getCode());
                System.out.println("        - $"+item.getPrice());
                System.out.println("        - x"+item.getQuantity());
            
            System.out.println();
        }


        //Cálculo de valor total (preço * quantidade)
        float total = 0;
        for (Item item: this.items){
            total += (item.getPrice() * item.getQuantity());
        }

        System.out.println("TOTAL: $"+total);
    }

}