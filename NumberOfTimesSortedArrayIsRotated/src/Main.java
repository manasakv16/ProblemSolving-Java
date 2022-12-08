import java.util.Arrays;

public class Main {
    //using binary search
    public static void countRotation(int[] arr){
        int start=0,end=arr.length-1,mid=start+((end-start)/2);
        System.out.println(Arrays.toString(arr));
        //binary search
        while (start<=end){
            //System.out.println(mid+" "+arr[mid]+" "+start+" "+end+" "+arr.length);
            if(mid==arr.length-1) {
                System.out.println("Array is not rotated");
                break;
            }
            else if(arr[mid]>arr[mid+1]){
                System.out.println("Array is rotated "+Math.abs(mid+1)+" times ");
                break;
            } else if (arr[start]>arr[mid]) {
                end = mid-1;
            }
            else start=mid+1;
            mid=start+((end-start)/2);
        }
        System.out.println();
    }

    public static void countRotationBruteForce(int[] arr){
        //brute force
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[i+1]){
                System.out.println("Array is rotated "+Math.abs(i+1)+" times ");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {13,14,15,16,17,6,7,8,9,10,11,12};
        int[] arr1 = {4,5,6,0,1,2,3};
        int[] arr2 = {2,3,4,5,6,7,8};

        countRotation(arr);
        countRotation(arr1);
        countRotation(arr2);
    }
}