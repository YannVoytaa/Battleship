import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] t = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                t[i][j] = scanner.nextInt();
            }
        }
        int col1 = scanner.nextInt();
        int col2 = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == col1) System.out.print(t[i][col2] + " ");
                else if (j == col2) System.out.print(t[i][col1] + " ");
                else System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}