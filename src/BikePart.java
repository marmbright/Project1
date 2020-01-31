public class BikePart {

    /**
     * Instance variables of the BikePart class
     */
    private String partName;
    private int partNum;
    private double listPrice;
    private double salePrice;
    private boolean onSale;

    /**
     * Constructor of the BikePart class
     *
     * @param partName  instanciates partName
     * @param partNum   instanciates partNum
     * @param listPrice instanciates listPrice
     * @param salePrice instanciates salePrice
     * @param onSale    instanciates onSale
     */
    public BikePart(String partName, int partNum, double listPrice, double salePrice, boolean onSale) {
        this.partName = partName;
        this.partNum = partNum;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.onSale = onSale;
    }

    /**
     * gets part name
     *
     * @return returns the part name
     */
    public String getPartName() {
        return partName;
    }

    /**
     * gets the part number
     *
     * @return returns the part number
     */
    public int getPartNum() {
        return partNum;
    }

    /**
     * gets the list price
     *
     * @return returns the list price
     */
    public double getListPrice() {
        return listPrice;
    }

    /**
     * gets the sale price
     *
     * @return returns the sale price
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * checks if the item is on sale
     *
     * @return returns if the item is on sale or not
     */
    public boolean getOnSale() {
        return onSale;
    }

    /**
     * converts the arrayList to a string
     *
     * @return returns a string of strings
     */
    public String toString() {
        return getPartName() + ", " + getPartNum() + ", " + getListPrice() + ", " + getSalePrice() + ", " + getOnSale();
    }
}
