package cs150;

/* 
Part 1: First Programmer
Recall from the lecture, who wrote the western world’s first computer program?
Answer: Ada Lovelace
You should add a space in the quotes in the following line of code, and type in her name.

 public static void main(String[] args) {
    System.out.println("The first computer program was written by:");
    //...
 }
Once that is done, you should click the “run program” button.

Part 2: Initializing a Variable
Note the following line of code that declares the variable theAnswer:

int theAnswer;
You need to initialize the variable theAnswer to be 42.

Part 3: Printing out The Answer
For your last problem in this lab, you should print out theAnswer on the line following the quote followed by a new line.

Which function should you use? print or println?
*/

/**
 *  CS 150 - Lab 1 
 *  Learning to Print
 *
 *
 * @author YOUR NAME <br>
 *         YOUR EMAIL <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 201990
 */

public class FirstPrint {

    public static void main(String[] args) {

        // Part 1: First Programmer 
        System.out.println("The first computer program was written by: Ada Lovelace");

        // Part 2
        int theAnswer   = 42;   // initialize theAnswer to be 42        

        // Part 3
        System.out.print("The answer to the Ultimate Question of Life, the Universe, and Everything is ");
        System.out.println(theAnswer);

    }
}
