public class Main {

    public static void binarySearch(int[] arr, int num){
        int start=0, end=arr.length-1,mid=start+((end-start)/2);
        boolean flag = true;

        while(start<=end){
            if(arr[mid]==num) {
                System.out.println("num " + num + " is at index " + mid);
                flag=false;
                break;
            }
            else if(arr[mid]>num)
                end=mid-1;
            else
                start = mid+1;
            mid=start+((end-start)/2);
        }
        if (flag)
            System.out.println("Number "+num +" not found in array");
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90,100};
        int num = 116;

        binarySearch(arr,num);
    }
}