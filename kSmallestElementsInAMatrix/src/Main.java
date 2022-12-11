import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    //Time complexity is still a bit high, can be optimised further with Alogorithms
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxh = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int x : matrix[i]) {
                maxh.add(x);
                if (maxh.size() > k)
                    maxh.poll();
            }
        }
        System.out.println(maxh.peek());
        return maxh.peek();
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4,5},{5,6,7,8,9},{10,11,12,12,13},{14,15,16,17,18},{19,20,21,22,23}};
        int k = 18;
        int [][] arr ={{1,2},{3,4},{5,6}};
        int k1=2;

        kthSmallest(mat,k);
        kthSmallest(arr, k1);
    }
}