import java.util.ArrayList;

/**
 * Class used to create van objects
 */
public class Van {
    public String vanName;
    public ArrayList<BikePart> vanInv;

    /**
     * Van constructor
     * @param name the name of the van
     * @param vanInv the vans inventory
     */
    public Van(String name, ArrayList<BikePart> vanInv){
        this.vanName = name;
        this.vanInv = vanInv;
    }

    public Van(){
        this.vanName="placeholder";
        this.vanInv= new ArrayList<BikePart>(  );

    }

    /**
     * getter for the name of the van
     * @return returns the name of the van
     */
    public String getVanName() {
        return vanName;
    }

    /**
     * getter for the van inventory
     * @return returns the van inventory
     */
    public ArrayList<BikePart> getVanInv() {
        return vanInv;
    }

    /**
     * setter for the van inventory
     * @param vanInv arraylist of the van inventory
     */
    public void setVanInv(ArrayList<BikePart> vanInv) {
        this.vanInv = vanInv;
    }
}
