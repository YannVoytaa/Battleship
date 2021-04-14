import java.util.Locale;
import java.util.Scanner;

public class Main {

    /* Fix this method */
    public static String toUpperCase(String str) {
        str = (str == null) ? "" : str;
        return str.toUpperCase(Locale.ENGLISH);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = "none".equalsIgnoreCase(line) ? null : line;
        System.out.println(toUpperCase(line));
    }
}