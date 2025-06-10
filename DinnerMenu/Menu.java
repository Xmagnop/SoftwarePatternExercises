import java.util.Iterator;

public interface Menu {
    Iterator<MenuItem> createIterator();
    void addItem(String name, String description, boolean vegetarian, double price);
}
