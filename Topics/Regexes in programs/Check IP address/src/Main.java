import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        final Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        String subpattern = "(\\d{1,2}|1\\d{2}|2(5[0-5]|[0-4]\\d))";
        String pattern = String.format("^%s\\.%s\\.%s\\.%s$", subpattern, subpattern, subpattern, subpattern);
        System.out.println(ip.matches(pattern) ? "YES" : "NO");
    }
}