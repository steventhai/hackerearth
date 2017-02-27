import java.util.*;

/**
 * Find the position that array[i] should be present in, if the array was a sorted array using binary search <br>
 * to search for the final position to swap current element in.
 */
public class BinaryInsertionSortTutorial {
    
    public static void main(String args[] ) throws Exception {
        
        // Read input from system in.
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
		int[] array = new int[n];
		int[] temp = new int[n];
		for (int index = 0; index < n; index++) {
			array[index] = s.nextInt();
			temp[index] = array[index];
		}
		
		// Sort array using insertion sort.
		insertionSort(array, n);
		
		// Print result
		for (int index = 0; index < n; index++) {
			System.out.print(" " + (binarySearch(array, temp[index], 0, n - 1) + 1));
		}
    }
    
	/**
	 * Insertion sort using binary search.
	 */
    private static void insertionSort(int[] array, int n) {
    	
    	for (int index = 1; index < n; index++) {
    		int temp = array[index];
    		int j = index;

			int finalPosition = binarySearch(array, temp, 0, j - 1);

    		while (j > finalPosition) {
    			array[j] = array[j - 1];
    			j -= 1;
    		}
    		array[j] = temp;
    	}
    }

	/**
	 * Binary search
	 */
	private static int binarySearch(int[] array, int item, int left, int right) {
		if (left >= right) {
			return item > array[left] ? left + 1 : left;
		}

		int mid = (left + right) / 2;
		
		if (item > array[mid]) {
			return binarySearch(array, item, mid + 1, right);
		} else if (item < array[mid]) {
			return binarySearch(array, item, left, mid - 1);
		} else {
			return mid;
		}
	}
}
