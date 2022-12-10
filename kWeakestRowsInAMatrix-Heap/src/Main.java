import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    private int num1;
    private int num2;

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

    public Pair(int num1,int num2){
        this.num1=num1;
        this.num2=num2;
    }

    @Override
    public int compareTo(Pair o) {
        if(num1==o.num1)
            if(num2<o.num2)
                return -1;
            else return 1;
        return num1-o.num1;

    }
}

public class Main {
    public static void kWeakestRowsInAMatrix(int[][] arr,int k) {
        System.out.println("Input : " + Arrays.toString(arr));
        PriorityQueue<Pair> maxh = new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[k];

        for (int i = 0; i < arr.length; i++) {
            int[] b = arr[i];
            maxh.add(new Pair(findIndexOfZero(b),i));
            if(maxh.size()>k)
                maxh.poll();
        }

        //Arranging output in needed order
        for (int i=0;i<k;i++)
            res[k-i-1]=maxh.poll().getNum2();

        //printing
        System.out.println(Arrays.toString(res));
    }
    public static int findIndexOfZero(int[] arr){
        int index=arr.length;
        int start=0, end=arr.length-1,mid=start+((end-start)/2);

        //if no 1's present, return idex as zero
        if(arr[0]==0)
            return 0;

        while (start<=end){
            if(arr[mid]==0 && mid>0 && arr[mid-1]!=0) {
                //System.out.println("Index : "+mid);
                return mid;
            }
            else if(arr[mid]==1)
                start=mid+1;
            else end=mid-1;
            mid=start+((end-start)/2);
        }

        return index;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int k = 3;
        int [][] arr ={{1,0},{0,0},{1,0}};
        int k1=2;
        kWeakestRowsInAMatrix(mat,k);
        kWeakestRowsInAMatrix(arr,k1);
    }
}