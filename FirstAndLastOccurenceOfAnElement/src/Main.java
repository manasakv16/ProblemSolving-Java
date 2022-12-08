import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {16,16,16,20,30,30,30,30,40,50,60,70,80,90,100,100,100,100,100};

        findOccurence(arr,16);
        findOccurence(arr,30);
        findOccurence(arr,100);
    }

    // To find first and last occurence of an element and print it's count.
    public static void findOccurence(int[] arr, int num){
        System.out.println(Arrays.toString(arr));

        int start=0, end=arr.length-1,mid=start+((end-start)/2);
        boolean flag = true;
        int starti=0,endi=0;

        while(start<=end){
            //System.out.println(mid + " "+arr[mid]+" "+start+" "+end);
            if(arr[mid]==num &&(mid==0 || num>arr[mid-1])) {
                starti = mid;
                break;
            }
            else if(num<=arr[mid])
                end=mid-1;
            else
                start=mid+1;
            mid=start+((end-start)/2);
        }

        start=0; end=arr.length-1; mid=start+((end-start)/2);

        while(start<=end){
            //System.out.println(mid + " "+arr[mid]+" "+start+" "+end+" "+num);
            if(arr[mid]==num &&(mid==arr.length-1 || num<arr[mid+1] )) {
                endi = mid;
                break;
            }
            if(num<arr[mid])
                end=mid-1;
            else
                start=mid+1;
            mid=start+((end-start)/2);
        }
        System.out.println("number "+num +" first occured at "+starti +" and last occured at "+endi);
        int count = Math.abs(starti-endi)+1;
        System.out.println("count of number "+num+" in array is "+count );
        System.out.println();
    }
}