/*
Megan Armbright
Section 1
I hereby declare upon my word of honor that I have neither given nor received unauthorized help on this work.
 */

public class BikePart{

    public String partName;
    public String partNumber;
    public double price;
    public double salesPrice;
    public boolean onSale;
    public int quantity;

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

    public String getPartNumber (){
        return this.partNumber;
    }
}
