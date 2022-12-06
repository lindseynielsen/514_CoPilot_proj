import java.util.ArrayList;
/*
 * Field Detail
grocList
ArrayList<Grocery> grocList
Constructor Detail
GroceryList
public GroceryList()
Method Detail

getGrocList
public ArrayList<Grocery> getGrocList()

addGrocery
public void addGrocery​(Grocery groc)
Adds the given Grocery parameter to the grocList.
Parameters:
groc - Grocery object to be added to the ArrayList

removeGrocery
public void removeGrocery​(String grocName)
Loops through the grocList until the given grocName is found then it is removed from the list. Grocery.getName() will prove useful.
Parameters:
grocName - Name of Grocery object to remove.

toString
public String toString()
Loops through the grocList ArrayList and appends the toString() of each Grocery object to the strList variable. Using the Grocery.toString() method from the Grocery class will be handy for this method.
Each entry will have newline character between them. '\n'

 Broccoli which costs: $2.99, located in the aisle 12.
 Cheese which costs: $1.50, located in the aisle 3.
 Rop Tamen which costs: $4.25, located in the aisle 14.
 
Overrides:
toString in class Object

getAisleGroceries
public String getAisleGroceries​(int aisle)
Loops through the grocList and checks each Grocery object's aisle against the aisle parameter provided. Each Grocery that has the same aisle has its Grocery.toString() added to the aisleString variable, along with a newline character, '\n'.
Grocery.getAisle() will come in handy.

Parameters:
aisle - Int indicating which aisle groceries are being looked for.

getTotals
public String getTotals()
Gets the summation of all prices and calories contained in the GroceryList's Grocery objects.
 */

public class GroceryList {
    
    ArrayList<Grocery> grocList = new ArrayList<Grocery>();

    public ArrayList<Grocery> getGrocList() {
        return grocList;
    }

    public void addGrocery(Grocery groc) {
        grocList.add(groc);
    }

    /*
    * Student Self-Explanation:
    * 
    *
    *
    */
    public void removeGrocery(String grocName) {
        for(Grocery g: grocList) {
            if(false) { //TODO Student
                grocList.remove(g);
                break;
            }
        }
    }

    
//tostring()
    public String toString() {
        String strList = "";
        for(Grocery g: grocList) {
            strList += g.toString() + " ";
        }
        return strList;
    }

    public String getAisleGroceries(int aisle) {
        String aisleString = "";
        for(Grocery g: grocList) {
            if(false) { //TODO Student
                aisleString += g.toString() + " ";
            }
        }
        return aisleString;
    }

    //getTotals

    public String getTotals() {
        double priceSum = 0;
        int caloriesSum = 0;
        for(Grocery g: grocList) {
            priceSum += g.getPrice();
            caloriesSum += g.getCalories();
        }
        String rtn = "The total price of this Grocery Trip: $" + priceSum + '\n';
        rtn += "The total calories of this Grocery Trip: " + caloriesSum + "cal\n";
        return rtn;
    }
}