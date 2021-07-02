import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile(String.format("(?i)\\b[a-z]*%s\\b|\\b%s[a-z]*\\b", part, part));
        boolean match = pattern.matcher(line).find();
        System.out.println(match ? "YES" : "NO");
    }
}