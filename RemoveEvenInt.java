public class RemoveEvenInt {
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int[] removeEven(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 9, 6, 10};
        System.out.print("Original array: ");
        printArray(arr);
        int[] result = removeEven(arr);
        System.out.print("After removing even numbers: ");
        printArray(result);
    }
}
