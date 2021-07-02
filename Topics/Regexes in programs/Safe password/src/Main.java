import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        final Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        String pattern1 = "^\\w*[A-Z]\\w*$";
        String pattern2 = "^\\w*[a-z]\\w*$";
        String pattern3 = "^\\w*\\d\\w*$";
        System.out.println(
                pass.matches(pattern1) &&
                pass.matches(pattern2) &&
                pass.matches(pattern3) &&
                pass.length() >= 12 ? "YES" : "NO"
        );
    }
}