package CS150;
import java.util.Scanner;

/**
 *  A simple Caesar Cipher encrypter and decrypter.
 *
 * @author YOUR NAME HERE <br>
 *         YOUR EMAIL <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 202010
 */

/*
 * Step 1 - Warm Up Method: charAtGame
For your first method, you will write a method from scratch, that checks to see if you guessed the right character, the String.charAt(int) method returns. For reference, you can read more about the charAt method by looking at this resource.

Writing the Method Signature
The method signature for this method is:

public static boolean charAtGame(String s, int index, char guess)
The method should return true if the character at the given index is the same as the guess, and false otherwise.


The method signature is essential for any method. You can look at all the other methods in the CaesarCipher.java class to see examples of different signatures. This method will need the following:

public
static
returns a boolean
It needs the following parameters to work
String str - a simple string that you will run charAt on
int loc - a location for that you are looking at in the string
char guess - the character you expect to be returned!
Work with your TA on making sure the method signature is correct, or your code will not compile. Often this part is about learning how to read the instructions. I personally just returned true until I got the code compiling!

Writing the charAtGame body

The body of the method should be very simple. You should use the String.charAt(int) method to get the character at the given index, and then compare it to the guess. If they are the same, return true, otherwise return false.


The body of the charAtGame is straight forward, and often, you can get yourself in trouble by over thinking. Follow these steps when writing the method body.

Write the method signature
Write the return statement
Write the body of the method
Test the method
Write the method signature
The method signature is the first thing you should write. It is the most important part of the method, and it is the part that will help you get the code to compile. If you get the method signature wrong, you will not be able to compile the code. If you get the method signature right, you will be able to compile the code, and then you can work on the body of the method.


Get the character from str based on the location! One way to do this is:

char c = str.charAt(loc);
Compare the character to the guess. If they are the same, return true, otherwise return false. One way to do this is:

if (c == guess) {
    return true;
} else {
    return false;
}
Test the method

char myChar = str.charAt(loc);
Then compare that character to the guess that is passed in. That comparison will tell you if you need to return true or false (or for pros, you can return the comparison directly).
That is it!

Testing charAtGame
At this point, your code should be compiling. While the other tests won’t work correctly, it is good to test the method you just wrote! (Hint: always test each method after writing it!!!)

Find the runTests() method, and uncomment the lines under the “Testing charAtGame” When you run your program, you should see

Testing charAtGame
true
false
What other tests can you add to this line? We don’t grade the tests, so add what you want to make sure you understand how it is working!

Step 2 - Warm Up Method: loopPrintExample
Let’s continue our warm-up, by practicing writing a loop. Go to the loopPrintExample method. You will see the signature is already in place and since this is a void method, nothing needs to be returned.

For this method, you will write a loop that loops through an entire string. For every character in the string, it will print out the character on unique line.

For example, if you call the method with:

loopPrintExample("hello");
The following will print to System.out

h
e
l
l
o
Writing loopPrintExample
First off, you know you are looping through a line, so you know you are going to need a for loop. You also know you are looking at every location in the line, so you are starting at 0 and looping until the end of the line. What method helps us get the total number of characters in a line? .length()

This means the loop you are creating, could look like the following

for(int i = 0; i < line.length(); i++) {
// add your print with charAt in here
}
Hint: I would compile after writing that line to make sure it compiles.

Now inside of your loop, you want to print out every character on a unique line. To get a single character based on the location in the string, we used charAt. To print out to the System.out with a newline after each print, would you use System.out.print or System.out.println?

Take those two concepts and combine them together.

Testing loopPrintExample
Go to the runTests method, and uncomment the lines that have loopPrintExample in them. You may also want to add your own method calls with words you want to print out. For example

loopPrintExample("riff-raff");
Step 3 - Warm Up Method: buildRepeatingString
Yet another warmup, and this one focuses on teaching you how to build a new string to return. Go to the buildRepeatingString method. You will notice it creates an empty string, and returns that

public static String buildRepeatingString(String str, int times) {
    String rtn = "";
    // your loop here
    return rtn;
}
The goal of this method is to build a new String (rtn), that is made up of the String str repeated a number of times equal to times with a space in between each one. For example,

buildRepeatingString("a", 2); // "a a"
buildRepeatingString("a", 3); // "a a a"
buildRepeatingString("ab", 2); // "ab ab"
Remember, to concatenate to a String, you just add to it, so

String myString = "a" + " " + "a";   // sets myString equal to "a a"
Writing buildRepeatingString
First, write a loop that goes from 0 to times. I would compile to make sure the loop is running correctly. Second, inside the loop concatenate onto rtn the value of str with an space added.

For the purposes of this assignment, you do not need to worry about a trailing space at the end of the line.

Testing buildRepeatingString
Once again, go to the runTests method. Uncomment the lines associated with buildRepeatingString and add your own lines to see if it is working as expected.

Step 4 - Writing Shift (Part of the Caesar Cipher)
For the first part of the Cipher, you are going to write a simple shift method, that takes in a character & int and shifts the character down the ASCII table by adding the int value to it. For example:

shift('A', 3); // returns 'D'
shift('A', 2); // return 'C'
shift('A', 32); // returns 'a'
When you add an int to a char, it converts them both to ints. How do you convert it back to a character? The answer: use (char)

char myCharacter = (char)65; // gives us 'A'
char myOtherCharacter = (char) (11+55); // gives us 'B'
Writing shift
Shift can be a single line method. Obviously, take out the method stub that just returns ‘x’ and put in your own line.

Testing shift
Once again, go to the runTests method. Uncomment the lines associated with shift and add your own lines to see if it is working as expected.

Step 5 - Encrypt
Find the encrypt method. You will see that it is already got a stub, that looks very similar to the buildRepeatingString method stub. This is because for encrypt, you are going to look at every character in the line, apply a shift and build a String with the return value of shift. This method combines what you have learned in he previous methods, and utilizes the shift method you build. Divide-Conquer-Glue.

Writing Encrypt
First write a loop that goes from 0 to the length of your line. Think about the loopPrintExample method you wrote. What were the conditions for the loop? You are probably dealing with similar conditions here. I would compile and run it maybe with a print, just to make sure you are looping through your line correctly.

Second, grabbing the character at a set location (charAt) call the shift method passing in the character and the shift value. This will apply the CaesarCipher shift for you. You will notice the shift returns a character, and you have to do something with that character - or you will loose it.

Third, take that character and concatenate it onto your return string. Think about how you concatenated a string in buildRepeatingString. Same idea but without the extra space!

Last, return the string you built (already part of the method stub)

Testing Encrypt
Go to your runTests() method, and uncomment the lines for testing encrypt. You will notice the decrypt method is really simple for the cipher, and is already implemented for you.

Build a working application
Last but not least, go to to the top of CaesarCipher file, and change

public static boolean RUN_TESTS = true;
to

public static boolean RUN_TESTS = false;
You will want to go explore CaesarMain now, and look through the provided code. We have actually built an interactive application that relies on your code to work! You can play with learning about charAt or the cipher when you run the application. I would do that now, and have fun playing the games.
 */

//CaesarCipher is the name of the class
public class Lab5 {
    public static boolean RUN_TESTS = false; // change this to false before submitting the assignment for gradin




    //public static boolean charAtGame(String s, int index, char guess)
    //public static boolean charAtGame(String s, int index, char guess)
    public static boolean charAtGame(String s, int index, char guess) {
        if(s.charAt(index) == guess) {
            return true;
        } else {
            return false;
        }
    }





    /**
     * takes in a string and returns true if the 'charAt location' is the character the student
     * guessed. Returns false otherwise.
     * @param str line to look at
     * @param loc the location of the character for char at
     * @param guess the character to guess
     * @return
     */
    public static boolean isGuessCorrect(String str, int loc, char guess) {
        return str.charAt(loc) == guess;
    }


  


    /**
     * takes in a string and prints out each character on a new line
     * @param line
     */



    /**
     * takes in a string and prints out each character on a new line
     * @param line
     */
    public static void loopPrintExample(String line) {
        for(int i = 0; i < line.length(); i++) {
            System.out.println(line.charAt(i));
        }
    }



    /**
     * Loops through a String, printing each individual character on a unique line
     * @param line the string to print
     * @return
     */


    /**
     * Builds a new String that is made up of the String str repeated a number of times equal to times with a space in between each one.
     * 
     * @param str the string to repeat
     * @param times the number of times to repeat
     * @return
     */


    /**
     * Takes in a character and an int, and shifts the character down the ASCII table by adding the int value to it.
     * @param c the character to shift
     * @param shift the amount to shift
     * @return
     */

    /**
     * Takes in a String and an int, and returns a new String that is the String repeated
     * the number of times equal to the int. For example, buildRepeatingString("a", 2) would
     * return "a a"
     * @param str the string to repeat
     * @param times the number of times to repeat
     * @return
     */
    public static String buildRepeatingString(String str, int times) {
        String rtn = "";

        // your loop here
        return rtn;
    }


    /**
     * Takes in a string, and builds another one that is the same string, separated by whitespace and repeated
     * 
     * 
     * by the number of times
     * 
     * 
     * @param str
     * @param times
     * @return
     */



    public static String buildRepeatingStringWithSpaces(String str, int times) {
        String rtn = "";

        


        return rtn;
    }

    /**
     * Takes in a character and an int, and returns a new character that is the original character shifted
     * down the ASCII table by the int value. For example, shift('A', 3) would return 'D'
     * @param c the character to shift
     * @param shift the amount to shift
     * @return
     */

    /**
     * Takes in a string and an int, and returns a new string that is the original string shifted down the
     * ASCII table by the int value. For example, encrypt("ABC", 3) would return "DEF"
     * @param str the string to encrypt
     * @param shift the amount to shift
     * @return
     */
    public static String encrypt(String str, int shift) {
        String rtn = "";

        // your loop here
        return rtn;
    }





    /**
     * Takes a character, and 'shifts' the character down the ASCII chart by adding an int value to character
     * and then returning the new character
     * @param c - character to shift
     * @param shift the amount of shift
     * @return - a new character
     */
    public static char shift(char c, int shift) {
        return (char)(c + shift);
    }


    /**
     * Loops through an entire string, shifts the character and builds a new string using the new
     * characters.
     * @param line line to 'encrypt'
     * @param shift the amount of shift to apply
     * @return the new encrypted line
     */
   


    public static String decrypt(String line, int shift) {
        String rtn = "";
        for (int i = 0; i < line.length(); i++) {
            rtn += shift(line.charAt(i), -shift);
        }
        return rtn;
    }


    public static void runTests() { // uncomment as needed
//        System.out.println("Testing charAtGame");
//        System.out.println(charAtGame("hello", 0, 'h'));
//        System.out.println(charAtGame("hello", 0, 'e'));
//        System.out.println();

//
//        System.out.println("Testing loop print");
//        loopPrintExample("hello"); // notice, no print needed, as print is in the method
//        loopPrintExample("jello");
//        System.out.println();


//        System.out.println("Testing build repeating string");
//        System.out.println(buildRepeatingString("a", 5));
//        System.out.println(buildRepeatingString("amy", 5));
//        System.out.println(buildRepeatingString("rory", -5)); // should print nothing!
//        System.out.println();




//        System.out.println("Testing Shift");
//        System.out.println(CaesarCipher.shift('A', 32));
//        System.out.println(CaesarCipher.shift('B', 32));
//        System.out.println(CaesarCipher.shift('C', 32));
//        System.out.println();


//        System.out.println("Testing Encrypt");
//        String companion = "AMY POND";
//        String encrypted = CaesarCipher.encrypt(companion, 10);
//        String decrypted = CaesarCipher.decrypt(encrypted, 10);
//        System.out.println(encrypted);
//        System.out.println(decrypted);
//        System.out.println(companion.equals(decrypted));
//        System.out.println();
//        System.out.println();
//        System.out.println();


    }

}
