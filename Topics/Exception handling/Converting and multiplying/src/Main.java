import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true) {
            s = scanner.next();
            if (s.equals("0")) break;
            try {
                System.out.println(10 * Integer.parseInt(s));
            } catch (Exception e) {
                System.out.println("Invalid user input: " + s);
            }
        }
    }
}