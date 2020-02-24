import java.util.ArrayList;

public class Warehouse{

    public String name;
    public int totInv;
    public int invOnSale;
    public double price;

    public double getPrice(ArrayList<BikePart> list) {
        double totPrice = 0.0;
        for (int i = 0; i < list.size(); i++) {
            BikePart temp = list.get(i);
            if (temp.onSale) {
                totPrice = totPrice + temp.salesPrice;
            } else {
                totPrice = totPrice + temp.price;
            }
        }
        return totPrice;
    }

    public int getTotInv(ArrayList<BikePart> list) {
        int quant = 0;
        for (int i = 0; i < list.size(); i++) {
            BikePart temp = list.get(i);
            quant = quant + temp.quantity;
        }
        return quant;
    }

    public int getInvOnSale(ArrayList < BikePart > list){
        int quantSale = 0;
        for (int i = 0; i < list.size(); i++) {
            BikePart temp = list.get(i);
            if (temp.onSale) {
                quantSale++;
            }
        }
        return quantSale;
    }
}