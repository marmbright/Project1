import java.util.Comparator;
public class SortByNumber implements Comparator<BikePart> {
    public int compare(BikePart x, BikePart y) {
        return x.getPartNumber().compareTo(y.getPartNumber());
    }
}