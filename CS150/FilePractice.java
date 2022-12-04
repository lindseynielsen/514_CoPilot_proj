package CS150;

/*
 * Step 1 - Declare Class Variables

At the top of your class you should declare the following variables of type int:

harryPotterCounter;
aCounter;
eCounter
iCounter;
oCounter;
uCounter;
totalVowels
consonantCounter
Notice that there is an instance of the FileReader class called reader that is declared at the top of the class. You will use this in order to call the methods from the FileReader class in the next step.

Step 2 - Writing readFile
This method uses the methods in the FileReader class to read the file line by line and passing each line to a separate method that will parse through the line.

First you need to write the method signature. The method is called readFile and is a public void method with one parameter that is a String that represents the name of a file.

Inside the method you need to call the beginScanning method from the FileReader class and pass it the variable from the parameter. In order to call a method from the FileReader class you need to do something like the following:

reader.beginScanning(fileName)
Next you need to write a while loop. The loop should continue to run while there are more lines to read which can be done using the hasMoreLines method in the FileReader class. Inside the while loop you will call determineFileLineStats (which is the next method you need to write). determineFileLineStats takes a parameter of type String. You will want to pass the file line using getNextLine from the FileReader class.

Step 3 - Writing determineFileLineStats
This method will parse through the line and count the number of vowels and consonants. It will also count the number of times the word Harry Potter appears.

This method is the core of your program where you will determine several stats.

First you need to write the method signature. The method is called determineFileLineStats and is public void method that has one parameter of type String that represents a line from the file.

Inside the method you will first write an if statement to see if the String from the parameter contains “Harry Potter”. If it does increment harryPotterCounter.

Next you want to write a for loop that starts at 0 and goes to the length of the String. Inside the loop you want to write an if statement that checks to see if the current character is a letter and if it is then you want to create a switch statement on the current character. You want to check to see if the character is the lowercase or uppercase version of each vowel and increment the corresponding counter. For the default case you want to increment the consonantCounter.

Outside of the for loop add up all of the vowel counters and assign the value to totalVowels.

Step 4 - Writing displayFileLineStats
This method display the the numbers that you previously calculated using String.format.

First you need to write the method signature. The method is called displayFileLineStats and is a public method that returns a String and does not have any parameters.

Using String.format and %d you need to return a String that says:

Harry Potter is said num times. There are num vowels and num consonants
The word num should be replaced with the correct class constant.
 */

public class FilePractice {
   
    public FileReader reader = new FileReader();
    
      public int harryPotterCounter;
      public int aCounter;
      public int eCounter;
      public int iCounter;
      public int oCounter;
      public int uCounter;
      public int totalVowels;
      public int consonantCounter;

      //TODO: readFile
      public void readFile(String fileName) {
         reader.beginScanning(fileName);
         while (reader.hasMoreLines()) {
               determineFileLineStats(reader.getNextLine());
         }
      }
   
   //TODO: determineFileLineStats
   //This method will parse through the line and count the number of vowels and consonants. It will also count the number of times the word Harry Potter appears.
   public void determineFileLineStats(String line) {
      if (line.contains("Harry Potter")) {
         harryPotterCounter++;
      }
      for (int i = 0; i < line.length(); i++) {
         if (Character.isLetter(line.charAt(i))) {
            switch (line.charAt(i)) {
               case 'a':
               case 'A':
                  aCounter++;
                  break;
               case 'e':
               case 'E':
                  eCounter++;
                  break;
               case 'i':
               case 'I':
                  iCounter++;
                  break;
               case 'o':
               case 'O':
                  oCounter++;
                  break;
               case 'u':
               case 'U':
                  uCounter++;
                  break;
               default:
                  consonantCounter++;
                  break;
            }
         }
      }
      totalVowels = aCounter + eCounter + iCounter + oCounter + uCounter;
   }



   //TODO: displayFileLineStats
   //This method display the the numbers that you previously calculated using String.format.
   public String displayFileLineStats() {
      return String.format("Harry Potter is said %d times. There are %d vowels and %d consonants", harryPotterCounter, totalVowels, consonantCounter);
   }

   
   
   public static void main(String[] args) {
      FilePractice test = new FilePractice();
      test.readFile("harryPotter.txt");
      System.out.println(test.displayFileLineStats());
   }
}

