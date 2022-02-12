import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public Item insert(){
        
        Scanner keyboard = new Scanner(System.in);

        int code;
        String name;
        float price;
        int quantity;


        //Capturar dados do produto atual:
        System.out.println("\n\nInsira os dados do produto: \n");

            System.out.print("    - Código: ");
            code = keyboard.nextInt();
            keyboard.nextLine();

            System.out.print("\n    - Nome: ");
            name = keyboard.next();
            keyboard.nextLine();

            System.out.print("\n    - Preço: ");
            price = keyboard.nextFloat();
            keyboard.nextLine();

            System.out.print("\n    - Quantidade: ");
            quantity = keyboard.nextInt();
            keyboard.nextLine();


        Item item = new Item(code, name, price, quantity);
        return item;
    }

    public void review (List<Item> l) {

        System.out.println("\n**REVISAR**");
        for (Item item: l){
            System.out.println("    *"+item.getName()+":");
                System.out.println("        - COD "+item.getCode());
                System.out.println("        - $"+item.getPrice());
                System.out.println("        - x"+item.getQuantity());
        }


        //Cálculo de valor total (preço * quantidade)
        float total = 0;
        for (Item item: l){
            total += (item.getPrice() * item.getQuantity());
        }

        System.out.println("TOTAL: $"+total);
    }

    public Boolean start(){

        //Texto de cabeçalho ("título") da aplicação
        String header = "||Sistema de faturamento automático||";
        System.out.println("\n"+header);


        List<Item> items;
        items = new ArrayList<Item>();

        //Populando lista de itens, só será finalizado se solicitado
        Boolean loop = true;
        while(loop){

            //Limpar tela
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.println("\n"+header);

            Item item = insert();
            items.add(item);


            System.out.println("Finalizar? (s)");
            char choice = 'n';
            try {
                choice = (char) System.in.read();

                if (choice == 's'){
                    loop = false;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        System.out.println("\n"+header);

        review(items);

        return true;
    }
}
