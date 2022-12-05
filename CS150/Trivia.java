package cs150;
import java.util.Scanner;
/*
 * Checking a Word
For this method you will write code to determine whether or not a given word has a length of 5 and has an ‘a’ in the middle.

The method is a public static method called aWord that returns a boolean. It has one parameter of type String that represents a word. If the word has a length of 5 and has an ‘a’ in the middle (third letter) return true otherwise return false.

Hint: You will need to use charAt() and length() String methods.

Testing aWord
Uncomment the code provided for you in the main method with aWord in them, and input a word where it says: “Enter program input (optional)”, keep previous inputs.

Checking if Palindrome
For this method you will reverse a String, and check whether or not it is a palindrome.

The method is a public static method called reverse that returns a boolean. It has one parameter of type String that represents a word. You will want to create a String variable in the method to hold the reversed String.

When reversing a String in a for loop you want your loop variable to start at one less then the length of the String and end at the beginning of the String. The reason you start at one less then the length of is because String index’s are zero based. You will then want to decrement (using –) your loop variable.

Once you have set up your for loop concatenate each character onto your String that contains the reversed String. Then you want to compare the orginal string and your new one to see if they match, if they do return true otherwise return false.(Hint: Comparing strings can’t be done with “==” you must use “.equals()”)

Testing reverse
Uncomment the code provided for you in the main method with reverse in it to test the method you just wrote, and input a String where it says: “Enter program input (optional)”, keep previous inputs. Feel free to add your own test cases to test the method.
 */

public class Trivia {

    //TODO: isLeapYear
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    //TODO: isPrime
    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //TODO: aWord
    public static boolean aWord(String word) {
        if (word.length() == 5 && word.charAt(2) == 'a') {
            return true;
        } else {
            return false;
        }
    }


    //TODO: reverse
    public static boolean reverse(String word) {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        if (word.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args){
        Scanner answers = new Scanner(System.in);
        int score = 0;
        System.out.println("What year is a Leap Year?");
       if(isLeapYear(answers.nextInt())){
           System.out.println("Correct!");
           score++;
       }
       else{
           System.out.println("Incorrect");
       }

       System.out.println("What is a prime number between 100-300?");
       if(isPrime(answers.nextInt())){
           System.out.println("Correct!");
           score++;
       }
       else{
           System.out.println("Incorrect");
       }

       System.out.println("What is a five letter word with an 'a' in the middle?");
       if(aWord(answers.next())){
           System.out.println("Correct!");
           score++;
       }
       else{
           System.out.println("Incorrect");
       }

       System.out.println("What word is a palindrome?");
       if(reverse(answers.next())){
           System.out.println("Correct!");
           score++;
       }
       else{
           System.out.println("Incorrect");
       }

        if (score == 0){
            System.out.println("Oof, better luck next time");
        }
        else{
            System.out.println("Nice! You got " + score + " out of 4 right!");
        }
    }
}

