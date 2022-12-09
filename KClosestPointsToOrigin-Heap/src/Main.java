import java.util.Arrays;
import java.util.Collections;
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
class NumWithPair implements Comparable<NumWithPair>{
    private int num;
    Pair p = new Pair();

    NumWithPair(int num, Pair p){
        this.num=num;
        this.p=p;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int compareTo(NumWithPair o) {
        return num-o.num;
    }
}

public class Main {
    public static void kPointsCloseToOrigin(int[][] arr,int k){
        //System.out.println("Input = "+ Arrays.toString(arr));
        PriorityQueue<NumWithPair> maxp = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<arr.length;i++){
            int dist = findDistance(arr[i][0],arr[i][1]);
            maxp.add(new NumWithPair(dist,new Pair(arr[i][0],arr[i][1])));
            if(maxp.size()>k)
                maxp.poll();
        }
        System.out.println(k+" Points closest to origin are : ");
        for (int i=0;i<k;i++)
            System.out.println(maxp.peek().p.getNum1()+" "+maxp.poll().p.getNum2());
    }
    public static int findDistance(int x,int y){
        int dist=  (x*x)+(y*y);
        return dist;
    }
    public static void print2DArray(int[][] arr){
        System.out.println("Input points are : ");
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i][0]+" , "+arr[i][1] + "  ");
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{-2,2},{0,1},{5,8},{1,0}};
        int k=3;
        print2DArray(arr);
        kPointsCloseToOrigin(arr,k);
    }
}