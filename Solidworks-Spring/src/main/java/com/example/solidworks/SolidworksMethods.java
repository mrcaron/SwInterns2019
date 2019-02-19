package com.example.solidworks;


public class SolidworksMethods {
	/*
	 * Checks whether a given string is palindrome
	 * a palindrome string is one which is equal to its
	 * reverse: eg. mom, malayalam
	 */
	public boolean isPalindrome(String str) {
		String reverse="";
		for(int i = (str.length()-1);i>=0;i--) {
			reverse+=str.charAt(i);
		}
		return str.equals(reverse);
	}
	/*
	 * splits the given string according to given character
	 * 
	 */
	public String[] stringSplit(String str,String c) {
		return str.split(c);
	}
	/*
	 * return the fifth character of the given string if sizee
	 * of string is greater than 5 else ' ' 
	 */
	public char fifthChar(String str) {
		return (str.length()>5? str.charAt(4):' ');
	}
	/*
	 * Returns the reverse of the given string
	 */
	public String reverse(String str) {
		String reverse="";
		for(int i = (str.length()-1);i>=0;i--) {
			reverse+=str.charAt(i);
		}
		return reverse;
	}
	/*
	 * This method does not terminate unless forcefully stopped
	 * Contains an unending loop 
	 */
	public void crash() {
		while(true) {
			;
		}
	
	}
	/*
	 * A main method to test all our methods
	 */
	public static void main(String [] args) {
		
		
	}
	/*
	 * An object of Candidate represents a candidate 
	 * having two attributes as name and age
	 * To create an object: new Candidate (name,age);
	 */
	private class Candidate{
		private String name;
		private int age;
		Candidate(String name, int age){
			this.name=name;
			this.age=age;
		}
		/*
		 * prints the attributes of the candidate object in 
		 * JSON format
		 */
		void printCandidate() {
			System.out.println("{"+"\"name\":\""+name+"\",\"age\":"+age+"}");
			
		}
		
	}	
}
