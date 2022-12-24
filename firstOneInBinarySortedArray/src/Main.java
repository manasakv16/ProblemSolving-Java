import java.util.Arrays;

public class Main {
    public static int oneInBinarySortedInfiniteArray(int[] arr){
        System.out.println(); System.out.println("Input = "+ Arrays.toString(arr));

        if(arr[0]==1)  return 0;

        int start=0, end=1;

        while (start<=end){
            if(arr[end]==1)  return end;
            start = end + 1;
            if ((start * 2) < arr.length - 1)
                end = start * 2;
            else { end = arr.length-1;
                break;
            }
        } //System.out.println(start+" "+end);

        int mid=start+((end-start)/2);

        while (start<=end){
            if(arr[mid]==1 && arr[mid-1]==0)  return mid;
            else if (arr[mid]==1)  end=mid-1;
            else start=mid+1;
            mid=start+((end-start)/2);
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {0,0,0,0,0};
        int[] brr={0,1,1,1};
        int[] crr={0,0,0,0,1};
        int[] drr={0,0,1,1,1};

        System.out.println("Index of 1 in input array is "+oneInBinarySortedInfiniteArray(arr));
        System.out.println("Index of 1 in input array is "+oneInBinarySortedInfiniteArray(brr));
        System.out.println("Index of 1 in input array is "+oneInBinarySortedInfiniteArray(crr));
        System.out.println("Index of 1 in input array is "+oneInBinarySortedInfiniteArray(drr));



    }
}