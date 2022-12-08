import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        Stack<Integer> stalk = new Stack();
        Stack res = new Stack<>();

        System.out.println(Arrays.toString(arr));

        for(int i=arr.length-1;i>=0;i--){

            //check if stalk is empty, if yes push -1
            if(stalk.empty()) {
                res.push(-1);
            }
            else {
                //check if top of stalk is greater than the number, if yes push it
                if (stalk.peek() > arr[i]) {
                    res.push(stalk.peek());
                }
                else{
                    //pop the elements until stalk top will be greater/stalk is empty
                    while(!stalk.empty() && stalk.peek()<=arr[i]) {
                        stalk.pop();
                    }
                    if(stalk.empty()) //push -1 if stalk empty
                        res.push(-1);
                    else //push num as it's greater
                        res.push(stalk.peek());
                }
            }
            //push the next element
            stalk.push(arr[i]);
        }

        for(int i=0;i<arr.length;i++)
            System.out.println("Next Largest Element of "+arr[i]+" is " +res.pop());

        // brute force approach
        /*
        int res=0;
        for(int i=0;i<arr.length;i++){
            res=-1;
            for(int j=i+1;j<arr.length;j++){
                System.out.println("j loop executed for"+j);
                if(arr[j]>arr[i]){
                    res=arr[j];
                    break;
                }
            } System.out.println(arr[i]+" " +res);
        }
         */
    }
}