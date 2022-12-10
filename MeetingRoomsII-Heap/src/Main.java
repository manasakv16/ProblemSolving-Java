import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Interval {
    private int s;
    private int e;

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public Interval(){s=0;e=0;}
    public Interval(int s,int e){
        this.s=s;
        this.e=e;
    }
    public static void printInterval(Interval[] intervals){
        for (Interval x : intervals){
            System.out.print(x.getS() +" - "+x.getE());
            System.out.print(" , ");
        }
        System.out.println();
    }

}

public class Main {
    public static int meetingRooms(Interval[] arr){
        //print input
        Interval.printInterval(arr);

        if(arr.length==0)
            return 0;

        //sort array based on start time
        Arrays.sort(arr,new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getS()-o2.getS();
            }
        });

        //Sort heap based on end time
        PriorityQueue<Interval> minh = new PriorityQueue<Interval>(arr.length, new Comparator<Interval>(){
            @Override
            public int compare (Interval a, Interval b) {return a.getE() - b.getE();}
        });
        minh.add(arr[0]);
        for (int i=1;i< arr.length;i++){
            if(minh.peek().getE()<=arr[i].getS()){
                Interval interval = new Interval(minh.poll().getS(),arr[i].getE());
                minh.add(interval);
            }
            else minh.add(arr[i]);
        }
        return minh.size();

    }
    public static Interval[] setInput(int[][] a){
        Interval[] arr = new Interval[a.length];
        for (int i=0;i< arr.length;i++){
            arr[i] = new Interval(a[i][0],a[i][1]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] a={{0, 30},{5, 10},{15, 20},{1,2},{10,15},{20,100}};
        int[][] b =  {{7,10},{2,4}};
        Interval[] arr = setInput(a);
        Interval[] brr = setInput(b);

        System.out.println(meetingRooms(arr));
        System.out.println(meetingRooms(brr));
    }
}