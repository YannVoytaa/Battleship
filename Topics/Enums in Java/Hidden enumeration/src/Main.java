/* sample enum for inspiration
enum Secret {
    STAR, CRASH, START, // ...
}*/

public class Main {

    public static void main(String[] args) {
        int res = 0;
        for (Secret secret : Secret.values()) {
            if (secret.name().startsWith("STAR")) res++;
        }
        System.out.println(res);
    }
}
