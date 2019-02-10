import java.util.Scanner;

/**
 * Filename:   SwCode.java
 * Project:    SwInterns 2019
 * Authors:    Linda Zhao
 * 
 * This class contains the methods to reverse a string, check if a string is a palindrome,
 * find the 5th character in a string, and split the string into pieces based off of a certain 
 * character, as well as the main method to run and interact with the user.
 */
public class SwCode {
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        //keep looping until the user wants to stop
        while (true) {
            //get user inputs
            System.out.print("Please enter a string that is more than 5 characters long to analyze: ");
            String userStr = scnr.next();  
            //keep asking for a new string if the user does not enter in the correct length of string
            while (userStr.length() <= 5) {
                System.out.print("Enter a string that is longer than 5 characters: ");
                userStr = scnr.next();
            }
            System.out.print("Please also enter a character to split your string: ");
            String splitChar = scnr.next();
            //keep asking for a new character is the user enters a string and not just one character
            while (splitChar.length() > 1) {
                System.out.print("Please enter just one character: ");
                splitChar = scnr.next();
            }
            System.out.print("Your string reversed is " + reverseString(userStr) + ". ");
            
            //check if string is palindrome
            if (isPalindrome(userStr)) {
                System.out.println("Therefore, it is a palindrome.");
            }
            else {
                System.out.println("Therefore, it is not a palindrome.");
            }
            
            System.out.println("The 5th character of your string is " + find5thChar(userStr));
            
            System.out.print("Your string split by " + splitChar + " becomes");
            String[] strArray = splitString(userStr, splitChar);
            //print out the split parts of the string
            for (int i = 0; i < strArray.length; ++i) {
                System.out.print(" " + strArray[i]);
            }
            //determine if the user wants to keep going
            System.out.print(".\nWould you like to analyze another string? Enter yes to continue: ");
            String userInput = scnr.next();
            //user says yes
            if (userInput.charAt(0) == 'y' || userInput.charAt(0) == 'Y') {
                continue;
            }
            else {
                break;
            }
        }
        System.out.println("Thank you for analyzing your string with us.");
    }
    /**
     * Determines if the string passed in is a palindrome.
     * @param: origStr- string that you want to check
     * @return: boolean-true if the string is a palindrome, false otherwise
     */
    private static boolean isPalindrome(String origStr) {
        String reversedStr = reverseString(origStr);
        //check if original string and reversed string are the same
        return reversedStr.equals(origStr);
    }
    
    /*
     * Reverses a string that is passed in.
     * @param: orig-the string to reverse
     * @return: reverse- a string that is the original string reversed
     * */
    private static String reverseString(String orig) {
        String reverse = "";
        //create the reversed string
        for (int i = orig.length() - 1; i >=0; --i) {
            reverse += orig.charAt(i);
        }
        return reverse; 
    }
    /*
     *Splits string into pieces based on a certain character. This assumes that the method calling it
     *checks to make sure that the certain character is just one character and not a string. 
     *@param: origStr- string to split, splitChar- character to split the string by
     *@return: String array that contains the pieces of the split string
     * */
    private static String[] splitString(String origStr, String splitChar) {
        return origStr.split(splitChar);
    }
    
    /*
     * Finds the 5th character in the string. It assumes that the method that is calling it
     * checks to make sure that the string passed in is more than 5 characters long.
     * @param: str- string passed in
     * @return: the 5th character of the string passed in
     * */
    private static String find5thChar(String str) {
        return "" + str.charAt(4);
    } 

}
