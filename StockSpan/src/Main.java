import java.lang.reflect.Array;
import java.util.*;

class Pair{
    int num1;
    int num2;
    public Pair(int num1,int num2){
        this.num1=num1;
        this.num2=num2;
    }
}

public class Main {

    public static int findIndex(int[] arr,int num,int k){
        //to find index of an element in an array
        int index=0;
        for (int i=0;i<=k;i++){
            if(arr[i]==num)
                return i;
        }
        return -1;
    }

    public static void stockSpanBruteForce(int[] arr){
        //brute force approach
        List<Integer> res = new ArrayList<>();
        int flag=1;
        for(int i=0;i<arr.length;i++){
            flag=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    flag+=1;
                }
            }
            res.add(flag);
        }
        for (int i=0;i<arr.length;i++)
        System.out.println("Stock span of "+arr[i]+" is "+res.get(i));

    }
    public static void stockSpan(int[] arr){

        Stack<Pair> stalk = new Stack(); //Pair<int,int> = <arr[i],i>
        List<Integer> res = new ArrayList<>();

        System.out.println("Input = "+Arrays.toString(arr));

        for(int i=0;i<arr.length;i++) {
            if (stalk.empty())
                res.add(1);
            else {
                if(stalk.peek().num1>arr[i]) {
                    res.add(1);
                }
                else{
                    while (!stalk.empty() &&(stalk.peek().num1<=arr[i])) {
                        stalk.pop();
                    }
                    if(!stalk.empty()) {
                        //System.out.println(arr[i] + " " + i + " " + index(arr, stalk.peek()));
                        res.add(Math.abs(i - stalk.peek().num2));
                    }
                }
            } stalk.push(new Pair(arr[i],i));
        }
        for (int i=0;i<arr.length;i++)
            System.out.println("Stock span of "+arr[i]+" is "+res.get(i) +" days");
    }

    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};

        stockSpan(arr);
    }
}

