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
    public static int findNumInBitonicArray(int[] arr,int num){
        int peak = peakInBitonicArray(arr);
        if(arr[peak]==num) return peak;

        //first half of the array
        int start=0,end=peak-1,mid=start+((end-start)/2);
        while (start<=end){
            if (arr[mid]==num) return mid;
            else if(arr[mid]>num) end=mid-1;
            else start=mid+1;
            mid=start+((end-start)/2);
        }

        //2nd half of the array
        start = peak; end = arr.length-1; mid = start + ((end - start) / 2);
        while (start <= end) {
            if (arr[mid] == num) return mid;
            else if (arr[mid] < num) end = mid - 1;
            else start = mid + 1;mid = start + ((end - start) / 2);
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr ={1,3,8,12,4,2}; int n=4;
        int[] brr={10,15,20,19,18,16}; int n1=16;



        System.out.println("Index of "+n+"  in input = "+findNumInBitonicArray(arr,n));
        System.out.println("Index of "+n1+" in input = "+findNumInBitonicArray(brr,n1));

        /*
        System.out.println("Index of 1  in input = "+findNumInBitonicArray(arr,1));
        System.out.println("Index of 3  in input = "+findNumInBitonicArray(arr,3));
        System.out.println("Index of 8  in input = "+findNumInBitonicArray(arr,8));
        System.out.println("Index of 12  in input = "+findNumInBitonicArray(arr,12));
        System.out.println("Index of 2  in input = "+findNumInBitonicArray(arr,2));
        */
    }
}