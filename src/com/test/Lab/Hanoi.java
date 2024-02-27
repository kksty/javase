package com.test.Lab;

public class Hanoi {
    public static void main(String[] args) {
        new Hanoi().hanoi('A', 'B', 'C', 3);
    }

    void hanoi(char a, char b, char c, int n) {
        if (n == 1) {
            System.out.println(a + "->" + c);
        } else {
            hanoi(a, c, b, n - 1);
            System.out.println(a + "->" + c);
            hanoi(b, a, c, n - 1);
        }
    }
}
