import java.util.Comparator;

public class SortByNumber implements Comparator<BikePart> {

    /**
     * Compares two bikeparts to organize numerically by part number
     * @param x a bikepart
     * @param y a bikepart
     * @return returns the parts in order
     */
    public int compare(BikePart x, BikePart y) {
        return x.getPartNumber().compareTo(y.getPartNumber());
    }
}