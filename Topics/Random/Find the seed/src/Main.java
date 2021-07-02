import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        Random random;
        int minOfMax = k;
        int seed = a;

        for (int i = a; i <= b; i++) {
            random = new Random(i);
            int maxInSeed = 0;
            for (int j = 0; j < n; j++) {
                int rand = random.nextInt(k);
                if (maxInSeed < rand) {
                    maxInSeed = rand;
                }
            }
            if (maxInSeed < minOfMax) {
                minOfMax = maxInSeed;
                seed = i;
            }
        }
        System.out.println(seed);
        System.out.println(minOfMax);
    }
}