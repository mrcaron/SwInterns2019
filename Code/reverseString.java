import java.util.*;
public class reverseString 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);        //scanner class to input
        System.out.println("Enter a string:");     
        String str = sc.nextLine();                   //input a string
        if(str.length() == 0)
            {
                System.out.println("Enter a string of length greater than 0");
                System.exit(0);
            }
        StringBuilder s = new StringBuilder();      //String Builder class to play with strings
        s = s.append(str).reverse();                //append the string to string builde variable s, reverse it
        
        System.out.println("Reversed String:" +s);  // s is of type StringBuilder,  we can convert to string by: s.toString();
    }
}
/*
Time Complexity: O(n)
Space Complexity: O(n)  // size of the string
*/