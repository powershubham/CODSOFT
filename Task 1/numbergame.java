import java.util.Random;
import java.util.Scanner;
public class numbergame{

    public static void playround(int lower, int upper, int maxattempts){
        Random ran=new Random();
        int generattenum=ran.nextInt(upper-lower+1)+lower;
        Scanner sc=new Scanner(System.in);
        int attempts=0;
        boolean guesscorrectly=false;
        System.out.println("Random number has been generated between "+lower+" and "+upper+". Try to guss it!");
        while(attempts<maxattempts && !guesscorrectly){
            System.out.println("Enter your number: ");
            int usernumber=sc.nextInt();
            attempts++;
            if(usernumber<generattenum){
                System.out.println("Your guss us too low.");
            }else if(usernumber>generattenum){
                System.out.println("your guss is too high.");
            }else{
                guesscorrectly=true;
                System.out.println("Congratulations! You have successfully generated "+usernumber+" number!");
            }
        }

        if(!guesscorrectly){
            System.out.println("Sorry! Yo've used all of your attempts. Correct answer is "+generattenum);
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int rounds=0;
        int lower=1;
        int upper=100;
        int maxattempt=10;

        while(true){
            playround(lower, upper, maxattempt);
            rounds++;
            System.out.println("Want to play more rounds? (y/n)");
            String pa=sc.next();
            if(!pa.equalsIgnoreCase("y")){
                break;
            }
        }

        System.out.println("You played "+rounds+" rounds. Thanks for playing!!");
        sc.close();
    }
}