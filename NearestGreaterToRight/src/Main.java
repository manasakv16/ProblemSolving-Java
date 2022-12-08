import java.util.*;

public class Main {
    public static void main(String[] args) {
        //int[] arr = {10,3,2,4};
        int[] arr = {100,80,60,70,60,75,85};
        Stack<Integer> stalk = new Stack();
        List<Integer> res= new ArrayList<>();
        List<Integer> res1= new ArrayList<>();
        int count=1;
        System.out.println(Arrays.toString(arr));

        for(int i=0;i<arr.length;i++){
            //count=1;
            if(stalk.empty())
                res.add(-1);

            else{
                if(stalk.peek()>arr[i])
                    res.add(stalk.peek());
                else{
                    while (!stalk.empty() && stalk.peek()<=arr[i]) {
                        stalk.pop();
                        count+=1;
                    }
                    if(stalk.empty())
                        res.add(-1);
                    else
                        res.add(stalk.peek());
                }
            } res1.add(count);
            stalk.push(arr[i]);
        }
        for (int i=0;i<arr.length;i++)
            System.out.println("Largest element to the left of "+arr[i]+" is "+res.get(i)+" "+res1.get(i));
    }
}