public class Array_MoveAllZerosToEnd {
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public void arrayDemo(){
        int arr[] = {0, 1, 0, 3, 12};
        printArray(arr);
        moveAllZerosToEnd(arr);
        printArray(arr);
    }
    public void moveAllZerosToEnd(int[] arr){
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
    }
    public static void main(String[] args){
        Array_MoveAllZerosToEnd arrayMoveZeros = new Array_MoveAllZerosToEnd();
        arrayMoveZeros.arrayDemo();
    }
}
