import java.util.*;

/**
 * Given an array A. Count number of ordered pairs (i, j) such that i < j and A[i] > A[j]
 */
public class MergeSortTutorial {
    
    public static void main(String args[] ) throws Exception {
        
        // Read input from system in.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
		int[] array = new int[n];
		for (int index = 0; index < n; index++) {
			array[index] = scanner.nextInt();
		}
		
		// Count number of array inversions.
		long nums = mergeSort(array, 0, n - 1);
		
		// Print result
		System.out.print(nums);
    }
    
	/**
	 * Merge sort and count # of array inversions.
	 */
    private static long mergeSort(int[] array, int start, int end) {
		long result = 0;
		if (start < end) {
			int mid = (start + end) / 2;
			// Count on the left sub-array.
			result = mergeSort(array, start, mid);
			result += mergeSort(array, mid + 1, end);

			result += merge(array, start, mid, end);
		}

		return result;
    }

	/**
	 * Merge the two sorted sub-arrays into a sorted array.
	 */
	private static long merge(int[] array, int start, int mid, int end) {
		// count number of inversions.
		long count = 0;
		// Store the start index of left sub-array
		int i = start;
		// Store the start index of right sub-array.
		int j = mid + 1;
		// Index to keep track the item after sorted.
		int k = 0;

		int temp[] = new int[end - start + 1];

		for (int index = start; index <= end; index++) {

			// if end of left sub-array
			if (i > mid) {
				temp[k++] = array[j++];
			} else if (j > end)	{// end of right sub-array
				temp[k++] = array[i++];
			} else if (array[i] > array[j]) { // left item > right item.
				// Count number of inversions.
				// Since array[i] > array[j], so do array[i + 1], array[i + 2], ... , array[mid],
				// number of array inversions are (mid - i + 1).
				count += (mid - i + 1);
				temp[k++] = array[j++];
			} else {
				temp[k++] = array[i++];
			}
		}

		// Copy the temp array back to the original array.
		for (int index = 0; index < k; index++) {
			array[start++] = temp[index];
		}

		return count;
	}
}