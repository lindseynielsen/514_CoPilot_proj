package cs165;

import java.util.Scanner;


/**
 * Recitation created by Gareth Halladay, 08/17. <br>
 * Content was gathered from two sources:
 * <ul>
 *     <li> http://www.cs.wustl.edu/~kjg/cse131/modules/recursion/lab.html
 *     <li> http://codingbat.com/prob/p273235?parent=/home/bono@usc.edu/recursionLab
 * </ul>
 *
 */
public class Recursion {

    /**
     * Every number after the first two is the sum of the two preceding ones. <br>
     * For each index 0, 1, 2, 3, 4, 5, 6... <br>
     * the output is: 0, 1, 1, 2, 3, 5, 8... <br>
     * When you run this method, your output should look like this: <br>
     * Testing the fibonacci method <br>
     * index:  0, 1, 2, 3, 4, 5, 6... <br>
     * output: 0, 1, 1, 2, 3, 5, 8...
     * @param n the index of the Fibonacci sequence
     * @return the nth value in the Fibonacci sequence
     */
    public static int fib(int n){
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }        
    }

    /**
     * Write a multiplication method recursively using repeated addition. <br>
     * Do not use the multiplication operator or a loop.
     *
     * @param j a positive or negative integer.
     * @param k a positive or negative integer.
     * @return the product of the k and j.
     */
    public static int mult(int j, int k){
        if (k == 0) {
            return 0;
        } else if (k > 0) {
            return j + mult(j, k - 1);
        } else {
            return -j + mult(j, k + 1);
        }
    }

    /**
     * Write a method that computes j^k. <br>
     * Do not use Math.pow() or a loop. <br>
     * @param j a non-negative number
     * @param k a non-negative number
     * @return j^k
     */
    public static int expt(int j, int k){
        if (k == 0) {
            return 1;
        } else {
            return j * expt(j, k - 1);
        }
    }


    /**
     * Check to see if a word is a palindrome. Should be case-independent.
     * @param word a String without whitespace
     * @return true if the word is a palindrome
     */
    public static boolean isPalindrome(String word){
        if (word.length() <= 1) {
            return true;
        } else if (Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(word.charAt(word.length() - 1))) {
            return isPalindrome(word.substring(1, word.length() - 1));
        } else {
            return false;
        }

    }

    /**
     * Returns length of the longest word in the given String using recursion (no loops).
     * Hint: a Scanner may be helpful for finding word boundaries. After delimiting by space,
     * use the following method on your String to remove punctuation {@code .replaceAll("[^a-zA-Z]", "")}
     * If you use a Scanner, you will need a helper method to do the recursion on the Scanner object.
     *
     * @param words A String containing one or more words.
     * @return The length of the longest word in the String.
     * @see Scanner#Scanner(String)
     * @see Scanner#next()
     * @see String#split(String)
     * @see String#replaceAll(String, String)
     * @see Math#max(int, int)
     */
    public static int longestWordLength(String words){
        Scanner scan = new Scanner(words);
        return longestWordLengthHelper(scan);
    }


    /**
     * Helper method for longestWordLength
     * @param scan a Scanner object
     * @return the length of the longest word in the String
     */
    private static int longestWordLengthHelper(Scanner scan){
        if (!scan.hasNext()) {
            return 0;
        } else {
            String word = scan.next().replaceAll("[^a-zA-Z]", "");
            return Math.max(word.length(), longestWordLengthHelper(scan));
        }
    }



    /**
     * Remove consecutive duplicate characters from a String. <br>
     * Case should not matter, if two or more consecutive duplicate <br>
     * characters have different cases, then the first letter should be kept.
     * @param word A word with possible consecutive duplicate characters.
     * @return A word without any consecutive duplicate characters.
     */
    /*
TO DO:
1. Write a method to remove consecutive duplicate characters from a String.

If two or more consecutive duplicate characters have different cases, then the first letter should be kept.
For example, "aAaA" should be changed to "aa" and not "aaaA" or "aaaa".


When you run this method, your output should look like this:
Testing the dedupeChars method
dedupeChars("a") should be a -> a
dedupeChars("aa") should be a -> a

dedupeChars("MiSsisSiPpi") should be MiSisiPi -> MiSisiPi
dedupeChars("Mississippi") should be MiSisiPi -> MiSisiPi
dedupeChars("swimMmMming") should be swiming -> swiming
dedupeChars("swimming") should be swiming -> swiming
     */
    //If two or more consecutive duplicate characters have different cases, then the first letter should be kept.
    //For example, "aAaA" should be changed to "aa" and not "aaaA" or "aaaa".
    //Hint Work backwards



    public static String dedupeChars(String word){
        if (word.length() <= 1) {
            return word;
        } else if (Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(word.charAt(1))) {
            return dedupeChars(word.substring(1));
        } else {
            return word.charAt(0) + dedupeChars(word.substring(1));
        }
    }

    /**
     * Remove consecutive duplicate words from a String. <br>
     * Case should not matter, if two or more consecutive duplicate <br>
     * words have different cases, then the first word should be kept.
     * @param words A word with possible consecutive duplicate words.
     * @return A word without any consecutive duplicate words.
     */
    /*

    /**
     * Write a method that takes a String and returns a new String that contains the original String
     * reversed. Do not use loops or any extra Strings.
     * @param word A String to reverse.
     * @return A String that contains the original String reversed.
     */
    public static String reverse(String word){
        if (word.length() <= 1) {
            return word;
        } else {
            return reverse(word.substring(1)) + word.charAt(0);
        }
    }

    /**
     * Write a method that takes a String and returns a new String that contains the original String
     * reversed. Do not use loops or any extra Strings.
     * @param word A String to reverse.
     * @return A String that contains the original String reversed.
     */
    public static String reverse2(String word){
        if (word.length() <= 1) {
            return word;
        } else {
            return reverse(word.substring(1)) + word.charAt(0);
        }
    }

    /**
     * Write a method that takes a String and returns a new String that contains the original String
     * reversed. Do not use loops or any extra Strings.
     * @param word A String to reverse.
     * @return A String that contains the original String reversed.
     */
    public static String reverse3(String word){
        if (word.length() <= 1) {
            return word;
        } else {
            return reverse(word.substring(1)) + word.charAt(0);
        }
    }

    /**
     * Write a method that takes a String and returns a new String that contains the original String
     * reversed. Do not use loops or any extra Strings.
     * @param word A String to reverse.
     * @return A String that contains the original String reversed.
     */
    public static String reverse4(String word){
        if (word.length() <= 1) {
            return word;
        } else {
            return reverse(word.substring(1)) + word.charAt(0);
        }
    }


    public static void main(String [] args){
        // Test your methods here!
        // Uncomment each block as you are ready to test it.
        //Note: in zyBooks the main in Main.java will run instead, and it is all of the below statements.

        
        System.out.println("Testing the fibonacci method");
        System.out.printf("fib(0) should be 0 -> %d\n", fib(0));
        System.out.printf("fib(1) should be 1 -> %d\n", fib(1));
        System.out.printf("fib(2) should be 1 -> %d\n", fib(2));
        System.out.printf("fib(5) should be 5 -> %d\n", fib(5));
        System.out.printf("fib(10) should be 55 -> %d\n", fib(10));
        System.out.printf("fib(13) should be 233 -> %d\n", fib(13));
        System.out.println();

        System.out.println("Testing out the multiplication method");
        System.out.printf("mult(8, 2) should be 16 -> %d\n", mult(8, 2));
        System.out.printf("mult(2, 8) should be 16 -> %d\n", mult(2, 8));
        System.out.printf("mult(4, -3) should be -12 -> %d\n", mult(4, -3));
        System.out.printf("mult(-3, 4) should be -12 -> %d\n", mult(-3, 4));
        System.out.println();

        System.out.println("Testing out the exponent method");
        System.out.printf("expt(2, 5) should be 32 -> %d\n", expt(2, 5));
        System.out.printf("expt(5, 2) should be 25 -> %d\n", expt(5, 2));
        System.out.println();

        System.out.println("Testing out the palindrome method");
        System.out.printf("isPalindrome(\"a\") should be true -> %b\n", isPalindrome("a"));
        System.out.printf("isPalindrome(\"Aibohphobia\") should be true -> %b\n", isPalindrome("Aibohphobia"));
        System.out.printf("isPalindrome(\"noon\") should be true -> %b\n", isPalindrome("noon"));
        System.out.printf("isPalindrome(\"Recursion\") should be false -> %b\n", isPalindrome("Recursion"));
        System.out.println();

        System.out.println("Testing out the longestWordLength method\n");
        String quoteOne =
                "Grit, one of the keys to success. The person who perseveres is the one who\n" +
                        "will surely win. Success does not come from giving up, it comes from believing\n" +
                        "in yourself and continuously working towards the realization of a worthy ideal.\n" +
                        "Do not ever give up on what you want most. You know what you truly want.\n" +
                        "Believe in your dreams and goals and take daily consistent action in order to\n" +
                        "make your dreams a reality.";
        System.out.printf("The longest word in the following quote:\n%s\nshould be 12 -> %d\n\n", quoteOne, longestWordLength(quoteOne));
        String quoteTwo = "Try to be like the turtle ??? at ease in your own shell.";
        System.out.printf("The longest word in the following quote:\n%s\nshould be 6 -> %d\n\n", quoteTwo, longestWordLength(quoteTwo));
        System.out.println();

        System.out.println("Testing the dedupeChars method");
        System.out.printf("dedupeChars(\"a\") should be a -> %s\n", dedupeChars("a"));
        System.out.printf("dedupeChars(\"aa\") should be a -> %s\n", dedupeChars("aa"));
        System.out.printf("dedupeChars(\"MiSsisSiPpi\") should be MiSisiPi -> %s\n", dedupeChars("MiSsisSiPpi"));
        System.out.printf("dedupeChars(\"swimMmMming\") should be swiming -> %s\n", dedupeChars("swimMmMming"));
        
    }
}
