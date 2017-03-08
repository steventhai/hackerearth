import java.util.*;

/**
 * Array elements are ranged from 1 to 10^5. Find frequency of each distinct
 * element of the array. Output in ascending order the value with frequency
 * of each distinct element.
 */
public class CountingSortTutorial {
    
	/**
	 * Test driver.
	 */
    public static void main(String args[] ) {
        
        // Read input from system in.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
		int[] array = new int[n];
		for (int index = 0; index < n; index++) {
			array[index] = scanner.nextInt();
		}
		
		// Counting sort
		countingSort(array, n);
    }
    
	/**
	 * Counting sort the array.
	 * @param array input array.
	 * @param size input array size.
	 */
	private static void countingSort(int[] array, int size) {
		int max = 0;

		// Find max element of the array.
		for (int element : array) {
			if (element > max) {
				max = element;
			}
		}

		// Instantiate the auxiliary array.
		int aux[] = new int[max + 1];

		// Count each distinct element of array and store each of them in
		// auxiliary array.
		for (int index = 0; index < size; index++) {
			aux[array[index]]++;
		}

		// Traverse the auxiliary array and print the result.
		for (int index = 0; index <= max; index++) {
			if (aux[index] != 0) {
				System.out.println(index + " " + aux[index]);
			}
		}
	}
}