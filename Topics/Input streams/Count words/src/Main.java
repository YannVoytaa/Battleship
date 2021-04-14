import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int current = reader.read();
        boolean lastCharWasLetter = false;
        int words = 0;
        while (current != -1) {
            if (current == 32) {
                if (lastCharWasLetter) words++;
                lastCharWasLetter = false;
            }
            else {
                lastCharWasLetter = true;
            }
            current = reader.read();
        }
        if (lastCharWasLetter) words++;
        System.out.println(words);
        reader.close();
    }
}