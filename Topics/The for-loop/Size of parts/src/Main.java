import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int akt;
        int zeroCounter = 0, oneCounter = 0, minusCounter = 0;
        for (int i = 1; i <= len; i++) {
            akt = scanner.nextInt();
            if (akt == 1) oneCounter++;
            else if (akt == -1) minusCounter++;
            else zeroCounter++;
        }
        System.out.println(zeroCounter + " " + oneCounter + " " + minusCounter);
    }
}