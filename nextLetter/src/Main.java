import java.util.Arrays;

import static java.lang.Integer.valueOf;

public class Main {

    public static char ceilInASortedArray(char[] arr, char num){
        System.out.println();
        System.out.println("Input = "+ Arrays.toString(arr));
        int start =0, end = arr.length-1,mid=start+((end-start)/2);
        char res=' ';
        while (start<=end){
            if(arr[mid]==(num))
                return arr[mid+1];
            if (valueOf(arr[mid])> valueOf(num)) {
                res=arr[mid];
                end = mid - 1;
            }
            else  start = mid + 1;

            mid=start+((end-start)/2);
        }
        return res;
    }

    public static void main(String[] args) {
        char[] brr = {'a','c','e','f','p','q','z'};
        char m = 'm',a='a',d='d',b='b';

        System.out.println("Next letter of "+m+" is "+ceilInASortedArray(brr,m));
        System.out.println("Next letter of "+a+" is "+ceilInASortedArray(brr,'a'));
        System.out.println("Next letter of "+d+" is "+ ceilInASortedArray(brr,'d'));
        System.out.println("Next letter of "+b+" is "+ceilInASortedArray(brr,'b'));
    }
}