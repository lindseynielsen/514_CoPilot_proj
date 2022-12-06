/*
 * Constructor Detail
GroceryMain
public GroceryMain()
Method Detail
main
public static void main​(String[] args)
"Main" function that begins and directs the execution line.
Parameters:
args -
 */
public class GroceryMain {
    public static void main(String[] args) {
        GroceryTrip groceryApp = new GroceryTrip();

        groceryApp.printOptions();

        String firstAction = groceryApp.getAction();
        groceryApp.actionLoop(firstAction);
    }
}