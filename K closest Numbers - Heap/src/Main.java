import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    private  int num1;
    private int num2;
    public Pair(int num1,int num2){
        this.num1=num1;
        this.num2=num2;
        //System.out.println("creating Pair "+num1+ " "+num2);
        //System.out.println();
    }

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
        // ...
        //System.out.println("comparing Pair num1 = "+num1+ " num2= "+num2+ " and o.num1 = "+o.num1+" o.num2 = "+o.num2);
        //System.out.println("returning "+(num1-o.num1));
        return num1-o.num1;
    }
}

public class Main {
    public static void kClosestNumber(int[] arr,int k,int num){
        PriorityQueue<Pair> maxh = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            int temp = Math.abs(num-arr[i]);
            maxh.add(new Pair(temp,arr[i]));
            if(maxh.size()>k)
                maxh.poll();
        }
        for(int i=0;i<k;i++)
            System.out.println(maxh.poll().getNum2());
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7};
        int num = 3;
        int k = 2; // 5 numbers that are close to "num"
        kClosestNumber(arr,k,num);
    }
}