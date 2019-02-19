/**
 * @author Soham Dasgupta
 * @class All_Solutions - Solutions to problems for SOLIDWORKS 2019 Internship
 */
import java.util.*;

public class All_Solutions{
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	    System.out.println("---------------------"
	    		+ "\n1. Check for palindrome"
	    		+ "\n2. Split string by character"
	    		+ "\n3. Find 5th character"
	    		+ "\n4. Reverse string"
	    		+ "\n5. Print JSON object"
	    		+ "\n6. Crash program"
	    		+ "\n7. Exit nicely"
	    		+ "\n---------------------");
	    
	    Scanner sc = new Scanner(System.in);
	    int response = 0;
	    
	    try {	    	
	    	response = sc.nextInt();
	    }
	    catch(InputMismatchException e)
	    {	
	    	System.out.println("Please enter an integer.");
	    	main(args);
	    }
	    
	    sc.nextLine();

	    switch(response) {
		    case 1:
		    	System.out.println("Enter a string to check if it is a palindrome: ");
		    	String toCheck = sc.nextLine();
		    	
		    	String ans = isPalindrome(toCheck)? "That is a palindrome." : "That is not a palindrome.";
		    	System.out.println(ans);
		    	break;
		    case 2:
		    	System.out.println("Enter a string: ");
		    	String toSplit = sc.nextLine();
		    	System.out.println("What should the string be split by?");
		    	String delimiter = sc.nextLine();
		    	
		    	String[] splitted = splitString(toSplit, delimiter);
		    	
		    	System.out.println("The splitted string: ");
		    	
		    	for(String piece : splitted)
		    		System.out.println(piece);
		    	break;
		    case 3:
		    	System.out.println("Enter a string: ");
		    	String findFifth = sc.nextLine();
		    	if(findFifth.length() <= 5)
		    		System.out.println("This string does not have length > 5.");
		    	else
		    		System.out.println("Fifth character: "+findFifth.charAt(4));
		    	break;
		    case 4:
		    	System.out.println("Enter a string: ");
		    	System.out.println(new StringBuilder(sc.nextLine()).reverse().toString());
		    	break;
		    case 5:
		    	System.out.println("Enter attribute 1: ");
		    	String att1 = sc.nextLine();
		    	System.out.println("Enter attribute 2: ");
		    	String att2 = sc.nextLine();
		    	
		    	printJSON(att1,att2);
		    	break;
		    case 6:
		    	int x = 0/0;
		    case 7:
		    	System.exit(0);
		    default:
		    	System.out.println("Invalid entry (must be # between 1 and 7)");
		    	break;
	    }
	    
	    main(args);
	}
	
	/**
	 * 
	 * @param phrase - the string to be checked to see if it is a palindrome
	 * @return True if the string is a palindrome, False otherwise
	 */
	public static boolean isPalindrome(String phrase)
	{
		//remove non alphanumeric chars
		phrase = phrase.replaceAll("[^A-Za-z0-9]","");
		//remove spaces
		phrase = phrase.replaceAll(" ","");

		String reversedPhrase = new StringBuilder(phrase).reverse().toString();
		return reversedPhrase.equalsIgnoreCase(phrase);
	}
	
	/**
	 * 
	 * @param str - string to be split
	 * @param splitter - expression by which to split the string
	 * @return an array of seperated strings
	 */
	public static String[] splitString(String str, String splitter)
	{
		return str.split(splitter);
	}
	
	/**
	 * 
	 * @param a1 - first attribute
	 * @param a2 - second attribute
	 */
	public static void printJSON(String a1, String a2)
	{
		System.out.println("{\n\t\""+a1+"\": {},");
		System.out.println("\n\t\""+a2+"\": {}\n}");
	}

}