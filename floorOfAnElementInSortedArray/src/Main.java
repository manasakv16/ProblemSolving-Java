import java.util.Arrays;

public class Main {

    public static int floorInASortedArray(int[] arr, int num){
        System.out.println("Input = "+ Arrays.toString(arr));
        int start =0, end = arr.length-1,mid=start+((end-start)/2);
        int res=0;
        while (start<=end){
            if(arr[mid]==num)
                return num;
            if (arr[mid]>num)
                end =mid-1;
            else { res=arr[mid];
                start = mid + 1;
            }
            mid=start+((end-start)/2);

        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,8,10,11,12,19};
        int num =5;

        System.out.println(floorInASortedArray(arr,num));
        System.out.println(floorInASortedArray(arr,6));
        System.out.println(floorInASortedArray(arr,16));
        System.out.println(floorInASortedArray(arr,20));
        System.out.println(floorInASortedArray(arr,1));

    }
}