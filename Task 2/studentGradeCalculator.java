import java.util.Scanner;

public class studentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of Subjects: ");
        int totSubject = sc.nextInt();
        int[] marks = new int[totSubject];
        int sum=0;
        for(int i=0;i<totSubject;i++){
            System.out.print("Enter marks of Subject "+(i+1)+": ");
            marks[i]=sc.nextInt();
            sum+=marks[i];
        }
        float percentage= (float) sum /totSubject;
        String grade="";
        if(percentage>=90)
            grade="A+";
        else if(percentage>=80)
            grade="A";
        else if(percentage>=70)
            grade="B";
        else if(percentage>=60)
            grade="C";
        else if(percentage>=50)
            grade="D";
        else
            grade="E";
        
        System.out.println("Total marks: "+sum);
        System.out.println("Percentage Obtained: "+percentage+" %");
        System.out.println("Grade: "+grade);

        sc.close();
    }
}
