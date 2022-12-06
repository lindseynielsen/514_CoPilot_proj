package cs163_cs164;

/*
 * Method Details
nameIntroduction
public static String nameIntroduction(String playerName)
The return string is based on the player's name. Before working with the branching, make the entire playerName parameter upper-case using the .toUpperCase() method. This is to assist in branching when comparisons are made. For example: String upperCase = lowerCase.toUpperCase();
Implementation Hints:
Use the .equals() method to compare Strings. For example: if (upperCase.equals("JAMES")) { //do something }

If the first letter of the player's name is in the first half of the alphabet (Up to and including M) the message starts with: "Hi [playerName]".
If the first letter of the player's name is in the second half of the alphabet (N to Z) the message starts with: "Hello [playerName]".
Otherwise the message starts: "Hello [playerName]".
If the playerName is less than or equal to 5 characters long, the message ends: ", are you up to the challenge?".
If the playerName is greater than 5 characters long, the message ends: ", good luck!".
Otherwise the message ends: ", good luck!".
Note: to get the length of the String, call .length(). For example: int len = playerName.length();


Examples:

If input is "Sam", output is "Hello SAM, are you up to the challenge?".
If input is "fenris_wolf", output is "Hi FENRIS_WOLF, good luck!
If the playerName is less than or equal to 5 characters long, the message ends: ", are you up to the challenge?".
If the playerName is greater than 5 characters long, the message ends: ", good luck!".
Otherwise the message ends: ", good luck!".
Use the encrypted message and the key to decrypt the message and write it out to the file to check your work. Make sure to close your PrintWriter when you are done.
Parameters:
playerName - the player's name
Returns:
a string introduction
playGame

public static int playGame(int guess,
 int num)
Compares player's guess to the actual number.
Implementation Hints:

If the guess was correct (the guess and num are equal), return 0.
If the guess was too high (the guess is greater than num), return 1.
If the guess was incorrect, check if guess is less than num. 
If the guess was too low (the guess is less than num), return -1.

If so, print "Too low." followed by a new line and return -1.
If guess is higher than num, print "Too high." followed by a new line and return 1.

Examples:

If guess is 20 and num is 21, output is "Too low." and -1 is returned.

If guess is 50 and num is 18, output is "Too high." and 1 is returned.
If guess is 42 and num is 42, 0 is returned.
Parameters:
guess - the player's guess
num - the actual number
Returns:
an int, 0 if the guess is correct, -1 if too low, 1 if too high




numberInfo
public static String numberInfo(int number)
Returns a string with information about the number.
Depending on the value of the number, return one of the following statements:
If the number is less than 0, return "The number is negative.".
If the number is less than 10 but greater than 0, return "a single digit.".
If the number is 7 return "lucky sevens!".
If the number is 42, return "the answer to life the universe and everything.".

Otherwise return "a positive number.".
Examples:

Hint: Your `if` statements should go from most specific to least specific. If one answer falls under multiple categories, return the most specific one. For example if the number is 7, the method should return "lucky sevens!" not "a single digit.".
Parameters:
number - the number to look at
Returns:
string with the message that is listed above
 */

public class TwentyQuestions {

    public String nameIntroduction(String playerName){
        playerName = playerName.toUpperCase();
        String message = "";
        if(playerName.charAt(0) <= 'M'){
            message = "Hi " + playerName;
        }else if(playerName.charAt(0) > 'M'){
            message = "Hello " + playerName;
        }else{
            message = "Hello " + playerName;
        }
        if(playerName.length() <= 5){
            message += ", are you up to the challenge?";
        }else if(playerName.length() > 5){
            message += ", good luck!";
        }else{
            message += ", good luck!";
        }
        return message;
    }


    public int playGame(int guess, int num) {
        if(guess == num){
            return 0;
        }else if(guess > num){
            System.out.println("Too high.");
            return 1;
        }else if(guess < num){
            System.out.println("Too low.");
            return -1;
        }else{

        }
        return 0;
    }

    public String numberInfo(int number){
        if(number < 0){
            return "The number is negative.";
        }else if(number < 10 && number > 0){
            return "a single digit.";
        }else if(number == 7){
            return "lucky sevens!";
        }else if(number == 42){
            return "the answer to life the universe and everything.";
        }else{
            return "a positive number.";
        }
    }
}