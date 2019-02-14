import java.util.*;
public class interview_questions
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);        //scanner class to input
        while(true)
        {
            System.out.println("\n1.Check if a string is Palindrome or not\n2.Split a string into parts based off a given character\n3.Find the 5th character of a string that has length > 5");
            System.out.println("4.Reverse a string\n5.crash your program\n");
            int mode = sc.nextInt();
            switch(mode)
            {
            case 1: isPalindrome();
                    break;
            case 2: splitString();
                    break;
            case 3: fifthChar();
                    break;
            case 4: reverseString();
                    break;
            case 5: crash();
                    break;
            default: System.out.println("\nEnter valid mode 1-5.\n");
                    break;
            }
            
            System.out.println("\nDo you wish to try once more[y/n] ?");
            while(true)
            {
                char ch=sc.next().charAt(0);
                if(ch=='n' || ch=='N')
                    System.exit(0);
                else if(ch=='y' || ch=='Y')
                    break;
                else
                    System.out.println("\nEnter valid \"y\" or \"n\"");
            }
        }
    }
    
    public static void isPalindrome()
    {
        Scanner sc = new Scanner(System.in);        //scanner class to input
        System.out.println("\nEnter a string:");      
        String s = sc.nextLine();                   //input a string
        int n = s.length();
        if(n==0)
        {
            System.out.println("\nEnter a valid string of length greater than 0");
            System.exit(0);
        }
        for (int i = 0; i < n/2; ++i)             //traverse through half the string 
        {
            if (s.charAt(i) != s.charAt(n - i - 1))         //compare the ends and keep coming towards mid of the string
            {
                System.out.println("\nString " +s+ " is not palindrome.");
                return;
            }
        }
        System.out.println("\nString " +s+ " is palindrome.");
    }
    
    public static void splitString()
    {
        Scanner sc = new Scanner(System.in);        //scanner class to input
        System.out.println("Enter a string:");      
        String str = sc.nextLine();                   //input a string
        int n = str.length();                         //string length
        if(n == 0)
        {
            System.out.println("\nEnter a valid string of length greater than 0");
            return;    
        }
        String ch;
        while(true)
        {
            System.out.println("\nEnter a single character:");
            ch = sc.nextLine();                   //input a character
            if(ch.length()==1)
                break;
        }
        String split[] = str.split(ch, 0);        //split all occurrences of the character and store it in a string array

        if(split.length == 1)
        {
            System.out.println("\nCharacter not found.");
            return;
        }
        System.out.println("\nSplit Strings: ");
        for(String i: split)
            System.out.println(i);
    }
    
    public static void fifthChar()
    {
        Scanner sc = new Scanner(System.in);        //scanner class to input
        System.out.println("\nEnter a string:");     
        String str;
        while(true)
        {
            str = sc.nextLine();                   //input a string
            if(str.length() <= 5)
            {
                System.out.println("\nEnter a string of length greater than 5");
            }
            else
                break;
        }

        System.out.println("\nFifth Character:" +str.charAt(4));
    }
    
    public static void reverseString()
    {
        Scanner sc = new Scanner(System.in);        //scanner class to input
        System.out.println("\nEnter a string:");     
        String str = sc.nextLine();                   //input a string
        if(str.length() == 0)
            {
                System.out.println("\nEnter a string of length greater than 0");
                return;
            }
        StringBuilder s = new StringBuilder();      //String Builder class to play with strings
        s = s.append(str).reverse();                //append the string to string builde variable s, reverse it

        System.out.println("\nReversed String:" +s);  // s is of type StringBuilder,  we can convert to string by: s.toString();
    }
    
    public static void crash()
    {
        System.out.println("\nYour program will crash out of heap memory....");
        Object[] obj = null;
            while(true)                 //out of memory
            {
                Object[] obj1 = new Object[1];
                obj1[0] = obj;
                obj = obj1;
            }

        /*
        while(true)                                     //simple infinte loop
        {
            System.out.println("Infinite Loop");
        }
        */

        /*
        
        main(args); //Stack over flow error
        
        */
    }
}
