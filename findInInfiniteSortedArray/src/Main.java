import java.util.Arrays;

public class Main {

    public static int infiniteSortedArray(int[] arr, int num){
        System.out.println();
        System.out.println("Input = "+ Arrays.toString(arr));
        int start=0, end=1;
        while (start<=end){
            //System.out.println(start+" "+end);
            if(arr[end]==num)
                return end;
            if(arr[end]<num) {
                start = end + 1;
                if ((start * 2) < arr.length - 1)
                    end = start * 2;
                else {
                    end = arr.length;
                    break;
                }
            }
            else break;
        }
        int mid=start+((end-start)/2);
        while (start<=end){
            if(arr[mid]==num)
                return mid;
            if (arr[mid]>num)
                end=mid-1;
            else start=mid+1;
            mid=start+((end-start)/2);
        }

        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {1,3, 5, 7, 9, 10, 90,100, 130, 140, 160, 170};
        int num=100;

        System.out.println("Index of "+num+" is "+infiniteSortedArray(arr,num));
        System.out.println("Index of 130 is "+infiniteSortedArray(arr,130));
        System.out.println("Index of 170 is "+infiniteSortedArray(arr,170));
        System.out.println("Index of 3 is "+infiniteSortedArray(arr,3));

    }
}