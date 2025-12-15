import java.util.Scanner;

public class ArrayReversal {
    public static void reverse(int[] numbers, int start, int end){
        while(start<end){
            int temp=numbers[start];
            numbers[start]=numbers[end];
            numbers[end]=temp;
            start++;
            end--;
        }
    }
    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args){
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Array Size:");
        n=sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter Array elements: ");
        for(int i=0; i<n; i++)
        {
            array[i]=sc.nextInt();
        }
        System.out.println("Original Array:");
        printArray(array);
        System.out.println();
        reverse(array, 0, n-1);
        System.out.println("Reversed Array:");
        printArray(array);
        sc.close();
    }
}
