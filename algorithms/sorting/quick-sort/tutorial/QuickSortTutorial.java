import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Sort an array using quick sort.
 */
public class QuickSortTutorial {
    
	/**
	 * Test driver.
	 */
    public static void main(String args[] ) throws Exception {
        
        // Read input from system in.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
		int[] array = new int[n];
		for (int index = 0; index < n; index++) {
			array[index] = scanner.nextInt();
		}
		
		// Quick sort the array.
		quickSort(array, 0, n - 1);
		
		// Print result
		for (int element : array) {
			System.out.print(" " + element);
		}
    }
    
	/**
	 * Quick sort the array using randomized pivot.
	 * @param array input array to be sorted.
	 * @param start start index of the array
	 * @param end end index of the array
	 */
    private static void quickSort(int[] array, int start, int end) {

		if (start < end) {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot - 1);
			quickSort(array, pivot + 1, end);
		}

    }

	/**
	 * Partition with randomized pivot
	 * @param array input array to be sorted.
	 * @param start first index of the array.
	 * @param end upper end of the random generated value.
	 */
	private static int partition(int[] array, int start, int end) {
		// random pivot
		int pivot = ThreadLocalRandom.current().nextInt(start, end + 1);
		// left of index i are array elements that less than pivot.
		int i = start + 1;

		// Swap with first element.
		swap(array, start, pivot);

		for (int j = start + 1; j <= end; j++) {

			if (array[j] < array[start]) {
				swap(array, i++, j);
			}
		}

		// swap pivot to its right position.
		swap(array, i - 1, start);

		// return the pivot position.
		return i - 1;
	}

	/**
	 * Swap two array value a and b
	 * @param array input array.
	 * @param a first index to be swapped.
	 * @param b second index to be swapped.
	 */
	private static void swap(int array[], int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}