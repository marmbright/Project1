import java.util.ArrayList;

public class Warehouse{

    public String name;
    public int totInv;
    public int invOnSale;
    public double price;

    public Warehouse(String name){
        this.name = name;
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
        price = totPrice;
        return price;
    }

    public int getTotInv(ArrayList<BikePart> list) {
        int quant = 0;
        for (BikePart temp : list) {
            quant = quant + temp.quantity;
        }
        totInv = quant;
        return totInv;

    }

    public int getInvOnSale(ArrayList < BikePart > list){
        int quantSale = 0;
        for (BikePart temp : list) {
            if (temp.onSale) {
                quantSale++;
            }
        }
        invOnSale = quantSale;
        return invOnSale;
    }
}