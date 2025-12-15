public class Array_MinValue {
    public int findMinimum(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public static void main(String[] args){
        Array_MinValue arrayMinValue = new Array_MinValue();
        int[] sampleArray = {34, 15, 88, 2, 47};
        int minValue = arrayMinValue.findMinimum(sampleArray);
        System.out.println("The minimum value in the array is: " + minValue);
    }
}
