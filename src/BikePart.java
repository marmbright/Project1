/*
Megan Armbright
Section 1
I hereby declare upon my word of honor that I have neither given nor received unauthorized help on this work.
 */

public class BikePart{

    String partName;
    String partNumber;
    double price;
    double salesPrice;
    boolean onSale;
    int quantity;

    /**this class is to keep inventory of bike parts and their info
     * @param name This is the name
     * @param num This acts as the part number
     * @param price This is the normal price of the item
     * @param salesPrice This is the price of the item on sale
     * @param sale This determines whether the item is on sale or not
     */
    public BikePart (String name, String num, double price, double salesPrice, boolean sale, int quantity){
        this.partName=name;
        this.partNumber=num;
        this.price=price;
        this.salesPrice=salesPrice;
        this.onSale=sale;
        this.quantity=quantity;
    }

    public String getPartName (){
        return this.partName;
    }
    private void setPartName(String name){
        this.partName=name;
    }
    public String getPartNumber (){
        return this.partNumber;
    }
    private void setPartNumber(String num) {
        this.partName = num;
    }
    private double getPrice(){
        return this.price;
    }
    private void setPrice(double price){
        this.price=price;
    }
    private double getSalesPrice(){
        return this.salesPrice;
    }
    private void setSalesPrice(double salesPrice){
        this.salesPrice=salesPrice;
    }
    private boolean isOnSale(){
        return this.onSale;
    }
    private void setOnSale(boolean sale){
        this.onSale=sale;
    }
    private int getQuantity(){
        return this.quantity;
    }
    private void setQuantity(int quantity){
        this.quantity=quantity;
    }



}
