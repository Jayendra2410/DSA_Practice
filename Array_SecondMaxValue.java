public class Array_SecondMaxValue {
    public int findSecondMaximum(int[] arr){
        if(arr == null || arr.length < 2){
            throw new IllegalArgumentException("Array must contain at least two elements");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > max){
                secondMax = max;
                max = num;
            } else if(num > secondMax && num != max){
                secondMax = num;
            }
        }
        if(secondMax == Integer.MIN_VALUE){
            throw new IllegalArgumentException("No second maximum value found");
        }
        return secondMax;
    }
    public static void main(String[] args){
        Array_SecondMaxValue arrayMaxValue = new Array_SecondMaxValue();
        int[] sampleArray = {34, 15, 88, 2, 47};
        int maxValue = arrayMaxValue.findSecondMaximum(sampleArray);
        System.out.println("The second maximum value in the array is: " + maxValue);
    }
}
