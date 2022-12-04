package CS150;
import java.util.Scanner;

public class ColorBlindness {
   // if true, works for this color blindness
    private static boolean protanopia = true;
    private static boolean deuteranopia = true;
    private static boolean tritanopia = true;
   
   // Write getRed() here
   // This method takes in a six-digit hex string representing a color and returns the red component as an int
    // Extract the red component
    public static int getRed(String hex) {
        String sub = hex.substring(0, 2);
        return Integer.parseInt(sub, 16);
    }
   
   // Write getGreen() here
   // This method takes in a six-digit hex string representing a color and returns the green component as an int

    // Extract the green component
    public static int getGreen(String hex) {
        String sub = hex.substring(2, 4);
        return Integer.parseInt(sub, 16);
    }
   
   
   // Write getBlue() here
   // This method takes in a six-digit hex string representing a color and returns the blue component as an int
    // Extract the blue component
    public static int getBlue(String hex) {
        String sub = hex.substring(4, 6);
        return Integer.parseInt(sub, 16);
    }
   
   
   // Write idDeuteranopia() here
   // Takes in a six-digit hex string representing a color and returns true if the color as acceptable for deuteranopia
    // If the color is not acceptable, return false
    public static boolean idDeuteranopia(String hex) {
        int red = getRed(hex);
        int green = getGreen(hex);
        int blue = getBlue(hex);
        if (red > 255 || green > 255 || blue > 255) {
            return false;
        }
        if (red < 0 || green < 0 || blue < 0) {
            return false;
        }
        if (red > 0 && green > 0 && blue > 0) {
            return true;
        }
        return false;
    }
   
   
   // Write idProtanopia() here
   // Takes in a six-digit hex string representing a color and returns true if the color as acceptable for protanopia
    // If the color is not acceptable, return false
    public static boolean idProtanopia(String hex) {
        int red = getRed(hex);
        int green = getGreen(hex);
        int blue = getBlue(hex);
        if (red > 255 || green > 255 || blue > 255) {
            return false;
        }
        if (red < 0 || green < 0 || blue < 0) {
            return false;
        }
        if (red > 0 && green > 0 && blue > 0) {
            return true;
        }
        return false;
    }
   
   
   // Write idTritanopia() here
   // Takes in a six-digit hex string representing a color and returns true if the color as acceptable for tritanopia
    // If the color is not acceptable, return false
    public static boolean idTritanopia(String hex) {
        int red = getRed(hex);
        int green = getGreen(hex);
        int blue = getBlue(hex);
        if (red > 255 || green > 255 || blue > 255) {
            return false;
        }
        if (red < 0 || green < 0 || blue < 0) {
            return false;
        }
        if (red > 0 && green > 0 && blue > 0) {
            return true;
        }
        return false;
    }
   
   
   // Write identifyPalette() here
   // This method takes in a single string representing a series of colors separated by spaces
   // You will iterate through each of these colors, and set our class variables (the booleans above)
   // to false if the color does not work for that type of colorblindness
    public static void identifyPalette(String palette) {
        String[] colors = palette.split(" ");
        for (int i = 0; i < colors.length; i++) {
            if (!idDeuteranopia(colors[i])) {
                deuteranopia = false;
            }
            if (!idProtanopia(colors[i])) {
                protanopia = false;
            }
            if (!idTritanopia(colors[i])) {
                tritanopia = false;
            }
        }
    }
   
   
   // Prints results of this color palette based upon the three class variables
   public static void printResults(){
        String res = "This palette ";
        if(protanopia && deuteranopia && tritanopia){
            res += "works for all types of color blindness.";
        }
        else{
            res += "does not work for ";

            if (!protanopia){
                res += "protanopia ";
            }

            if (!deuteranopia){
                res += "deuteranopia ";
            }

            if (!tritanopia){
                res += "tritanopia";
            }
        }
        System.out.println(res);
   }
 
  public static void runTests() {


     // add your own tests here.. For example, getRed("FFFFFF"); // should return 255  
     
  }
 
  public static void main(String[] args) {
        runTests();  // comment out this line BEFORE submitting for grading!
     
        Scanner input = new Scanner(System.in);
        String palette = input.nextLine();
        //identifyPalette(palette);
        printResults();
    }
}