import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Problem description:
 * https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/monk-and-operations/
 */
public class MonkAndOperations {
    public static void main(String[] args) throws Throwable {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("MonkAndOperations.txt"));
        String line = bufferedReader.readLine();
        int[] firstLine = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = firstLine[0];
        int m = firstLine[1];
        
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            a[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        int[] lastLine = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int v1 = lastLine[0];
        int v2 = lastLine[1];
        int v3 = lastLine[2];
        int v4 = lastLine[3];

        long result1 = 0;
        long result2 = 0;

        for (int row = 0; row < a.length; row++) {
            long value = 0;
            long max1 = 0;
            long max2 = 0;
            for (int col = 0; col < a[0].length;col++) {
                value += Math.abs(a[row][col]);
                max1 += Math.abs(a[row][col] + v1);
                max2 += v2;
            }

            result1 += Math.max(Math.max(max1, max2), value);
        }

        for (int col = 0; col < a[0].length; col++) {
            long value = 0;
            long max1 = 0;
            long max2 = 0;
            for (int row = 0; row < a.length; row++) {
                value += Math.abs(a[row][col]);
                max1 += Math.abs(a[row][col] + v3);
                max2 += v4;
            }

            result2 += Math.max(Math.max(max1, max2), value);
        }

        if (result1 > result2) {
            System.out.print(result1);
        } else {
            System.out.print(result2);
        }
    }
}