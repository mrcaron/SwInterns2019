/*
 * Just run the file like a normal java file
 * if you are using eclipse ;
 * If you are running this java file using terminal,
 * compile the java file first to create a .class file
 * before running
 * 
 */
public class ProgrammingAssignment {
	/*
	 * Checks whether a given string is palindrome
	 * a palindrome string is one which is equal to its
	 * reverse: eg. mom, malayalam
	 */
	public static boolean isPalindrome(String str) {
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
	public static String[] stringSplit(String str,String c) {
		return str.split(c);
	}
	/*
	 * return the fifth character of the given string if sizee
	 * of string is greater than 5 else ' ' 
	 */
	public static char fifthChar(String str) {
		return (str.length()>5? str.charAt(4):' ');
	}
	/*
	 * Returns the reverse of the given string
	 */
	public static String reverse(String str) {
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
	public static void crash() {
		while(true) {
			;
		}
	
	}
	/*
	 * A main method to test all our methods
	 */
	public static void main(String [] args) {
		for(String str:args) {
			System.out.println(str +"is palindrome?"+isPalindrome(str));
			System.out.println("reverse of"+str+":"+reverse(str));
			System.out.println("fifth character of"+str+":"+fifthChar(str));
			System.out.println(str+"split by space:"+stringSplit(str," ")[0]);
			
			Candidate sandip = new Candidate(str,27);
			sandip.printCandidate();
		}
		System.out.println("Sandip" +"is palindrome?"+isPalindrome("Sandip"));
		System.out.println("reverse of"+"Sandip"+":"+reverse("Sandip"));
		System.out.println("fifth character of"+"Sandip"+":"+fifthChar("Sandip"));
		System.out.println("Sandip"+"split by space:"+stringSplit("Sandip"," ")[0]);
		
		Candidate sandip = new Candidate("Sandip",27);
		sandip.printCandidate();
		
		
		
	}
	/*
	 * An object of Candidate represents a candidate 
	 * having two attributes as name and age
	 * To create an object: new Candidate (name,age);
	 */
	private static class Candidate{
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
