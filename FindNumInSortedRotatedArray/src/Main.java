import java.util.Arrays;

public class Main {

    public static int findStartingIndexInRotatedArray(int[] arr){
        int start=0,end=arr.length-1,mid=start+((end-start)/2);
        System.out.println(Arrays.toString(arr));
        int index=0;
        //binary search
        while (start<=end){
            //System.out.println(mid+" "+arr[mid]+" "+start+" "+end+" "+arr.length);
            if(mid==arr.length-1) {
                //System.out.println("Array is not rotated");
                break;
            }
            else if(arr[mid]>arr[mid+1]){
                //System.out.println("Array is rotated "+Math.abs(mid+1)+" times ");
                index=mid; break;
            } else if (arr[start]>arr[mid]) {
                end = mid-1;
            }
            else start=mid+1;
            mid=start+((end-start)/2);
        }System.out.println("index is "+index);
        return index;
    }
    private static void findNumInSortedRotatedArrayUsingIndex(int[] arr, int num) {
        int index = findStartingIndexInRotatedArray(arr);

        int start=index,end=arr.length-1,mid=start+((end-start)/2);
        boolean flag=true;
        //4,5,6,1,2,3
        while (start<=end){
            if(arr[mid]==num){
                System.out.println("index of "+num+" is "+mid);
                flag=false;
                break;
            }
            else if(arr[mid]>num)
                end=mid-1;
            else start=mid+1;
            mid=start+((end-start)/2);
        }
        if(flag) {
            start = 0;
            end = index - 1;
            mid = start + ((end - start) / 2);
            while (start <= end) {
                if (arr[mid] == num) {
                    System.out.println("index of " + num + " is " + mid);
                    flag = false;
                    break;
                } else if (arr[mid] > num)
                    end = mid - 1;
                else start = mid + 1;
                mid = start + ((end - start) / 2);
            }
        }System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {13,14,15,16,17,6,7,8,9,10,11,12};
        int[] arr1 = {4,5,6,0,1,2,3};
        int[] arr2 = {2,3,4,5,6,7,8};

        findNumInSortedRotatedArrayUsingIndex(arr,16);
        findNumInSortedRotatedArrayUsingIndex(arr1,4);
        findNumInSortedRotatedArrayUsingIndex(arr2,8);
    }
}