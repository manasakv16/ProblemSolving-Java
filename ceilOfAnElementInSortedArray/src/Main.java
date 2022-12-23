import java.util.Arrays;

import static java.lang.Integer.valueOf;

public class Main {

    public static int ceilInASortedArray(int[] arr, int num){
        System.out.println("Input = "+ Arrays.toString(arr));
        int start =0, end = arr.length-1,mid=start+((end-start)/2);
        int res=0;
        while (start<=end){
            if(arr[mid]==num)
                return num;
            if (arr[mid]>num) {
                res=arr[mid];
                end = mid - 1;
            }
            else  start = mid + 1;

            mid=start+((end-start)/2);

        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,8,10,11,12,19};
        int num =5;

        System.out.println(ceilInASortedArray(arr,num));
        /*
        System.out.println(ceilInASortedArray(arr,6));
        System.out.println(ceilInASortedArray(arr,16));
        System.out.println(ceilInASortedArray(arr,20));
        System.out.println(ceilInASortedArray(arr,1));

         */



    }
}