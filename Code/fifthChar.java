import java.util.*;
public class fifthChar 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);        //scanner class to input
        System.out.println("Enter a string:");     
        String str;
        while(true)
        {
            str = sc.nextLine();                   //input a string
            if(str.length() <= 5)
            {
                System.out.println("Enter a string of length greater than 5");
            }
            else
                break;
        }
        
        System.out.println("Fifth Character:" +str.charAt(4));
    }
}
/*
Time Complexity: O(1)
Space Complexity: O(1)
*/