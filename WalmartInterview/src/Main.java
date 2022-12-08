
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void print(String x){
        System.out.println("static string passed method");
    }

    public static void print(int x){
        System.out.println("static int passed method");
    }

    public static void main(String[] args) {

        print(10);
        print("S");


        int arr[] = {1, 2, 3, 4, 11, 12, 13, 14, 21, 22, 23, 24, 31, 32,0};
        PriorityQueue<Integer> minh = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<arr.length;i++) {
            minh.add(arr[i]);
            if (minh.size() > 2) {
                minh.poll();
            }
        }
        System.out.println("2nd smallest num "+minh.peek());

    }
}