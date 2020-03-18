import java.util.Comparator;

public class SortByName implements Comparator<BikePart> {

    /**
     * Compares two bikeparts to organize alphabetically by part name
     * @param x a bikepart
     * @param y a bikepart
     * @return returns the parts in order
     */
    public int compare(BikePart x, BikePart y) {
        return x.getPartName().compareToIgnoreCase(y.getPartName());
    }
}