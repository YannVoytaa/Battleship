import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int companies = scanner.nextInt();
        int[] income = new int[companies + 1];
        for (int i = 1; i <= companies; i++) {
            income[i] = scanner.nextInt();
        }
        int max = 0;
        int percent, ind=0;
        for (int i = 1; i <= companies; i++) {
            percent = scanner.nextInt();
            if (max < income[i] * percent) {
                max = income[i] * percent;
                ind = i;
            }
        }
        System.out.println(ind);
    }
}