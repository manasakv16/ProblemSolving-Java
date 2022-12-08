import java.util.*;

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
        if(num1!=o.num1)
            return num1-o.num1;
        else
        if(num2>o.num2) // if count is same, display numbers in descending order. if 3 & 2 are repeating twice => 3,3,2,2
            return -1;
        else return 1;
    }
}

public class Main {
    public static HashMap checkCount(int[] arr){
        System.out.println("Input array = "+Arrays.toString(arr));
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(count.containsKey(arr[i]))
                count.put(arr[i],(count.get(arr[i]))+1);
            else
                count.put(arr[i],1);
        }
        System.out.println("HashMap = "+count);
        return count;
    }
    public static void frequencySort(HashMap count){
        PriorityQueue<Pair> minh = new PriorityQueue();
        List<Integer> set = count.keySet().stream().toList();
        for(int i=0;i<count.size();i++){
            int temp = (int) count.get(set.get(i));
            //System.out.println(temp+" "+set.get(i));
            minh.add(new Pair(temp, set.get(i)));
        }
        int n = minh.size();
        for (int i=0;i<n;i++){
            int temp = minh.peek().getNum1();
            while (temp>0){
                System.out.print(minh.peek().getNum2()+" , ");
                temp--;
            }minh.poll();
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4,4,4,4,0,0,0,0,0,5};
        frequencySort(checkCount(arr));
    }
}