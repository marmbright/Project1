import java.util.ArrayList;

/**
 * Creates warehouse
 */
public class Warehouse {

    public String name;
    public int totInv;
    public int invOnSale;
    public double price;

    public Warehouse (String name, int totInv, int invOnSale, double price){
        this.name = name;
        this.totInv = totInv;
        this.invOnSale = invOnSale;
        this.price = price;
    }
    public double getPrice(ArrayList<BikePart> list) {
        double totPrice = 0.0;

        for (BikePart temp : list) {
            if (temp.onSale) {
                totPrice = totPrice + temp.salesPrice;
            } else {
                totPrice = totPrice + temp.price;
            }
        }
        return totPrice;
    }

    public int getTotInv(ArrayList<BikePart> list){
        int quant = 0;
        for (BikePart temp : list) {
            quant = quant + temp.quantity;
        }
        return quant;
    }

    public int getInvOnSale(ArrayList<BikePart> list) {
        int quantSale = 0;
        for (BikePart temp : list) {
            if (temp.onSale) {
                quantSale++;
            }
        }
        return quantSale;
    }
}
