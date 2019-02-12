import java.util.*;
public class splitString 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);        //scanner class to input
        System.out.println("Enter a string:");      
        String str = sc.nextLine();                   //input a string
        int n = str.length();                         //string length
        if(n == 0)
        {
            System.out.println("Enter a valid string of length greater than 0");
            System.exit(0);
        }
        String ch;
        while(true)
        {
            System.out.println("Enter a single character:");
            ch = sc.nextLine();                   //input a character
            if(ch.length()==1)
                break;
        }
        String split[] = str.split(ch, 0);        //split all occurrences of the character and store it in a string array
        
        if(split.length == 1)
        {
            System.out.println("\nCharacter not found.");
            System.exit(0);
        }
        System.out.println("Split Strings: ");
        for(String i: split)
            System.out.println(i);
    }
}
/*
Time Complexity: O(n)
Space Complexity: O(n/2) ~= O(n) (for large string lengths)
*/