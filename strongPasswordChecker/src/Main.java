import java.util.Scanner;

public class Main {
    public static int validLength(String password){
        if(password.length()>=6 && password.length()<=20)
            return 0;
        else if(password.length()<6) return (6-password.length());
        else return (20-password.length());
    }
    public static boolean validLowercase(String password){
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)>=97 && password.charAt(i)<=122){
                return true;}
        }
        return false;
    }
    public static boolean validUppercase(String password){
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)>=65 && password.charAt(i)<=90){
                return true;}
        }
        return false;
    }
    public static boolean validDigit(String password){
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)>=48 && password.charAt(i)<=57)
                return true;
        }
        return false;
    }
    public static int repeatedChars(String password){
        int count=0,chars=0;
        for(int i=0;i<password.length()-1;i++){
            if(password.charAt(i)==password.charAt(i+1)){
                count+=1;
            } else {
                count=0;
            } if(count==2){
                chars++; count=0; i++;
            }
        }
        return chars;
    }
    public static int strongPasswordChecker(String password) {
        int length = validLength(password);
        boolean lower = validLowercase(password);
        boolean higher = validUppercase(password);
        boolean digit = validDigit(password);
        int chars = repeatedChars(password);
        if(length==0 && lower && higher && digit && (chars==0))
            return 0;
        int res=0,count=0;
        if(length>0) {
            res = length + chars;
            count = res;
        }
        else {
            res = Math.abs(length) + chars;
            count = chars;
        }
        if(!higher){
            if(count>0)
                count--;
            else res++;
        }
        if(!lower){
            if(count>0)
                count--;
            else  res++;
        }
        if(!digit){
            if(count>0)
                count--;
            else res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Enter password: ");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            System.out.println("password status = "+strongPasswordChecker(in.nextLine()));
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Enter password");
        }
    }
}