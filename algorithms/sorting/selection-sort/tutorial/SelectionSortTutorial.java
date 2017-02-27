import java.util.*;

/**
 * Using selection sort, print the state of the array after a given 'x' interation.
 */
public class SelectionSortTutorial {
    
    public static void main(String args[] ) throws Exception {
        
        // Read input from system in.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
		int x = scanner.nextInt();
		int[] array = new int[n];
		for (int index = 0; index < n; index++) {
			array[index] = scanner.nextInt();
		}
		
		// Sort array using selection sort.
		selectionSort(array, n, x);
		
		// Print result

    }
    
	/**
	 * Print the array after x iterations.
	 */
    private static void selectionSort(int[] array, int n, int x) {
		int min;		
		int temp;
		for (int i = 0; i < n - 1; i++) {
			
			min = i;
			
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[min])	{
					min = j;
				}
			}
			
			temp = array[min];
			array[min] = array[i];
			array[i] = temp;

			if (i == x - 1) {
				for (int element : array) {
					System.out.print(" " + element);
				}
				break;
			}
		}
    }
}