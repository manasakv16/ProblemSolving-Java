import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static int kSmallestElement(int[]arr, int k){
        PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());
        //int res=0;
        for (int i=0;i<arr.length;i++){
            maxh.add(arr[i]);
            if(maxh.size()>k)
                maxh.poll();
        }
        System.out.println(k+ "th smallest element = "+maxh.peek());
        return maxh.peek();
    }
    public static void sumOfElementsBetweenK1SmallestAndK2Smallest(int[] arr, int k1, int k2){
        System.out.println("Input = "+ Arrays.toString(arr));

        int k1Smallest = kSmallestElement(arr,k1);
        int k2Smallest = kSmallestElement(arr,k2);

        int res=0; boolean flag=true;
        if(k1Smallest>k2Smallest)
            flag=false;
        if(flag)
            for (int i=0;i<arr.length;i++){
            if (arr[i]>k1Smallest && arr[i]<k2Smallest){
                res+=arr[i];
            }
        }
        else
            for (int i=0;i<arr.length;i++){
                if (arr[i]>k2Smallest && arr[i]<k1Smallest){
                    res+=arr[i];
                }
            }
        System.out.println("Sum of elements between "+k1+"th smallest element = "+k1Smallest +
                " and "+k2+"th smallest element = "+k2Smallest +" , when array is sorted is : "+res);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,12,5,15,11};
        int k1=3,k2=6;

        sumOfElementsBetweenK1SmallestAndK2Smallest(arr,k1,k2);

    }
}