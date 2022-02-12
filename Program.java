import java.util.Scanner;

public class Program {

    public Item insert(){
        
        Scanner keyboard = new Scanner(System.in);

        int code;
        String name;
        float price;
        int quantity;

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

    public void Review(){

    }

    public Boolean start(){

        System.out.println("\n||Sistema de faturamento automático||");

        Item item = insert();

        System.out.println("\n\n\n"+item.getCode() +"\n"+ 
                                    item.getName() +"\n"+ 
                                    item.getPrice() +"\n"+ 
                                    item.getQuantity()
        );

        return true;
    }
}
