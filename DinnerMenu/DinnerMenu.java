import java.util.Hashtable;
import java.util.Iterator;

public class DinnerMenu implements Menu {
    private Hashtable<String, MenuItem> menuItems;

    public DinnerMenu() {
        menuItems = new Hashtable<>();
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.put(name, new MenuItem(name, description, vegetarian, price));
    }

    public Iterator<MenuItem> createIterator() {
        return menuItems.values().iterator();
    }
}
