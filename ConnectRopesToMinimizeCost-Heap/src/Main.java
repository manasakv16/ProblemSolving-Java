import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    private int num1;
    private int num2;
    public Pair(int num1,int num2){
        this.num1=num1;
        this.num2=num2;
        //System.out.println("creating Pair "+num1+ " "+num2);
        //System.out.println();
    }

    public Pair(){}

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public static void print(Pair p){
        //
        System.out.println("printing pair"+p.num1+" "+p.num2);
        System.out.println();
    }

    public int compareTo(Pair o) {
        if(num1!=o.num1)
            return num1-o.num1;
        else
        if(num2>o.num2) // if count is same, display numbers in descending order. if 3 & 2 are repeating twice => 3,3,2,2
            return -1;
        else return 1;
    }
}

public class Main {
    public static void connectRopesWithMinCost(int[] arr){
        System.out.println("Input : "+ Arrays.toString(arr));
        int res=0;
        PriorityQueue<Integer> minh = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            minh.add(arr[i]);
        }
        while (minh.size()>1){
            int sum = minh.poll()+minh.poll();
            res+=sum;
            minh.add(sum);
        }
        System.out.println("Minimun cost to join the given ropes = "+res);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; //33
        int[] brr={4,3,2,6}; //29
        int[] crr= {8, 4, 6, 12}; // 58
        int[] drr = {20, 4, 8, 2}; //54
        int[] err = {1, 2, 5, 10, 35, 89}; //224
        int[] f ={2, 2, 3, 3}; //20
        connectRopesWithMinCost(arr);
        connectRopesWithMinCost(brr);
        connectRopesWithMinCost(crr);
        connectRopesWithMinCost(drr);
        connectRopesWithMinCost(err);
        connectRopesWithMinCost(f);
    }
}