import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Monk has a matrix of size N × M, and he wants to pick one element from each row to make a new array A of size N. 
 * He wants to find the minimum possible value of absolute difference between any two adjacent elements in the array A. 
 * Please note that the element picked from row 1, will become A[1], element picked from row 2 will become A[2], and so on.
 * 
 * Input: 
 * First line consists of two space separated integers denoting N and M.
 * Each of the following N lines consists of M space separated integers denoting the matrix mat.
 * 
 * Output:
 * Print the required answer in a new line.
 * 
 * Constraints:
 * 2≤ N,M ≤1000
 * 1≤ mat[i][j] ≤ 10^9
 */
public class MonkAndNewArray {
    public static void main(String[] args) throws Throwable {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("MonkAndNewArray.txt"));
        String line = bufferedReader.readLine();
        int[] firstLine = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = firstLine[0];
        int m = firstLine[1];
        
        int[][] mat = new int[n][m];
        int[] a = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            mat[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(mat[i]);
        }

        // TODO.
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                int temp = mat[row][col];

            }
        }
    }

    /**
     * Find the minimum absolute different between temp and an element in the sorted array.
     */
    private static int findMinAbsDiff(int temp, int[] array, int n) {
        int mid = array[n/2];
        int result = Math.abs(temp - mid);
    }
}