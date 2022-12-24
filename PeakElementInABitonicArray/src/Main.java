import java.util.Arrays;

public class Main {

    public static int peakInBitonicArray(int[] arr){
        System.out.println(); System.out.println("Input = "+ Arrays.toString(arr));
        int start=0, end=arr.length-1,mid=start+((end-start)/2);
        while (start<=end){
            //edge cases
            if(mid==0)
                if(arr[mid]<arr[mid]+1) return mid;
                else start=mid+1;
            else if (mid>=arr.length-1)   
                if(arr[arr.length-1]>arr[arr.length-2]) return arr.length-1;
                else end=arr.length-2;
            else if (arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid]<arr[mid+1]) start=mid+1;
            else end=mid-1;
            mid=start+((end-start)/2);
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] arr ={1,3,8,12,4,2};
        int[] brr={10,15,20,19,18,16};

        System.out.println("Index of peak element in input = "+peakInBitonicArray(arr));
        System.out.println("Index of peak element in input = "+peakInBitonicArray(brr));
    }
}