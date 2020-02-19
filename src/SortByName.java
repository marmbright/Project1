import java.util.Comparator;
public class SortByName implements Comparator<BikePart> {
    public int compare(BikePart x, BikePart y) {
        return x.getPartName().compareToIgnoreCase(y.getPartName());
    }
}
