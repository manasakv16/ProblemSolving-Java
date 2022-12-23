package com.company;

import java.security.Key;
import java.util.*;

class Pair{
    int num1;
    int num2;
    public Pair(int num1,int num2){
        this.num1=num1;
        this.num2=num2;
    }
}

public class Main {
    //Brute force approach
    public static void maxAreaHistogramBFA(int[] arr){
        System.out.println("input array : "+ Arrays.toString(arr));

        int res=0; int temp=0; int max=0; int temp1=0;
        for (int i=0;i<arr.length;i++){
            temp = arr[i];
            System.out.println(arr[i]);
            for(int j=0;j<arr.length;j++) {
                if (arr[i] <= arr[j]) {
                    res += temp;
                }
                else if(res>0) {
                    temp1 = res;
                    res = 0;
                }
            }
            if(temp1>res)res=temp1;
            if(max<res)
                max=res;

            System.out.println("max = "+max+" res = "+res);
            res=0;
        }
        System.out.println("result = "+max);

    }
    public static int getIndex(int[] arr,int num){
       // System.out.println("finding index of "+num);
        if(num==0) return num;
        if(num==arr.length-1) return num;


        for (int i=0;i<arr.length;i++){
            if(arr[i]==num)
                return i;
        }
        return -1;
    }
    public static void maxAreaHistogram(int[] arr){
        System.out.println("Input = "+Arrays.toString(arr));
        PriorityQueue<Integer> minh = new PriorityQueue<>();
        List<Pair> list = nearestSmallerToLeft(arr);
        Stack<Integer> stack = nearestSmallerToRight(arr);

        for (int i=0;i<arr.length;i++){
            int sum=0,j=0,k=0;
            j = list.get(i).num2;

            if(stack.peek()== -1) {
                k = arr.length; stack.pop();
            }
            else k = getIndex(arr,stack.pop());

            //System.out.println("num = "+arr[i]+" j = "+j+" k = "+k);

           if(j==0 && k==arr.length-1)
               sum= arr.length*arr[i];
           else if(j==0 || k== arr.length-1)
               sum=Math.abs(j-k)*arr[i];
           else sum = (Math.abs(j-k)-1)*arr[i];

           minh.add(sum);

           System.out.println("number & thier sum "+arr[i]+" - "+sum+" , ");
           while (minh.size()>1)
                minh.poll();
           System.out.println();
        }
        System.out.println();
        System.out.println("ouput = "+minh.peek());
    }
    public static Stack<Integer> nearestSmallerToRight(int[] arr){
        Stack<Integer> stalk = new Stack();
        Stack res = new Stack<>();

        //System.out.println(Arrays.toString(arr));

        for(int i=arr.length-1;i>=0;i--){
            //System.out.println(stalk+ " "+res);
            if(stalk.empty())
                res.push(-1);
            else{
                if(stalk.peek()<arr[i])
                    res.push(stalk.peek());
                else {
                    while(!stalk.empty() && stalk.peek()>=arr[i])
                        stalk.pop();
                    if(stalk.empty())
                        res.push(-1);
                    else
                        res.push(stalk.peek());
                }
            }stalk.push(arr[i]);
        }
        System.out.println(" smaller to right,reverse order "+res);
        return res;
    }
    public static List<Pair> nearestSmallerToLeft(int[] arr){
        Stack<Pair> stalk = new Stack(); //Pair<int,int> = <arr[i],i>
        List<Pair> res = new ArrayList<>();

        System.out.println("Input = "+Arrays.toString(arr));

        for(int i= arr.length-1;i>=0;i--) {
            if (stalk.empty())
                res.add(new Pair(arr[i],1));
            else {
                if(stalk.peek().num1>arr[i]) {
                    res.add(new Pair(arr[i],1));
                }
                else{
                    while (!stalk.empty() &&(stalk.peek().num1<=arr[i])) {
                        stalk.pop();
                    }
                    if(!stalk.empty()) {
                        //System.out.println(arr[i] + " " + i + " " + index(arr, stalk.peek()));
                        res.add(new Pair(arr[i],Math.abs(i - stalk.peek().num2)));
                    }
                    else res.add(new Pair(arr[i],1));
                }
            } stalk.push(new Pair(arr[i],i));
            System.out.println("nearest smallest to left of "+arr[i]+" is "+res.get(i).num2+" indices away");
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6} ;// res = 12
        int[] crr = {6,2,5,4,5,4,6}; //res = 20
        int[] brr = {6,2,5,4,5,3,6}; //res=15;
        //maxAreaHistogramBFA(arr);
        //maxAreaHistogram(arr);
        maxAreaHistogram(crr);
        //maxAreaHistogram(brr);
    }
}