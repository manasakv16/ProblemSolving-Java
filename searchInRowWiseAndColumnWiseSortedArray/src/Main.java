import java.util.Arrays;
class Pair{
    private int num1,num2;

    public Pair(){}
    public Pair(int num1, int num2){
        this.num1=num1;
        this.num2=num2;
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
}

public class Main {
    public static Pair searchInRowWiseAndColumnWiseSortedArray(int[][] arr,int num){
        System.out.println(); //System.out.println("Input = "+ Arrays.toString(arr));
        int i=0, j= arr[0].length-1;
        try{
            while(true){
                if(arr[i][j]==num)
                    return new Pair(i,j);
                else if(arr[i][j]>num)
                    j--;
                else i++;
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("The given number doesn't exist");
            return new Pair(-1,-1);
        }
    }
    public static void printResult(Pair p, int num){
        System.out.println("num "+num+" is at index "+p.getNum1()+" "+p.getNum2());
    }

    public static void main(String[] args) {
        int arr[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        int num=50;
        //inputs to test with
        /*
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,10),10);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,20),20);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,30),30);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,40),40);

        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,15),15);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,25),25);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,35),35);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,45),45);

        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,27),27);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,29),29);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,37),37);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,48),48);

        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,32),32);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,33),33);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,39),39);

        */
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,num),num);
        printResult(searchInRowWiseAndColumnWiseSortedArray(arr,16),16);
    }
}