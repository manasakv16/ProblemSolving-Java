import java.util.Arrays;

public class Main {

    public static int minimumDifferenceInASortedArray(int[] arr, int num){
        System.out.println(); System.out.println("Input = "+ Arrays.toString(arr));
        int start=0,end=arr.length-1,mid=start+((end-start)/2);
        while (start<=end){
            if(arr[mid]==num)
                return num;
            if(arr[mid]>num)
                end=mid-1;
            else start=mid+1;
            mid=start+((end-start)/2);
        } //System.out.println(start+" "+end);

        if((start==0))  return arr[start];
        if(start==arr.length)  return arr[arr.length-1];

        if((arr[start]-num)>(arr[end]-num))
            return arr[end];
        return arr[start];
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90,100, 130, 140, 160, 170};
        int num =16;

        System.out.println("minimum difference of "+num+" is with "+minimumDifferenceInASortedArray(arr,num));
        System.out.println("minimum difference of 1 is with "+minimumDifferenceInASortedArray(arr,1));
        System.out.println("minimum difference of 10 is with "+minimumDifferenceInASortedArray(arr,10));
        System.out.println("minimum difference of 159 is with "+minimumDifferenceInASortedArray(arr,159));
        System.out.println("minimum difference of 171 is with "+minimumDifferenceInASortedArray(arr,171));
        System.out.println("minimum difference of 141 is with "+minimumDifferenceInASortedArray(arr,141));
        System.out.println("minimum difference of 99 is with "+minimumDifferenceInASortedArray(arr,99));
        System.out.println("minimum difference of 50 is with "+minimumDifferenceInASortedArray(arr,50));
        System.out.println("minimum difference of 8 is with "+minimumDifferenceInASortedArray(arr,8));
    }
}