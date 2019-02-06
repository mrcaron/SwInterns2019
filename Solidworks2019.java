/**
 * @author Matt P'ng
 * SOLIDWORKS Solutions
 * 
 */

import java.util.*;
public class Solidworks2019 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int userInput;
		
		while(true){
			printMenu();
			System.out.println("\nPlease input a number between 1-5");
			userInput = sc.nextInt(); 
			
			// Selects functionality based on user input. Prompts users for additional parameters if necessary.
			switch(userInput) {
			
			case 1: 
				System.out.println("Input string to check if it is a palindrome: ");
				String str = sc.next().trim();
				isPalindrome(str);
				break;
			
			case 2:
				System.out.println("Input string to split: ");
				sc.nextLine();
				str = sc.nextLine().trim();
				System.out.println("Input splitting character: ");
				String character = sc.next();
				splitString(str, character);
				break;
				
			case 3:
				str = null;
				while(str == null){
					System.out.println("Input string:");
					str = sc.next();
					
					if(str.length()<5){
						System.out.println("Please input string with at least 5 characters.");
						str = null;
					}
				}
				
				System.out.println("The 5th character of the string" +" '" + str + "' " + "is " + str.charAt(4));
				break;
			case 4:
				System.out.println("Input string to reverse: ");
				str = sc.next().trim();
				reverseString(str);
				break;
				
			case 5:
				System.exit(0);
				break;
			}
		}	
	}


	/**
	 * Checks if a user input string is a palindrome. This method is non-case sensitive.
	 * 
	 * @param String user input string to check
	 */
	private static void isPalindrome(String forwardStr) {
		forwardStr = forwardStr.toLowerCase();

		String reversedStr = new StringBuilder(forwardStr).reverse().toString();
		boolean isPalindrome = (forwardStr.equals(reversedStr)); // Compare original string to reversed string

		if(isPalindrome){
			System.out.println("Input string " + forwardStr + " IS a palindrome.\n");
		}else{
			System.out.println("Input string " + forwardStr + " IS NOT a palindrome.");
			System.out.println("	Forward string: " + forwardStr);
			System.out.println("	Reversed string: " + reversedStr +"\n");
		}
		
		return;
	}
	
	/**
	 * Splits a string based of a given character. This assumes the splitting input character is a string of length = 1.
	 * 
	 * @param String user input string to split
	 * @param character to split string by
	 */
	private static void splitString(String str, String splitChar){
		String[] splitArr = str.split(splitChar);
		
		if(splitChar.length() > 1){
			System.out.println("Warning: Please input a splitting character (length=1).");
		}
		
		System.out.println("Printing string subpieces.");
		String out = "";
		for (String part: splitArr){
			out += (part+"-");
		}
		
		out = out.substring(0, out.length()-1); // Gets rid of final dash
		System.out.println(out);
		
		System.out.println("\n");
		return; 
	}
	
	/**
	 * Checks if a user input string is a palindrome. 
	 * 
	 * @param String user input string to reverse
	 */
	private static void reverseString(String forwardStr){
		String reversedStr = new StringBuilder(forwardStr).reverse().toString();
		System.out.println("Forward string: " + forwardStr);
		System.out.println("Reversed string: " + reversedStr +"\n");
		return;
	}
	
	/**
	 * Prints main user menu to display program functionality.
	 */
		private static void printMenu(){
			System.out.println("Choose functionality: ");
			System.out.println("1 Check if a String is a palindrome or not");
			System.out.println("2 Split a string into parts based off a given character");
			System.out.println("3 Find the 5th character of a string that has length > 5");
			System.out.println("4 Reverse a string");
			System.out.println("5 Crash the program");
			return;
		}

}
