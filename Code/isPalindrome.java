import java.util.*;
public class isPalindrome 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);        //scanner class to input
        System.out.println("Enter a string:");      
        String s = sc.nextLine();                   //input a string
        int n = s.length();
        if(n==0)
        {
            System.out.println("Enter a valid string of length greater than 0");
            System.exit(0);
        }
        for (int i = 0; i < n/2; ++i)             //traverse through half the string 
        {
            if (s.charAt(i) != s.charAt(n - i - 1))         //compare the ends and keep coming towards mid of the string
            {
                System.out.println("String " +s+ " is not palindrome.");
                System.exit(0);
            }
        }
        System.out.println("String " +s+ " is palindrome.");
        System.exit(0);
    }
}
/*
Time Complexity: O(n)
Space Complexity: O(1)
*/