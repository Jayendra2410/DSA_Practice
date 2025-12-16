public class Array_Resize {
    public void printArray(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int[] resize(int[] arr, int capacity){
        int[] newArr = new int[capacity];
        int lengthToCopy = Math.min(arr.length, capacity);
        for(int i=0; i<lengthToCopy; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }
    public static void main(String[] args){
        Array_Resize array_Resize = new Array_Resize();
        int[] originalArray = new int[]{2,5,1,78,43,24};
        System.out.println("The size of the original array is: " + originalArray.length);
        originalArray = array_Resize.resize(originalArray, 10);
        System.out.println("The size of the resized array is: " + originalArray.length);
        array_Resize.printArray(originalArray); // by default the end elements will be 0s
    }
}
