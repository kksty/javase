package Learn.Lab;

public class BinarySearchMethod {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int target = 15;
        System.out.println(binarySearch(arr, target));
    }

    /**
     * 对输入数组执行二分查找，以找到目标元素。
     *
     * @param arr    要搜索的输入数组
     * @param target 要查找的目标元素
     * @return 目标元素在数组中的索引，如果未找到则返回-1
     */
    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = arr[mid];
            if (i < target)
                left = mid + 1;
            else if (i > target)
                right = mid - 1;
            else
                return mid;
        }
        return -1;

    }
}
