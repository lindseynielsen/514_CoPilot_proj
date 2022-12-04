package CS150;
import java.util.Random;
import java.util.Scanner;
/*
 Step 1 - Reading the code
First take a look at the provided code. You should change the comments to include your name at the top of the file. Furthermore, you will notice all the functions are ‘stubbed’ out for you. This means we have provided the function signature, and a dummy return value that you will replace completely.

We have also provided one function in its entirety, so you can use it as a sample/template to look at.

def get_positive_answer(answer):
    ans = "You may rely on it." 
    if answer == 0:
        ans = "As I see it, yes."
    elif answer == 1:
        ans = "Signs point to yes."
    elif answer == 2:
        ans ="Outlook good."
    elif answer == 3:
        ans = "Without a doubt."
    return ans
There are also some lines under that method commented out. You should uncomment them and see what happens. In all languages it is good to test frequently, and often, and this is exactly what we are doing here. We have provided sample tests throughout the code that you should feel free to use, and add others.

This program requires input, so in the Enter program input (optional) box enter the word yes or no. For now, we suggest just putting no (or n) in the box, until you have completed the lab.

Step 2 - get_negative_answer(answer)
We completed get_positive_answer, but you need to complete get_negative_answer. Right now, it is stubbed out with

def get_negative_answer(answer):
    ans = ""
    return ans
You will have five options that can be assigned to ans, using if/elif statements. You can follow the model above provided in get_positive_answer, or come up with your own. In either case, the following options need to be returned based on the ‘number’ of answer. Make sure to match spacing and punctuation exactly!

0 - Don’t count on it.
1 - My reply is no.
2 - My sources say no.
3 - Outlook not so good.
4 (or higher) - Very doubtful.
Step 3 - get_no_answer(answer)
Similar to Step 2, build the if-statement for get_no_answer(answer) using the options below.

0 - Reply hazy, try again.
1 - Ask again later.
2 - Better not tell you now.
3 - Cannot predict now.
4 (or higher) - Concentrate and ask again.
Step 4 - get_answer(category, answer)
You have worked on three functions (two really) that take in a single parameter to return an answer. Each of those functions are specific to a category. This function determines which of the three functions to call.

If the category is less than 24, call and store the returned value of get_negative_answer(answer) passing in answer as the parameter.
If the category is between 24 and 73 (including 73), call and store the returned value of get_no_answer(answer) passing in answer as the parameter.
If the category is greater than or equal to 74, call and store the returned value of get_positive_answer(answer) passing in answer as the parameter.
You will then return the answer provided. (there may be different orders you can make the checks in)

For a quick refresher on how to call functions within if statements, here is some sample code (not related to this assignment).

def a_func_with_if(val1, val2):
    ans = None
    if val1 < 0:
        ans = out_of_range(val2)
    elif val1 > 100:
        ans = out_of_range(val2)
    else
        ans = "In Range!" 
    return ans

def out_of_range(val2):
    return "Not really doing anything with {}".format(val2)
If you need a refresher about comparison operators used in if statements click here
While you can run the program with random to test, you may find this difficult. Looking back at the other programs the past couple weeks, how can you incrementally test to make sure your method is working?
 */

/**
 * 
 * Basic magic 8 ball, with an equal number of options in each category. Teaches 
 * basic if / else statements.
 * 
 * 
 * @author YOUR NAME
 *         YOUR EMAIL
 *         Computer Science Department
 *         Colorado State University
 * @version 201990
 */
public class Lab4 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd = new Random();   
    // STUDENT CODE HERE
    // You will need to add the following methods:
    // get_positive_answer(answer)
    // get_negative_answer(answer)
    // get_no_answer(answer)
    // get_answer(category, answer)
    // You will also need to add the following variables:
    // answer
    // category
    // You will need to add the following lines of code:
    // answer = rnd.nextInt(5);
    // category = rnd.nextInt(100);
    // You will need to add the following lines of code:
    // System.out.println("Enter program input (optional): ");
    // String input = scanner.nextLine();
    // You will need to add the following lines of code:
    // System.out.println("Magic 8 Ball says: " + get_answer(category, answer));
    // You will need to add the following lines of code:
    // System.out.println("Magic 8 Ball says: " + get_answer(category, answer));
    // System.out.println("Magic 8 Ball says: " + get_answer(category, answer));
    // System.out.println("Magic 8 Ball says: " + get_answer(category, answer));
    // System.out.println("Magic 8 Ball says: " + get_answer(category, answer));
    // System.out.println("Magic 8 Ball says: " + get_answer(category, answer));
    // System.out.println("Magic 8 Ball says: " + get_answer(category, answer));
    // System.out.println("Magic 8 Ball says: " + get_answer(category, answer));
    // System.out.println("Magic 8 Ball says: " + get_answer(category, answer));
    // System.out.println("Magic 8 Ball says: " + get_answer(category, answer))

    /**
     * @param args the command line arguments
     */

    

    
     
    
    // Step 2 - get_negative_answer(answer)
    // We completed get_positive_answer, but you need to complete get_negative_answer. Right now, it is stubbed out with
    // def get_negative_answer(answer):
    //     ans = ""
    //     return ans
    // You will have five options that can be assigned to ans, using if/elif statements. You can follow the model above provided in get_positive_answer, or come up with your own. In either case, the following options need to be returned based on the ‘number’ of answer. Make sure to match spacing and punctuation exactly!
    // 0 - Don’t count on it.
    // 1 - My reply is no.
    // 2 - My sources say no.
    // 3 - Outlook not so good.
    // 4 (or higher) - Very doubtful.

    public static String get_negative_answer(int answer) {
        String ans = "";
        if (answer == 0) {
            ans = "Don't count on it.";
        } else if (answer == 1) {
            ans = "My reply is no.";
        } else if (answer == 2) {
            ans = "My sources say no.";
        } else if (answer == 3) {
            ans = "Outlook not so good.";
        } else {
            ans = "Very doubtful.";
        }
        return ans;
    }




    // Step 3 - get_no_answer(answer)

    // Similar to Step 2, build the if-statement for get_no_answer(answer) using the options below.
    // 0 - Reply hazy, try again.
    // 1 - Ask again later.
    // 2 - Better not tell you now.
    // 3 - Cannot predict now.
    // 4 (or higher) - Concentrate and ask again.

    public static String get_no_answer(int answer) {
        String ans = "";
        if (answer == 0) {
            ans = "Reply hazy, try again.";
        } else if (answer == 1) {
            ans = "Ask again later.";
        } else if (answer == 2) {
            ans = "Better not tell you now.";
        } else if (answer == 3) {
            ans = "Cannot predict now.";
        } else {
            ans = "Concentrate and ask again.";
        }
        return ans;
    }




    // Step 4 - get_answer(category, answer)

    // You have worked on three functions (two really) that take in a single parameter to return an answer. Each of those functions are specific to a category. This function determines which of the three functions to call.
    // If the category is less than 24, call and store the returned value of get_negative_answer(answer) passing in answer as the parameter.
    // If the category is between 24 and 73 (including 73), call and store the returned value of get_no_answer(answer) passing in answer as the parameter.
    // If the category is greater than or equal to 74, call and store the returned value of get_positive_answer(answer) passing in answer as the parameter.
    // You will then return the answer provided. (there may be different orders you can make the checks in)

    private static String getAnswer(int category, int answer) {
        String ans = "";
        if (category < 24) {
            ans = get_negative_answer(answer);
        } else if (category >= 24 && category <= 73) {
            ans = get_no_answer(answer);
        } else {
            ans = get_positive_answer(answer);
        }
        // if statements here
        return ans;
    }


    // Step 5 - get_positive_answer(answer)

    // We completed get_positive_answer, but you need to complete get_negative_answer. Right now, it is stubbed out with
    // def get_positive_answer(answer):
    //     ans = ""
    //     return ans
    // You will have five options that can be assigned to ans, using if/elif statements. You can follow the model above provided in get_positive_answer, or come up with your own. In either case, the following options need to be returned based on the ‘number’ of answer. Make sure to match spacing and punctuation exactly!
    // 0 - It is certain.
    // 1 - It is decidedly so.
    // 2 - Without a doubt.
    // 3 - Yes – definitely.
    // 4 (or higher) - You may rely on it.
    
    public static String get_positive_answer(int answer) {
        String ans = "";
        if (answer == 0) {
            ans = "It is certain.";
        } else if (answer == 1) {
            ans = "It is decidedly so.";
        } else if (answer == 2) {
            ans = "Without a doubt.";
        } else if (answer == 3) {
            ans = "Yes - definitely.";
        } else {
            ans = "You may rely on it.";
        }
        return ans;
    }

    // Step 6 - get_category(question)

    // This function takes in a question and returns a category. The category is a number between 0 and 100. The category is determined by the number of characters in the question. If the question is less than 10 characters, the category is 0. If the question is between 10 and 20 characters, the category is 1. If the question is between 21 and 30 characters, the category is 2. If the question is between 31 and 40 characters, the category is 3. If the question is between 41 and 50 characters, the category is 4. If the question is between 51 and 60 characters, the category is 5. If the question is between 61 and 70 characters, the category is 6. If the question is between 71 and 80 characters, the category is 7. If the question is between 81 and 90 characters, the category is 8. If the question is between 91 and 100 characters, the category is 9. If the question is greater than 100 characters, the category is 10.
    // You will need to use if/elif statements to determine the category. You can use the following model:
    // if (question.length() < 10) {
    //     category = 0;
    // } else if (question.length() >= 10 && question.length() <= 20) {
    //     category = 1;
    // } else if (question.length() >= 21 && question.length() <= 30) {
    //     category = 2;
    // } else if (question.length() >= 31 && question.length() <= 40) {
    //     category = 3;
    // } else if (question.length() >= 41 && question.length() <= 50) {
    //     category = 4;
    // } else if (question.length() >= 51 && question.length() <= 60) {
    //     category = 5;
    // } else if (question.length() >= 61 && question.length() <= 70) {
    //     category = 6;
    // } else if (question.length() >= 71 && question.length() <= 80) {
    //     category = 7;
    // } else if (question.length() >= 81 && question.length() <= 90) {
    //     category = 8;
    // } else if (question.length() >= 91 && question.length() <= 100) {
    //     category = 9;
    // } else {
    //     category = 10;
    // }
    // You will need to return the category.
        
    public static int get_category(String question) {
        int category = 0;
        if (question.length() < 10) {
            category = 0;
        } else if (question.length() >= 10 && question.length() <= 20) {
            category = 1;
        } else if (question.length() >= 21 && question.length() <= 30) {
            category = 2;
        } else if (question.length() >= 31 && question.length() <= 40) {
            category = 3;
        } else if (question.length() >= 41 && question.length() <= 50) {
            category = 4;
        } else if (question.length() >= 51 && question.length() <= 60) {
            category = 5;
        } else if (question.length() >= 61 && question.length() <= 70) {
            category = 6;
        } else if (question.length() >= 71 && question.length() <= 80) {
            category = 7;
        } else if (question.length() >= 81 && question.length() <= 90) {
            category = 8;
        } else if (question.length() >= 91 && question.length() <= 100) {
            category = 9;
        } else {
            category = 10;
        }
        return category;
    }

    // Step 7 - get_answer(category, answer)

    // You have worked on three functions (two really) that take in a single parameter to return an answer. Each of those functions are specific to a category. This function determines which of the three functions to call.
    // If the category is less than 24, call and store the returned value of get_negative_answer(answer) passing in answer as the parameter.
    // If the category is between 24 and 73 (including 73), call and store the returned value of get_no_answer(answer) passing in answer as the parameter.
    // If the category is greater than or equal to 74, call and store the returned value of get_positive_answer(answer) passing in answer as the parameter.
    // You will then return the answer provided. (there may be different orders you can make the checks in)

    public static String get_answer(int category, int answer) {
        String ans = "";
        if (category < 24) {
            ans = get_negative_answer(answer);
        } else if (category >= 24 && category <= 73) {
            ans = get_no_answer(answer);
        } else {
            ans = get_positive_answer(answer);
        }
        return ans;
    }

    // Step 8 - get_negative_answer(answer)

    // We completed get_positive_answer, but you need to complete get_negative_answer. Right now, it is stubbed out with
    // def get_positive_answer(answer):
    //     ans = ""
    //     return ans





    

// ************** don't modify below this line ************************
    public static void main(String[] args) {
        printSpash();
        run();
    }

    public  static void printSpash() {
        System.out.println("88888888888888888888");
        System.out.println("8   Magic 8 Ball   8");
        System.out.println("8    Ask away      8");
        System.out.println("88888888888888888888");
        System.out.println("\nAnd the answer is...\n");
    }

    public static void run() {
        int cat = rnd.nextInt(100);
        int an = rnd.nextInt(5);
        System.out.println("category num: " + cat + " answer num: " + an);
        System.out.println(getAnswer(cat, an)); // gets 0-99 and 0-4 (one less than what you put in)
        System.out.println();
        System.out.print("Ask another question (Yes/No?): ");
        String input = scanner.nextLine();
        if(input.toLowerCase().startsWith("n"))  { // this ia fun trick, worth remembering it.
            System.out.println("Thank you for playing!");
            return;
        }
        System.out.println("\nAnd the answer is...\n");
        run(); // continue looping!
    }

}

