public class Item {
    private int code;
    private String name;
    private float price;
    private int quantity;

    public Item (int code, String name, float price, int quantity){
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }
    public float getPrice(){
        return this.price;
    }
    public int getQuantity(){
        return this.quantity;
    }
}
