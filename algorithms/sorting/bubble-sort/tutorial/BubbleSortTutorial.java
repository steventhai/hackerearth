import java.util.*;

/**
 * Count the number of swaps to sort an array in non-decreasing order using bubble sort.
 */
public class BubbleSortTutorial {
    
    public static void main(String args[] ) throws Exception {
        
        // Read input from system in.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
		int[] array = new int[n];
		for (int index = 0; index < n; index++) {
			array[index] = scanner.nextInt();
		}
		
		// Sort array using bubble sort.
		int swaps = bubbleSort(array, n);
		
		// Print result
		System.out.print(swaps);
    }
    
	/**
	 * Count # of swaps in bubble sort
	 */
    private static int bubbleSort(int[] array, int n) {
		int temp;
		int result = 0; 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					result++;
				}
			}
		}
		return result;
    }
}