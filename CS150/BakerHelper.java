package CS150;

import java.util.Random;

/**
 *
 *  CS 150 - Methods, Conditionals, and Math with Cake!
 *
 *   Topics Covered:
 *   		Method declaration and body practice
 *   		If conditional practice
 *   	   Complex If Statements
 *   		Constant introduction
 *   		Math class method practice
 *   		Division and modulo introduction
 *   
 *
 * @author YOUR NAME
 *         YOUR EMAIL
 *         Computer Science Department
 *         Colorado State University
 * @version 201990
 */


 /*
  * At the top of your class, you should declare the following variables as static and final

CUPS_FLOUR_PER_CAKE

Initialize it in the same line to 2.3. As such, it should be a double.

PIECES_PER_CAKE
Initialize it to 8. As such, it should be an int.

NOT_ENOUGH_FLOUR
Initialize it to -1

EXACT_CAKE
Initialize it to 0

EXTRA_CAKE
Initialize it to 1

here an example of declaring the first one to give you an idea:

static final double CUPS_FLOUR_PER_CAKE = 2.3;

These variables are final / constants (meaning you can’t change them) and are available at the class level. This last part means every method in the class has access to them and can be used in every method!

To test this, go to your main, and put in the following code:

System.out.println(CUPS_FLOUR_PER_CAKE);
System.out.println(PIECES_PER_CAKE);
Run your program, and it should simply print 2.3 and 8 to the console.

Step 2 - calcNumCakesBaked
For this step you will write the method calcNumCakesBaked. Here are some important things you need to know before writing this method

Math.floor
Math.floor takes in a double value, and returns whole number portion. It is a static method in the Math object. For example, if I put in Math.floor(10.6) it will return 10.0. If I put in Math.floor(10.1) it would also return 10.0. Notice it is returning a double.
Casting
Sometimes you want to convert a double to an int. As there is a loss of precision (the decimals), you have explicitly state you want to do that. As such, you use (int) for example, (int)3.14 returns the int 3 (notice no decimal point).
Write calcNumCakesBaked
Now go to the method section of your file, and write a public static method
called calcNumCakesBakes that returns an int. It takes in a double in the parameter that represents the number of cupsOnHand. For example the method signature could look like this:

public static int calcNumCakesBaked(double cupsOnHand)
Inside the method you need to do the following:

1) It needs to return - as a whole number - the number of possible cakes one can build based on the cups of flour the baker has on hand.

cupsOnHand is the amount of flour the baker has
CUPS_FLOUR_PER_CAKE tells you how many cups it takes to bake a cake

As such, the formula to figure out how many cakes you can bake is:

cakes = cupsOnHand / CUPS_FLOUR_PER_CAKE

You must declare cakes as a variable of type int inside your method.
2) The problem - you have to return an int, rounded down that represents the number of cakes. Use the Math.floor method, and casting to help you with that.

Test calcNumCakesBaked
Always test each method after writing (ideally while writing). So go down to your main method, and put in the following tests:

System.out.println("#### Testing calcNumCakesBaked");
System.out.println(calcNumCakesBaked(0));
System.out.println(calcNumCakesBaked(2.3));
System.out.println(calcNumCakesBaked(3));
System.out.println(calcNumCakesBaked(42));
Now double check the output. Is it what you think it should be?

Step 3 - getCakeEnthusiasts
There is a little known fact, that no matter how large of the party, only a max of 19 people want cake. This “fact” is even stranger, the number is actually based the remainder of the total guests at a party divided by 20. So if there are 100 guests, no one wants cake, but if there are 117 guests 17 of them want cake. Ok, we made it up, to give you practice with modulo, but let’s get this party started.

% operator - as a quick reminder, the modulo operator returns the remainder of a long division. If you have 17, and you divide by 10, the remainder would be 7. Written in java, that would be 17 % 10. Extra tutorial.
Write getCakeEnthusiasts
The public static method getCakeEnthusiasts returns an int. It also needs the parameter of type int that represents the number of party goers (e.g. partySize) to work. What would that method signature look like?

Using the partySize, simply mod it (%) by 20, and return the answer.

Test getCakeEnthusiasts
We just wrote three to four lines of code, time to test!

Go to your main, and add the following tests:

System.out.println("#### Testing getCakeEnthusiasts ####");
System.out.println(getCakeEnthusiasts(21));
System.out.println(getCakeEnthusiasts(3));
System.out.println(getCakeEnthusiasts(20));
System.out.println(getCakeEnthusiasts(42));
System.out.println(getCakeEnthusiasts(100000001));
Did the results come out as you expected?

Step 4 - getMessage
It is very common in applications to have a method return a message based on a message ‘type’ passed to it. This allows for easy language integrations, and one place to change the messages. This method follows the same model with three messages. You will pass in an int value (the message type), and return one of three possible messages.

Write getMessage
You will write a public static method called getMessage that returns a String. The method will have a single int parameter that represents the message type. What would the signature look like?

Now you will have the method signature return a message String based on the type, as follows:

Sorry. You do not have enough flour to bake a cake.
Message Type: anything less than 0
No left over cake.
Message Type: equal to 0
Yay, left over cake!
Message Type: anything greater than 0
You will notice there are only three message types: less than 0, 0, or greater than 0. This is fairly common in programming.

Test getMessage
You just wrote three to four lines of code - time to test again! Put the following into your main method, and run the program. Did you get what you expected?

System.out.println("### TESTING getMessage ###");
System.out.println(getMessage(-1));
System.out.println(getMessage(0));
System.out.println(getMessage(1));
Step 5 - determineLeftoverCake
This method wants to look at the total number of cakes you can bake and compare it to the number of folks at the party who want cake. Based on the answer, you will return NOT_ENOUGH_FLOUR, EXACT_CAKE, or EXTRA_CAKE.

This method will use:

complex logic
Both || and &&
Write determineLeftoverCake
determineLeftoverCake is a public static method that returns an int value which is either NOT_ENOUGH_FLOUR, EXACT_CAKE, or EXTRA_CAKE. For the method to work, you will need both the number of people, and the number of cakes. Putting that together, our method signature could look like:

 public static int determineLeftoverCake(int cakes, int people) 
The first thing you will want to do is determine the number of pieces of cake. This is done by multiplying the PIECES_PER_CAKE times the number of cakes. We called the answer variable numPiecesCake.

You will then write the following conditions:

if cakes is less than or equal to 0 or numPiecesCake is less than people, return NOT_ENOUGH_FLOUR.
if people is greater than 0 and the numPiecesCake minus the number of people is 0, return EXACT_CAKE
Lastly, it means you have more than enough cake, so return EXTRA_CAKE
Test determineLeftoverCake
You wrote a few more lines of code, it is best to test it. Put the following in your main method

System.out.println("### Testing determineLeftoverCake ###");
System.out.println(determineLeftoverCake(10, 10));
System.out.println(determineLeftoverCake(10, 80));
System.out.println(determineLeftoverCake(0, 9));
System.out.println(determineLeftoverCake(1, 8));
Is it returning what you think it should?

Step 6 - Gluing it together!
Go ahead and uncomment the randomTests method, and the method call to randomTests in main. And run it!

Look through randomTests how is it working to put it all together?
  */
public class BakerHelper {
   public static final Random RND = new Random(); // do not modify, but use as an example of a class variable  
   
   // declare your class-level variables here
    public static final int PIECES_PER_CAKE = 8;
    public static final double CUPS_FLOUR_PER_CAKE = 2.0;
    public static final int NOT_ENOUGH_FLOUR = -1;
    public static final int EXACT_CAKE = 0;
    public static final int EXTRA_CAKE = 1;

   // declare your methods here

    public static int calcNumCakesBaked(double cupsFlour) {
        return (int) Math.floor(cupsFlour / CUPS_FLOUR_PER_CAKE);
    }

    public static int getCakeEnthusiasts(int partySize) {
        return partySize % 20;
    }

    public static String getMessage(int messageType) {
        if (messageType < 0) {
            return "Sorry. You do not have enough flour to bake a cake.";
        } else if (messageType == 0) {
            return "No left over cake.";
        } else {
            return "Yay, left over cake!";
        }
    }

    public static int determineLeftoverCake(int cakes, int people) {
        int numPiecesCake = cakes * PIECES_PER_CAKE;
        if (cakes <= 0 || numPiecesCake < people) {
            return NOT_ENOUGH_FLOUR;
        } else if (people > 0 && numPiecesCake - people == 0) {
            return EXACT_CAKE;
        } else {
            return EXTRA_CAKE;
        }
    }
   
   
   
   public static void main(String[] args) {
      // add your own tests here
      
    
       randomTests(); // uncomment when mostly done  
   }
   

   static void randomTests() {
        for(int i = 0; i < 20; i++) {
            System.out.println(getMessage(determineLeftoverCake(calcNumCakesBaked(getCupsOnHand()),
                                                                getCakeEnthusiasts(getRSVP()))));
        }
    }
  
   
// ************** don't modify below this line ************************
   /**
    * Gets a random number of people who are attending the party
    * @returns random whole number from 0-99 of party goers
    **/
    public static int getRSVP() {
        return RND.nextInt(100);
    }

   /**
    * Gets a random number of cups of flour to see how much to have
    * @returns  random double number between 0-9
    **/
    public static double getCupsOnHand() {
        return RND.nextInt(10) + RND.nextDouble();
    }
    
}
