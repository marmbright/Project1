import java.util.ArrayList;

public class Vans {
    public String vanName;
    public ArrayList<BikePart> vanInv;

    public Vans(String name, ArrayList<BikePart> inv){
        this.vanName = name;
        this.vanInv = inv;
    }

    private String getVanName() {
        return vanName;
    }

    public ArrayList<BikePart> getVanInv() {
        return vanInv;
    }

    public void setVanInv(ArrayList<BikePart> vanInv) {
        this.vanInv = vanInv;
    }
}
