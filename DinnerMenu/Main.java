public class Main {
    public static void main(String[] args) {
        Menu breakfastMenu = new PancakeHouseMenu();
        Menu lunchMenu = new DinerMenu();
        Menu dinnerMenu = new DinnerMenu();

        breakfastMenu.addItem("Pancake", "Delicious pancake with syrup", true, 2.99);
        breakfastMenu.addItem("Waffles", "Waffles with blueberries", true, 3.49);

        lunchMenu.addItem("Vegetarian BLT", "Fake bacon with lettuce & tomato", true, 2.99);
        lunchMenu.addItem("BLT", "Bacon with lettuce & tomato", false, 2.99);

        dinnerMenu.addItem("Steak", "Grilled steak with potatoes", false, 15.99);
        dinnerMenu.addItem("Vegetarian Pasta", "Pasta with vegetables", true, 11.99);

        Waitress waitress = new Waitress(breakfastMenu, lunchMenu, dinnerMenu);
        waitress.printMenu();
    }
}
