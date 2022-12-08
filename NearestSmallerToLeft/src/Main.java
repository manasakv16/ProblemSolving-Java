import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,30,20,40,10};
        Stack<Integer> stalk = new Stack();
        Stack res = new Stack<>();

        System.out.println(Arrays.toString(arr));

        for(int i=arr.length-1;i>=0;i--){
            //System.out.println(stalk+ " "+res);
            if(stalk.empty())
                res.push(-1);
            else{
                if(stalk.peek()<arr[i])
                    res.push(stalk.peek());
                else {
                    while(!stalk.empty() && stalk.peek()>=arr[i])
                        stalk.pop();
                    if(stalk.empty())
                        res.push(-1);
                    else
                        res.push(stalk.peek());
                }
            }stalk.push(arr[i]);
        }
        for (int i=0;i<arr.length;i++)
            System.out.println("Next Smallest Element to the left of "+arr[i]+" is " +res.pop());
    }
}