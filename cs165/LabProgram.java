package cs165;
import java.util.Arrays;
/*
Write the removeEvens() method, which receives an array of integers as a parameter and returns a new array of integers containing only the odd numbers from the original array. The main program outputs values of the returned array.

Hint: If the original array has even numbers, then the new array will be smaller in length than the original array and should have no blank elements.

Ex: If the array passed to the removeEvens() method is [1, 2, 3, 4, 5, 6, 7, 8, 9], then the method returns and the program output is:

[1, 3, 5, 7, 9]
Ex: If the array passed to the removeEvens() method is [1, 9, 3], then the method returns and the program output is:

[1, 9, 3]
*/

public class LabProgram {

	public static int[] removeEvens(int [] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 != 0) {
				count++;
			}
		}
		int [] odds = new int[count];
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 != 0) {
				odds[j] = nums[i];
				j++;
			}
		}
		return odds;
	}

	public static void main(String[] args) {

		int [] input = {1,2,3,4,5,6,7,8,9};
		int [] result = removeEvens(input);

		// Helper method Arrays.toString() converts int[] to a String
		System.out.println(Arrays.toString(result)); // Should print [1, 3, 5, 7, 9]
	}
}
