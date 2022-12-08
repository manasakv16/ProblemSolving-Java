import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Pair implements Comparable<Pair>{
    private int num1;
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
    public static HashMap checkCount(int[] arr){
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(count.containsKey(arr[i]))
                count.put(arr[i],(count.get(arr[i]))+1);
            else
                count.put(arr[i],1);
        }
        System.out.println(count);
        return count;
    }
    public static void displayTopFrequentElements(HashMap count, int[] arr,int k){
        PriorityQueue<Pair> minh = new PriorityQueue();
        List<Integer> set = count.keySet().stream().toList();
        for(int i=0;i<count.size();i++){
            int temp = (int) count.get(set.get(i));
            minh.add(new Pair(temp, set.get(i)));
            if(minh.size()>k)
                minh.poll();
        }
        int n = minh.size();
        for (int i=0;i<n;i++)
            System.out.println("The number "+minh.peek().getNum2()+" is repeated "+minh.poll().getNum1()+" times");
        //System.out.println(minh.poll().getNum2());
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4,4,4,4};
        int k = 4;
        displayTopFrequentElements(checkCount(arr),arr,k);
    }
}