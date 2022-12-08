import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static PriorityQueue setTestValuesToMaxh(PriorityQueue maxh){
        int[] arr = {1,2,3,4};
        for(int i=0;i<arr.length;i++){
            maxh.add(arr[i]);
        }
        return maxh;
    }

    public static PriorityQueue setTestValuesToMinh(PriorityQueue minh){
        int[] arr = {5,6,7,8};
        for(int i=0;i<arr.length;i++){
            minh.add(arr[i]);
        }
        return minh;
    }

    public static void readAndPrintMedian(){

        PriorityQueue<Integer> minh = new PriorityQueue<>();
        PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());
        // to add starting values
        //maxh.add(1); minh.add(10);
        float median=0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            if (minh.size() == maxh.size()) {
                maxh.add(in.nextInt());
                minh.add(maxh.poll());

            } else {
                minh.add(in.nextInt());
                maxh.add(minh.poll());
            }
            System.out.println(maxh+" "+minh);
            if(minh.size()>maxh.size())
                median= minh.peek();
            else  median = (float) (maxh.peek()+ minh.peek())/2;

            System.out.println("Median = "+median);
        }
    }

    public static void main(String[] args) {
       // setTestValuesToMaxh(maxh);  setTestValuesToMinh(minh);
        readAndPrintMedian();
    }
}