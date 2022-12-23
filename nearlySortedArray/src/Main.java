import java.util.Arrays;

public class Main {

    public static int findIndexInNearlySortedArray(int[] arr, int num){
        System.out.println("Input = "+ Arrays.toString(arr));
        int start=0,end=arr.length-1, mid = start+((end-start)/2);
        while (start<=end){
            if(arr[mid]==num)
                return mid;
            if(mid!=0 && arr[mid-1]==num)
                return mid-1;
            if(mid!=arr.length-1 && arr[mid+1]==num)
                return mid+1;
            if (arr[mid-1]>num)
                end = mid-2;
            else start=mid+2;
            mid = start+((end-start)/2);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {5,10,30,20,40};
        int num=40;

        System.out.println("Index of num "+num+" is : "+findIndexInNearlySortedArray(arr,num));

    }
}