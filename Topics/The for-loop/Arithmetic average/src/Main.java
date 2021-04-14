import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if(a % 3 != 0) {
            if(a > 0) {
                a -= a % 3;
                a += 3;
            }
            else {
                a -= (3 + a % 3);
                a += 3;
            }
        }
        if(b % 3 != 0) {
            if(b > 0) {
                b -= b % 3;
            }
            else {
                b -= (3 + b % 3);
            }
        }
        System.out.println((float)(a+b)/2);
    }
}