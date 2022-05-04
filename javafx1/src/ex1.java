import java.util.Scanner;

//20BCE2126
//Vedant Modi
public class ex1 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int opt=0 ;
        int correct =0;
        int incorrect = 0;
        while (opt!=3) {
            System.out.println("1->True\n2->Faalse\n3->Exit");
            System.out.println("Enter Option : ");
            opt = input.nextInt();
            if(opt==1)
            {
                correct++;
            }
            else
            {
                incorrect++;
            }
        }
        System.out.println("Total Number of Correct submissions  : " + correct);
        System.out.println("Total Number of Incorrect submissions : " + incorrect);
    }
}
