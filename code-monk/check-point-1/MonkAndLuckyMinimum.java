import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Monk just purchased an array A having N integers. Monk is very superstitious. 
 * He calls the array A Lucky if the frequency of the minimum element is odd, otherwise he considers it Unlucky. Help Monk in finding out if the array is Lucky or not.
 * 
 * Input:
 * First line consists of a single integer denoting the number of test cases.
 * First line of each test case consists of a single integer.
 * denoting the size of array A.
 * Second line of each test case consists of N space separated integers denoting the array A.
 * 
 * Output: For each test case, print "Lucky" (without quotes) if frequency of minimum element is odd, otherwise print "Unlucky"(without quotes). Print a new line after each test case.
 * Constraints: 1 ≤ T ≤ 10
 * 1 ≤ N ≤ 10^5
 * 1 ≤ A[i] ≤ 10^9
 * 
 * Sample input:
 * 2
 * 5
 * 8 8 9 5 9
 * 5
 * 3 3 3 5 3
 * 
 * Sample output:
 * Lucky
 * Unlucky
 */
public class MonkAndLuckyMinimum {
    public static void main(String[] args) throws Throwable {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("MonkAndLuckyMinimum.txt"));
        String line = bufferedReader.readLine();
        int t = Integer.parseInt(line);

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int array[] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean lucky = isLucky(array, n);
            if (lucky) {
                System.out.println("Lucky");
            } else {
                System.out.println("Unlucky");
            }
        }
    }

    private static boolean isLucky(int[] array, int n) {

        if (array.length == 0)
            return false;

        Arrays.sort(array);

        int i = 1;
        while (i < n) {
            if (array[i - 1] == array[i]) {
                i++;
            } else {
                break;
            }
        }

        if (i % 2 == 0) {
            return false;
        }

        return true;
    }
}