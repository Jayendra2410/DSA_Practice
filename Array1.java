public class Array1{
    public void printArray(int []arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+"");
        }
        System.out.println();
    }
    public void arrayDemo(){
        int[] myArray= new int[5];
        myArray[0]=8;
        myArray[1]=3;
        myArray[2]=5;
        myArray[3]=7;
        myArray[4]=9;
        printArray(myArray);
    }
    public static void main(String []args){
        Array1 arr1=new Array1();
        arr1.arrayDemo();
    }
}