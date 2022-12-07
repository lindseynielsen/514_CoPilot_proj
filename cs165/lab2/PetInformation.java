package cs165.lab2;

import java.util.Scanner;
/*
The base class Pet has private fields petName, and petAge. The derived class Dog extends the Pet class and includes a private field for dogBreed. Complete main() to:
1. Create a Scanner object to read from the keyboard.
2. Prompt the user to enter the pet name, pet age, and dog breed.
3. Create a Dog object and initialize it with the user input.
4. Display the pet name, pet age, and dog breed.


create a generic pet and print information using printInfo().
create a Dog pet, use printInfo() to print information, and add a statement to print the dog's breed using the getBreed() method.
Ex. If the input is:

Dobby
2
Kreacher
3
German Schnauzer
the output is:

Pet Information: 
   Name: Dobby
   Age: 2
Pet Information: 
   Name: Kreacher
   Age: 3
   Breed: German Schnauzer

 */


public class PetInformation {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Pet myPet = new Pet();
      Dog myDog = new Dog();
      
      String petName, dogName, dogBreed;
      int petAge, dogAge;

      petName = scnr.nextLine();
      petAge = scnr.nextInt();
      scnr.nextLine();
      dogName = scnr.next();
      dogAge = scnr.nextInt();
      scnr.nextLine();
      dogBreed = scnr.nextLine();
      
      // TODO: Create generic pet (using petName, petAge) and then call printInfo   
      myPet.setName(petName);
      myPet.setAge(petAge);
      myPet.printInfo();

      // TODO: Create dog pet (using dogName, dogAge, dogBreed) and then call printInfo
      myDog.setName(dogName);
      myDog.setAge(dogAge);
      myDog.setBreed(dogBreed);
      myDog.printInfo();
      
      // TODO: Use getBreed(), to output the breed of the dog
      System.out.println("   Breed: " + myDog.getBreed());
   }
}