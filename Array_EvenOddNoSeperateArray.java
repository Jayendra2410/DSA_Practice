import java.util.Scanner;
import java.util.ArrayList;

public class Array_EvenOddNoSeperateArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        for(int num : arr){
            if(num % 2 == 0){
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }
        System.out.println("Even numbers in the array:");
        for(int evenNum : evenList){
            System.out.print(evenNum + " ");
        }
        System.out.println();
        System.out.println("Odd numbers in the array:");
        for(int oddNum : oddList){
            System.out.print(oddNum + " ");
        }
        System.out.println();
        scanner.close();
    }
}
