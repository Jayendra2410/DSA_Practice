public class Array_MissingNo {
    public void printArray(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int findMissingNumber(int[] arr, int n){
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for(int num : arr){
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
    public static void main(String[] args){
        Array_MissingNo array_MissingNo = new Array_MissingNo();
        int n = 5; //Numbers are from 0 to 5
        int[] arr = new int[]{0, 1, 2, 4, 5}; //Missing number is 3
        int missingNumber = array_MissingNo.findMissingNumber(arr, n);
        System.out.println("The missing number is: " + missingNumber);
    }
}
