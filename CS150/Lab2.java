package cs150;

import java.util.Scanner;

/*Menu Options (Step 1)
Many programs have menu’s of actions to perform. However, the only way to know the options is to tell your client what they are allowed to do. Locate the printOptions TODO comment. This method simply prints several options, and that is it.

You first must write the method signature for this method below the TODO comment. The method is called printOptions() and it is a private static method that does not return anything. If a method does not return anything what is the keyword you should use?

The options you should print are as follows:

Menu Options
1) Add 
2) Subtract 
3) Multiply
4) Divide
0) Exit
Select a menu option:  
However, before you print the Menu Options you should print two blank lines. Additionally, the Select a menu option line SHOULD NOT print a newline after it. It should also have a space at the end. Do you think you would use System.out.println or System.out.print?

After you have completed the printOptions() method uncomment run() in the main method. run() will call the printOptions() method so you will be able to see your menu you just wrote.

REMINDER: You should be running your code as you work - just to see what is happening.

Splash Screen (Step 2)
Splash screens show up in many games and in applications. You just have to open up a copy of any mobile game such as Pokemon Go to see a splash screen. These are used to load background ‘assets’ into the memory of the computer, so the program can access them quickly. In your case, we are simply using splash screens so you can practice System.out.println.

First - find the Splash Screen method.

In this method, you will write a series of System.out.println to generate exactly the following in your console / output.

*************************
*       Welcome         *
*          to           *
*      Computer 1       *
*************************
For reference, their are 25 stars in the first line and last line

Add Numbers (Step 3)
Find the add method. This method has already been written for you but you should make sure that you understand what is happening within the method before completing the following methods.

The method signature for the method is:

private static double add(double num1, double num2)
The keyword private means that the method can only be accessed from within this class. The keyword static means that you do not have to create an instance of the class in order to call the add method from a separate method. The keyword double is the return type. So you must either return a double or a variable of type double in this method. add is the name of the method. double num1 and double num2 are the parameters. They are variable of type double that can be accessed anywhere within the add method.

Inside the method the following occurs:

double rtn;
rtn = num1+num2;
return rtn;
First a variable of type double called rtn is declared. That variable is then assigned to the solution of adding the two parameters (num1 and num2) together. rtn is then returned.

Hint: Use this method as a reference while completing the following methods.

Subtract Numbers (Step 4)
Find the subtract method. You will notice the following method signature.

private static double subtract(double num1, double num2) 
num1 and num2 are parameters or variables that are ‘passed’ into the method. You can use them. The purpose of the subtract method is to subtract num2 from num1, and then return the result.

For example:

If 5 and 5 are passed in, the result returned should be 0.

If 10 and 20 are passed in, the result returned should be -10.

If 2 and 1 are passed in, the result returned should be 1,.

Once this method is written, you can test the program by running it.

To get you started, you can copy and past the following into your Predefine program input (optional) box

2
5 5
2
10 20
2 
2 1
0
That will run every test above, and then exit the program. You should change it and run your own tests. Remember, programming is like playing a musical instrument, you only learn by practicing.

Multiply Numbers (Step 5)
Find the multiply method. You should multiply num1 and num2 together, and return the result. Remember, to run and test it.

Divide Numbers (Step 6)
Find the divide method. You should divide num1 by num2, and return the result.

Thinking further
If you wanted to write a method that ‘squares’ a number, and only takes in one number - how would you go about doing that? */

public class Lab2 {
   private static Scanner scanner = new Scanner(System.in);
    
   // TODO: write printOptions() method
    private static void printOptions() {
        System.out.println();
        System.out.println();
        System.out.println("Menu Options");
        System.out.println("1) Add");
        System.out.println("2) Subtract");
        System.out.println("3) Multiply");
        System.out.println("4) Divide");
        System.out.println("0) Exit");
        System.out.print("Select a menu option: ");
    }



    private static void splashScreen() {
        System.out.println("*************************");
        System.out.println("*       Welcome         *");
        System.out.println("*          to           *");
        System.out.println("*      Computer 1       *");
        System.out.println("*************************");
       // TODO
  
    }
    
    private static double add(double num1, double num2) {
        double rtn;
        rtn = num1+num2;
        return rtn; // is there a simpler way to do this? Maybe even keep it one line?

    }

    private static double subtract(double num1, double num2) {
        double rtn;
        rtn = num1-num2;
        return rtn;
    }

    private static double multiply(double num1, double num2) {
        double rtn;
        rtn = num1*num2;
        return rtn;
        
    }

    private static double divide(double num1, double num2) {
        double rtn;
        rtn = num1/num2;
        return rtn;
    }
    
    public static void main(String[] args) {
        splashScreen();
        run();
    }

    //################## Do not modify below this line ########################

    /**
     * The main driver for the application and the 'divide' and 'glue' (pretty common to be together).
     * Takes in client input from the console, and keeps running until 0 is typed.
     */
    private static void run() {
        printOptions();
        int option = scanner.nextInt();
        if(option == 0) { return; } // leave the recursive loop
        if(option > 4 || option < 0) {
            System.out.println("Invalid option");
        } else {
            System.out.print("\nEnter two numbers, with a space between them. ");
            double num1 = scanner.nextDouble();
            double num2 = scanner.nextDouble();
            double rtnVal = 0;
            if (option == 1) {
                rtnVal = add(num1, num2);   // NOTICE: how we just set the value based on the 'returned value'
            } else if (option == 2) {
                rtnVal = subtract(num1, num2);
            } else if (option == 3) {
                rtnVal = multiply(num1, num2);
            } else if (option == 4) {
                rtnVal = divide(num1, num2);
            }
            System.out.println("Your result is: " + rtnVal);
        }
        run(); // keep calling this method
    }
}
