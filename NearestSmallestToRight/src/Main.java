import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        Stack<Integer> stalk = new Stack();
        ArrayList<Integer> res = new ArrayList<>();

        System.out.println(Arrays.toString(arr));

        for (int i=0;i<arr.length;i++){
            if(stalk.empty())
                res.add(-1);
            else{
                if(stalk.peek()<arr[i])
                    res.add(stalk.peek());
                else{
                    while (!stalk.empty() && stalk.peek()>=arr[i])
                        stalk.pop();
                    if(stalk.empty())
                        res.add(-1);
                    else res.add(stalk.peek());
                }
            } stalk.push(arr[i]);
        }
        for (int i=0;i<arr.length;i++){
            System.out.println("Next smallest Element to the right of "+arr[i]+" is " +res.get(i));
        }
    }
}