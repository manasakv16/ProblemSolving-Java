import java.util.Arrays;

public class Main {

    /*
    Peak element = an element which is higher than it's adjacent elements
    eg : {0,1,3,2} --> 3
        {10,20,30,40} ---> 40
        {5,4,3,2,1} --> 5
     */
    public static int peakElement(int[] arr){
        System.out.println(); System.out.println("Input array = "+ Arrays.toString(arr));
        int start=0,end=arr.length-1,mid=start+((end-start)/2);
        while (start<=end){
            //edge cases
            if(mid==0)
                if(arr[mid]>arr[mid+1])
                    return mid;
                else start=mid+1;
            else if (mid>=arr.length-1) {
                    if(arr[mid]>arr[mid-1])
                        return mid;
                    else end=arr.length-2;
            }

            else if (arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            else if(arr[mid]<arr[mid+1])
                    start=mid+1;
            else end=mid-1;
            mid=start+((end-start)/2);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr={4,5,0,35,0};
        int[] brr ={5,4,3,2,1};
        int[] crr={10,20,30,40,50};
        System.out.println("Index of peak element in the array = "+peakElement(arr));
        System.out.println("Index of peak element in the array = "+peakElement(brr));
        System.out.println("Index of peak element in the array = "+peakElement(crr));

    }
}