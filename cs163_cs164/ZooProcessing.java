import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * Method Detail
processFile
public void processFile​(String fileName)
Reads a local CSV file, using the fileName parameter. For each line in the CSV file, a new organism is created and added to either the Flora or Fauna list. The creation and addition of organisms is handled by addOrganism();
Parameters:
fileName -
interact
public void interact()
After the ArrayLists have been populated, users can interact with the lists by displaying a random fact, or the current organism counts by type, or they can exit.
addOrganism
public void addOrganism​(String organismLine)
Add an organism object depending on what kind of organism it is. Do this by extracting information about the organism from the CSV file. Using a line that was read in from the CSV file, the values in-between the comma's in this line hold important information, such as whether the organism is a Flora/Fauna, the species, and category to name a few.
An example of a provided organismLine parameter:

      Fauna,Fish,Blind Cave Fish,Astyanax mexicanus,Central America,To compensate for their lack of sight, these fish have a more sensitive lateral line system to detect vibrations.
      Flora/Fauna,Category,Species,Scientific name,Continent of origin,A fun fact!
 
As you can see, each piece of information is seperated by a comma, so our commas will function as our delimiters! Once you have identified whether the organism is a flora or fauna then find the category that organism belongs to, such as if a listing is a flora, it must be an angiosperm, fern, gymnosperm, or moss. Depending on the category, use the corresponding class constructor to create that object and add it to the floraList or faunaList. The parameter you provide to the Angiosperm, Moss, Bird, Invertebrate will be the provided organismLine.
Parameters:
organismLine -
randFact
public void randFact()
Randomly selects the flora or fauna list, the selects a random entry and prints its species and fun fact!
listCounts
public void listCounts()
This function displays the counts for flora and fauna in the CSV file. The total number of each organism category is also displayed. So for each organism that belongs to a certain category or class, the number of angiosperms, fish, etc. is incremented for however many exist in each ArrayList. Each CSV file will contain a list of flora organisms you should iterate through as well as a list of fauna organisms you should iterate through.
If a CSV file contained 3 entries of Ferns and one of each Fauna, the output from this method would look like so:

      Flora Count: 3
      Angiosperm count: 0
      Fern count: 3
      Gymnosperm count: 0
      Moss count: 0

      Fauna Count: 6
      Amphibian count: 1
      Bird count: 1
      Fish count: 1
      Invertebrate count: 1
      Mammal count: 1
      Reptile count: 1
 
The additional information section may have some assistance if you find yourself stuck.
printSelections
public void printSelections()
This is just a helper method to display user options.
 */

public class ZooProcessing {
    ArrayList<Flora> floraList = new ArrayList<>();
    ArrayList<Fauna> faunaList = new ArrayList<>();

    public void processFile(String fileName) {
        try {            
            Scanner scnr = new Scanner(new File(fileName));
            while(scnr.hasNextLine()) {
                String organismLine = scnr.nextLine();
                
                addOrganism(organismLine);
            }

            scnr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void interact() {
        System.out.println("CSV File has been loaded, Flora and Fauna lists have been populated!");
        printSelections();
        Scanner scnr = new Scanner(System.in);

        String input = scnr.nextLine();
        while(!input.equalsIgnoreCase("X")) {
            if(input.equalsIgnoreCase("D")) {
                randFact();
            }
            else if(input.equalsIgnoreCase("L")) {
                listCounts();
            }
            else {
                System.out.println("Unrecognized command.");
            }

            printSelections();
            input = scnr.nextLine();
        }

        scnr.close();
    }

    /** Self-Explanation
     * 
     *
     * 
     * 
     * 
     */
    /*
     * public Angiosperm(String info) {
        ArrayList<String> splitInfo = new ArrayList<String>(Arrays.asList(info.split(",")));

        species = splitInfo.get(2);
        scientific = splitInfo.get(3);
        continent = splitInfo.get(4);
        fact = splitInfo.get(5);
    }
     */
    public void addOrganism(String organismLine) {
        String[] organismInfo = organismLine.split(",");
        String organismType = organismInfo[0];
        String organismCategory = organismInfo[1];
        String organismSpecies = organismInfo[2];
        String organismScientificName = organismInfo[3];
        String organismContinent = organismInfo[4];
        String organismFunFact = organismInfo[5];

        if(organismType.equalsIgnoreCase("Flora")) {
            if(organismCategory.equalsIgnoreCase("Angiosperm")) {
                floraList.add(new Angiosperm(organismLine));
            }
            else if(organismCategory.equalsIgnoreCase("Fern")) {
                floraList.add(new Fern(organismLine));
            }
            else if(organismCategory.equalsIgnoreCase("Gymnosperm")) {
                floraList.add(new Gymnosperm(organismLine));
            }
            else if(organismCategory.equalsIgnoreCase("Moss")) {
                floraList.add(new Moss(organismLine));
            }
        }
        else if(organismType.equalsIgnoreCase("Fauna")) {
            if(organismCategory.equalsIgnoreCase("Amphibian")) {
                faunaList.add(new Amphibian(organismLine));
            }
            else if(organismCategory.equalsIgnoreCase("Bird")) {
                faunaList.add(new Bird(organismLine));
            }
            else if(organismCategory.equalsIgnoreCase("Fish")) {
                faunaList.add(new Fish(organismLine));
            }
            else if(organismCategory.equalsIgnoreCase("Invertebrate")) {
                faunaList.add(new Invertebrate(organismLine));
            }
            else if(organismCategory.equalsIgnoreCase("Mammal")) {
                faunaList.add(new Mammal(organismLine));
            }
            else if(organismCategory.equalsIgnoreCase("Reptile")) {
                faunaList.add(new Reptile(organismLine));
            }
        }

        //TODO: Student
        //Add an organism object depending on what kind of organism it is. Do this by extracting information about the organism from the CSV file. Using a line that was read in from the CSV file, the values in-between the comma's in this line hold important information, such as whether the organism is a Flora/Fauna, the species, and category to name a few.
        //An example of a provided organismLine parameter:
        //  Fauna,Fish,Blind Cave Fish,Astyanax mexicanus,Central America,To compensate for their lack of sight, these fish have a more sensitive lateral line system to detect vibrations.
        //  Flora/Fauna,Category,Species,Scientific name,Continent of origin,A fun fact!

        //As you can see, each piece of information is seperated by a comma, so our commas will function as our delimiters! Once you have identified whether the organism is a flora or fauna then find the category that organism belongs to, such as if a listing is a flora, it must be an angiosperm, fern, gymnosperm, or moss. Depending on the category, use the corresponding class constructor to create that object and add it to the floraList or faunaList. The parameter you provide to the Angiosperm, Moss, Bird, Invertebrate will be the provided organismLine.
        //Parameters:
        //organismLine -


    }
    
    public void randFact() {
        Random rand = new Random();
        if(rand.nextInt(1) == 0) {
            Fauna randFauna = faunaList.get(rand.nextInt(faunaList.size()-1));
            System.out.println(randFauna.species + " fact: " + randFauna.fact);
        }
        else {
            Flora randFlora = floraList.get(rand.nextInt(floraList.size()-1));
            System.out.println(randFlora.species + " fact: " + randFlora.fact);
        }
    }
    
    /** Self-Explanation
     * 
     * 
     * Print:
        Flora Count: 9
        Angiosperm count: 3
        Fern count: 3
        Gymnosperm count: 1
        Moss count: 2

        Fauna Count: 8
        Amphibian count: 2
        Bird count: 2
        Fish count: 1
        Invertebrate count: 1
        Mammal count: 1
        Reptile count: 1
     */
    public void listCounts() {
        int angiospermCount = 0;
        int fernCount = 0;
        int gymnospermCount = 0;
        int mossCount = 0;
        int amphibianCount = 0;
        int birdCount = 0;
        int fishCount = 0;
        int invertebrateCount = 0;
        int mammalCount = 0;
        int reptileCount = 0;

        for(Flora flora : floraList) {
            if(flora instanceof Angiosperm) {
                angiospermCount++;
            }
            else if(flora instanceof Fern) {
                fernCount++;
            }
            else if(flora instanceof Gymnosperm) {
                gymnospermCount++;
            }
            else if(flora instanceof Moss) {
                mossCount++;
            }
        }

        for(Fauna fauna : faunaList) {
            if(fauna instanceof Amphibian) {
                amphibianCount++;
            }
            else if(fauna instanceof Bird) {
                birdCount++;
            }
            else if(fauna instanceof Fish) {
                fishCount++;
            }
            else if(fauna instanceof Invertebrate) {
                invertebrateCount++;
            }
            else if(fauna instanceof Mammal) {
                mammalCount++;
            }
            else if(fauna instanceof Reptile) {
                reptileCount++;
            }
        }

        System.out.println("Flora Count: " + floraList.size());
        System.out.println("Angiosperm count: " + angiospermCount);
        System.out.println("Fern count: " + fernCount);
        System.out.println("Gymnosperm count: " + gymnospermCount);
        System.out.println("Moss count: " + mossCount);

        System.out.println();

        System.out.println("Fauna Count: " + faunaList.size());
        System.out.println("Amphibian count: " + amphibianCount);
        System.out.println("Bird count: " + birdCount);
        System.out.println("Fish count: " + fishCount);
        System.out.println("Invertebrate count: " + invertebrateCount);
        System.out.println("Mammal count: " + mammalCount);
        System.out.println("Reptile count: " + reptileCount);
        //TODO: Student
    }
    
    public void printSelections() {
        System.out.println("What would you like to do?");
        System.out.println("[D]isplay a random fact?");
        System.out.println("[L]ist current organism type counts?");
        System.out.println("[X] to exit out of the Zoo DB?");
    }
}