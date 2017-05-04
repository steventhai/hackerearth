import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Arrays;

public class MonkAndLuckyMinimum {
    public static void main(String[] args) throws Throwable {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
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