import java.util.*;

class InsertionSortTutorial {
    
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
		
		// Find position i of temp[i] in the sorted array.
		for (int tIndex = 0; tIndex < n; tIndex++) {
			for (int aIndex = 0; aIndex < n; aIndex++) {
				if (temp[tIndex] == array[aIndex]) {
					temp[tIndex] = aIndex + 1;
				}
			}
		}

		// Print result
		for (int item : temp) {
			System.out.print(" " + item);
		}
    }
    
    private static void insertionSort(int[] array, int n) {
    	
    	for (int index = 1; index < n; index++) {
    		int temp = array[index];
    		int j = index;
    		
    		while (j > 0 && temp < array[j - 1]) {
    			array[j] = array[j - 1];
    			j -= 1;
    		}
    		array[j] = temp;
    	}
    }
}
