import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        String[] decomposition = decompose(n, 1000000);
//        for (String row : decomposition) {
//            System.out.println(row);
//        }
//        System.out.println(Arrays.toString(decomposition));

        for (String row : decompose(n, 1000000)) {
            System.out.println(row);
        }

//        System.out.println(decompose(n));
    }

//    public static String decompose(int n) {
//        String decomposition = "";
//        Pattern pattern = Pattern.compile("\\d+");
//        for (int i = 1; i <= n; i++) {
//            // at last iteration add n in the end of decomposition
//            if (n == i) {
////                return decomposition + n + "\n";
//                return decomposition + "\n" + n;
//            }
//
//            //пересоздавать массив каждый раз при изменении его длины
//            //String[] prevDecomposition = decompose(n - i).split("\\n"); // remainder decomposition
//            decomposition += decompose(n - i).replace("\n", "\n" + i + " ");
////            for (String row : decompose(n - i).split("\\n")) {
////                Matcher matcher = pattern.matcher(row);
////                matcher.find();
////                int firstNum = Integer.parseInt(matcher.group(0));
////                if (i >= firstNum) {
////                    decomposition += i + " " + row + "\n";
////                }
////            }
//        }
//        return decomposition; //никогда не срабатывает
//    }

    public static String[] decompose(int n, int iteration) {
        String[] decomposition = new String[0];
        for (int i = 1; i <= n; i++) {
            // at last iteration add n in the end of decomposition
            if (n == i) {
                String[] tempArr = Arrays.copyOfRange(decomposition, 0, decomposition.length + 1);
                tempArr[tempArr.length - 1] = String.valueOf(n);
                return tempArr;
            }

            //пересоздавать массив каждый раз при изменении его длины
            String[] prevDecomposition = decompose(n - i, i); // remainder decomposition
            String[] curDecomposition = Arrays.copyOfRange(
                    decomposition,
                    0,
                    decomposition.length + prevDecomposition.length
            );

            int l = 0 + decomposition.length;
            for (int j = 0 + decomposition.length; j < curDecomposition.length; j++) {
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(prevDecomposition[j - decomposition.length]);
                matcher.find();
                int firstNum = Integer.parseInt(matcher.group(0));
                if (i >= firstNum && iteration >= i) {
                    curDecomposition[l] = i + " " + prevDecomposition[j - decomposition.length];
                    l++;
                }
            }
            decomposition = Arrays.copyOfRange(curDecomposition, 0, l);
//            decomposition = Arrays.copyOfRange(curDecomposition, 0, curDecomposition.length);
        }
        return decomposition; //никогда не срабатывает
    }
}