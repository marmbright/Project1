import java.util.ArrayList;

public class Warehouse {

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
    }

    public int getTotInv(){
        return totInv;
    }

    public int getInvOnSale() {
        return invOnSale;
    }
}
