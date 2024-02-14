package Lab;

public class FrogJumpingPlatform {

    public static void main(String[] args) {
        System.out.println(jump(5));
    }

    private static int jump(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

}
