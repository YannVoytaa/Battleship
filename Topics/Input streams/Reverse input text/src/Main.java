import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<Character>();
        char current = (char) reader.read();
        while (current != (char) -1) {
            s.push(current);
            current = (char) reader.read();
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        reader.close();
    }
}