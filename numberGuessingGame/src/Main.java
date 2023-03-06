import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class Main {
    public static int check(int num){

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if(input==num)
            return 0;
        if(input<=num+5 && input>=Math.abs(num-5))
            return 16;
        if(Math.abs(input-num)<=10 && input>num)
            return 2;
        if(Math.abs(input-num)<=10 && input<num)
            return -2;
        if(Math.abs(input-num)>=11 && input>num)
            return 1;
        if(Math.abs(input-num)>=11 && input<num)
            return -1;
        return -100;
    }
    public static void game(){
        Random random = new Random();
        int tries = 10;
        boolean flag=true;
        int num = random.nextInt(0,100);
        System.out.println("select a random number between 0 to 100");
        while (tries > 0 && flag) {
            int result = check(num);
            if(result==0){
                System.out.println("Yayyy, you guessed the right number in "+Math.abs(10-tries)+" tries");
                flag=false;
            }
            if(result==16) System.out.println("You're soooooooo close");
            else if(result==2) System.out.println("Little high, try again");
            else if (result==-2) System.out.println("Little low , try again");
            else if(result==1) System.out.println("Toooooo high, try again");
            else if (result==-1) System.out.println("Toooooo low , try again");
            tries--;
            System.out.println("Tries left "+tries);
            System.out.println();
        }
        if(flag) {
            System.out.println("The number was "+num);
            System.out.println("Better luck next time :( ");
        }

    }
    public static void game(int start,int end){
        System.out.println("select a random number between "+start+" to "+end);
        Random random = new Random();
        int tries = 10;
        boolean flag=true;
        int num = random.nextInt(start,end);
        while (tries > 0 && flag) {
            int result = check(num);
            if(result==0){
                System.out.println("Yayyy, you guessed the right number in "+Math.abs(10-tries)+" tries");
                flag=false;
            }
            if(result==16) System.out.println("You're soooooooo close");
            else if(result==2) System.out.println("Little high, try again");
            else if (result==-2) System.out.println("Little low , try again");
            else if(result==1) System.out.println("Toooooo high, try again");
            else if (result==-1) System.out.println("Toooooo low , try again");
            tries--;
            System.out.println("Tries left "+tries);
            System.out.println();
        }
        if(flag) {
            System.out.println("The number was "+num);
            System.out.println("Better luck next time :( ");
        }

    }

    public static void main(String[] args) {

        System.out.println("Welcome to Number guessing game");
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Press 1 to play");
            System.out.println("---------------------------------------------------------------------------------");
            int input = in.nextInt();
            if (input == 1) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("You have chosen to play");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Press 1 for default range : 0 - 100");
                System.out.println("Press 2 to select custom range");
                System.out.println("---------------------------------------------------------------------------------");

                if(in.nextInt()==1)
                    game();
                else {
                    while (true) {
                        System.out.println("Enter the starting range");
                        System.out.println("---------------------------------------------------------------------------------");
                        int start = in.nextInt();
                        System.out.println("---------------------------------------------------------------------------------");
                        System.out.println("Enter the ending range");
                        System.out.println("---------------------------------------------------------------------------------");
                        int end = in.nextInt();
                        if (Math.abs(start - end) >= 10) {
                            game(start, end);
                            break;
                        }
                        else {
                            System.out.println("Invalid range given");
                            System.out.println("There should be at least 10 numbers in between start and ending range");
                            System.out.println("Please try again");
                            System.out.println("---------------------------------------------------------------------------------");
                        }
                    }
                }
            }
            else System.out.println("Invalid option, please try again");
        }
    }
}