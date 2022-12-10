import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//ReadMe
/* Explanation
an array is given {2,7,4,1,8,1}
taken 2 highest elements and process it as below -a,b
1. if a==b, both stones destroyed
2. if a!=b, |a-b| = new weight
=> sorted array = {1,1,2,4,7,8}
i. 7-8 = 1 => {1,1,1,2,4}
ii. 2-4 = 2 => {1,1,1,2}
iii. 1-2 = 1 => {1,1,1,1}
iv. 1-1 =0 =>{1} --> result

if arr.size becomes zero, then print zero.
 */

public class Main {
    public static void lastStoneWeight(int[] arr){
        System.out.println("Input = "+ Arrays.toString(arr));
        PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<arr.length;i++){
            maxh.add(arr[i]);
        }
        while (maxh.size()>1){
            int num1 = maxh.poll();
            int num2 = maxh.poll();
            if(num1!=num2) {
                int temp = Math.abs(num1-num2);
                maxh.add(temp);
            }
        }
        if(maxh.size()==0)
            System.out.println("0");
        else System.out.println(maxh.peek());
    }

    public static void main(String[] args) {
        int[] arr={2,7,4,1,8,1};
        int[] brr={321, 5, 253, 2, 7, 9, 1045};
        lastStoneWeight(arr);
        lastStoneWeight(brr);
    }
}