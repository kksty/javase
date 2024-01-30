package Learn.Lab;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) throws Exception {
        System.out.println(Palindrome());
    }

    private static boolean Palindrome() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length / 2) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
            i++;

        }
        return true;
    }
}
