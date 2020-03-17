import java.util.ArrayList;

public class Van {
    public String vanName;
    public ArrayList<BikePart> vanInv;

    public Van(String name, ArrayList<BikePart> vanInv){
        this.vanName = name;
        this.vanInv = vanInv;
    }

    public String getVanName() {
        return vanName;
    }

    public ArrayList<BikePart> getVanInv() {
        return vanInv;
    }

    public void setVanInv(ArrayList<BikePart> vanInv) {
        this.vanInv = vanInv;
    }
}
