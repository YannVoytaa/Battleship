import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int max = 0;
        int row = -1;
        int col = -1;
        int akt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                akt = scanner.nextInt();
                if (max < akt || row == -1) {
                    max = akt;
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(row + " " + col);
    }
}