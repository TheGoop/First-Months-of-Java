
/**
 * Write a description of class GPA here.
 * 
 * @author (Akshay Gupta) 
 * @version (9/19/21)
 */
import java.util.*;
public class GPA
{
    public static void main (String [] args)
    {
       System.out.println("What's your name?");
       Scanner nameScan = new Scanner(System.in);
       String name = nameScan.nextLine();
       
       System.out.println("Enter in 5 of your grades on separate lines " + name + ".");
       Scanner scan = new Scanner(System.in);
       int a = scan.nextInt();
       int b = scan.nextInt();
       int c = scan.nextInt();
       int d = scan.nextInt();
       int e = scan.nextInt();
       
       int add = a + b + c + d + e;
       int gpa = (int) (add / 5);
       
       boolean x = true;
       
       System.out.println("Your GPA is about " + gpa + ".");
       
       if (gpa >= 90)
        {
            System.out.println("So, you got an A");
        }
       else
        {
            if (gpa >= 80)
            {
                System.out.println("So, you got a B");
            }
            else
            {
                if (gpa >= 70)
                {           
                    System.out.println("So, you got a C");
                }
                else
                  {
                     if (gpa >= 65)
                     {           
                         System.out.println("So, you got a D");
                     }
                     else
                     {
                             System.out.println("So, you got an F");
                     }
                  }
            }
         }   
    }
}       

    

