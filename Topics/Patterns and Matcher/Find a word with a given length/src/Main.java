import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile(String.format("(?i)\\b[a-z]{%d}\\b", size));
        boolean match = pattern.matcher(line).find();
        System.out.println(match ? "YES" : "NO");
    }
}