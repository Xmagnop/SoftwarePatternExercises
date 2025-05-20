import java.util.Iterator;

public class Waitress {
    private Menu breakfastMenu;
    private Menu lunchMenu;
    private Menu dinnerMenu;

    public Waitress(Menu breakfast, Menu lunch, Menu dinner) {
        this.breakfastMenu = breakfast;
        this.lunchMenu = lunch;
        this.dinnerMenu = dinner;
    }

    public void printMenu() {
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(breakfastMenu.createIterator());

        System.out.println("\nLUNCH");
        printMenu(lunchMenu.createIterator());

        System.out.println("\nDINNER");
        printMenu(dinnerMenu.createIterator());
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.printf("%s, %.2f -- %s\n", item.getName(), item.getPrice(), item.getDescription());
        }
    }
}
