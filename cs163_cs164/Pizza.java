package cs163_cs164;
/*
 * Step 1: App Runthrough
Before you begin to program try to run through the Application in its entirety. Do this by following the method calls and reading through what each method does after it is called.

Once you feel that you have a decent understanding, run the application in zyBook's Develop Mode. It will not display the correct output until you have completed the required methods within Pizza.java, but it should still run in its current state.

The following steps will be implemented by you within the Pizza.java file.
Within the main method of the OpenPizzaOrderingApp.java

Step 2: calculateBasePizzaPrice()
To begin with this method, the variables pizzaSize & numToppings must be set within the Pizza object, this is already done within the application and tester files.

Using the pizzaSize & numToppings, it sets the correct pizza price. The pizza price ranges from 1-3, whichever size is chosen is multiplied by a factor of 6.5 and added to the pizzaPrice variable that also present within the Pizza object. The same applies to numToppings, 0-10, which is multiplied by a factor of .65.

Example: Given a size 2 pizza & 0 toppings the pizza's base price would be $13.00. Given a size 3 pizza with 4 toppings the pizza's base price would be $22.10.

Step 3: addDeliveryFee(int delivery)
This method takes a singular parameter, delivery, which will be a 1 or 0 depending if the application user requested delivery. When the delivery is 1, 5 will be added to the running pizzaPrice variable. When the delivery is 0, no fee needs to be added.

A simple multiplication statement is the best solution to this method.

Step 4: addPizzaTax(int taxRate)
This methods single parameter is a whole number, the taxRate variable. Using this taxRate, you will calculate the tax that would be applied to this pizza using the base price and added delivery fee.

The taxRate parameter will be provided as a whole number, so it should be converted to a decimal to make the tax calculation more simple.

Step 5: getPrepTime()
getPrepTime follows the same logic as the calculateBasePrice() method, but instead of a price, this method will calculate the time it takes to prep this pizza and then return that value. The pizzaSize is now multiplied by a factor of 8 and then added to a variable. The numToppings is then multiplied by a factor of 1.5 and added to you previously declared variable.

After you add both products to your variable, you then return it.
 */
public class Pizza {
    int pizzaSize = 0;
    int numToppings = 0;
    double pizzaPrice = 0;
    double tax = 0;

    public void setSize(int size) {
        pizzaSize = size;
    }

    public void setToppings(int toppings) {
        numToppings = toppings;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public void calculateBasePizzaPrice() {
        //TODO Student
        //Step 2: calculateBasePizzaPrice()
        //To begin with this method, the variables pizzaSize & numToppings must be set within the Pizza object, this is already done within the application and tester files.
        //Using the pizzaSize & numToppings, it sets the correct pizza price. The pizza price ranges from 1-3, whichever size is chosen is multiplied by a factor of 6.5 and added to the pizzaPrice variable that also present within the Pizza object. The same applies to numToppings, 0-10, which is multiplied by a factor of .65.
        //Example: Given a size 2 pizza & 0 toppings the pizza's base price would be $13.00. Given a size 3 pizza with 4 toppings the pizza's base price would be $22.10.
        pizzaPrice = (pizzaSize * 6.5) + (numToppings * .65);
    }

    public void addDeliveryFee(int delivery) {
        //TODO Student
        //Step 3: addDeliveryFee(int delivery)
        //This method takes a singular parameter, delivery, which will be a 1 or 0 depending if the application user requested delivery. When the delivery is 1, 5 will be added to the running pizzaPrice variable. When the delivery is 0, no fee needs to be added.
        //A simple multiplication statement is the best solution to this method.
        if (delivery == 1) {
            pizzaPrice += 5;
        }
    }


    public void addPizzaTax(int taxRate) {
        //TODO Student
        //Step 4: addPizzaTax(int taxRate)
        //This methods single parameter is a whole number, the taxRate variable. Using this taxRate, you will calculate the tax that would be applied to this pizza using the base price and added delivery fee.
        //The taxRate parameter will be provided as a whole number, so it should be converted to a decimal to make the tax calculation more simple.
        tax = pizzaPrice * (taxRate / 100.0);
        
    }

    public double getPrepTime() {
        //TODO Student
        //Step 5: getPrepTime()
        //getPrepTime follows the same logic as the calculateBasePrice() method, but instead of a price, this method will calculate the time it takes to prep this pizza and then return that value. The pizzaSize is now multiplied by a factor of 8 and then added to a variable. The numToppings is then multiplied by a factor of 1.5 and added to you previously declared variable.
        //After you add both products to your variable, you then return it.
        return (pizzaSize * 8) + (numToppings * 1.5);
    }
}
