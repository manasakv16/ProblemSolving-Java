public class Main {

    public static long findNum(int n, int s){
        if(n==0)
            return -1;
        long res=9,count=10;
        for(int i=1;i<n;i++){
            res=res*count+9;
        }
        System.out.println("highest num= "+res);
        if(s>res)
            return -1;
        while (res>0){
            //System.out.println("res = "+res);
            String num = String.valueOf(res);
            int sum=0;
            for(int i=0;i<num.length();i++){
                sum+=Integer.parseInt(num.substring(i,i+1));
            }
            if(sum==s)
                return res;
            else {
                int diff = Math.abs(sum-s);
                res=(res-diff);
            }
        }
        res =-1;
        return  res;
    }
    public static void main(String[] args) {
        System.out.println(findNum(1,0));
    }
}