import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] getFirstAndLast(int[] arr) {
        int[] new_arr = {arr[0], arr[arr.length - 1]};
        return new_arr;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = getFirstAndLast(array);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}