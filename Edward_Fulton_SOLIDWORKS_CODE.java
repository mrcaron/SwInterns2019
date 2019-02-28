import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Edward_Fulton_SOLIDWORKS_CODE {

	public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		/* I apologize for not commenting my code properly. I was
		 * under some time pressure with some commitments in my 
		 * academic program (I am studying abroad in Singapore so am a bit disconnected! 
		 * I will still be in Madison and available to work this summer!).
		 * This program completes all of the desired specifications you asked for plus a few fun 
		 * easter eggs! Enjoy!
		*/
		
		Scanner scnr = new Scanner(System.in);
		System.out.println("Welcome to my Program! Excited to talk about this thing with y'all!");
		Thread.sleep(1000);
		while(true){
			System.out.println("What would you like to do?");
			Thread.sleep(1000);
			System.out.println("Enter 1 to check if a string is palindrome or not \nEnter 2 to Split a string into "
					+ "parts based on a given character \nEnter 3 to Find the 5th character of a string that has "
					+ "length > 5 \nEnter 4 to Reverse a string \nEnter 5 to Print out a JSON object that has "
					+ "two attributes");
			int value = -69;
			while(value < 1 || value > 5 ) {
				value = -69;
				try{
					value = scnr.nextInt();
				}
				catch (InputMismatchException e){
					System.out.println("Enter an actual number please.");
					scnr.next();
				} 
				if ((value < 1 || value > 5 ) && value != -69) {
					System.out.println("Please enter a number between 1 and 5");
				}
					System.out.println();
			}	
			
			switch(value) {
			
			case 1: 
				System.out.println("What string would you like to check?");
				String possiblePalindrome = scnr.next().trim();
				String reverse = "";
				for(int i = possiblePalindrome.length() - 1; i >= 0; i--)
		        {
		            reverse = reverse + possiblePalindrome.charAt(i);
		        }
				if (possiblePalindrome.equals(reverse)) {
					System.out.println(possiblePalindrome + " is a Palindrome!");
				}
				else {
					System.out.println(possiblePalindrome + " is not a Palindrome. Sorry.");
				}
				System.out.println();
				Thread.sleep(1000);
				break;
			
			case 2:
				System.out.println("What string would you like to split?");
				String guillotineString = scnr.next().trim();
				System.out.println("At what character would you like to split (Enter ONLY ONE character)");
				char c = scnr.next().charAt(0);
				String neck = String.valueOf(c);
				String[] arrayOfHeads = guillotineString.split(neck);
				System.out.println("Newly split pieces:");
				for (String head : arrayOfHeads){
		            System.out.println(head); 
				}
				System.out.println();
				Thread.sleep(2000);
				break;
				
			case 3:
				System.out.println();
				System.out.println("What string would you like me to analyze?");
				String spoon = scnr.next();
				if (spoon.length() < 5) {
					Thread.sleep(3000);
					System.out.print("*in matrix kid voice*");
					Thread.sleep(2000);
					System.out.println(" Try to realize the truth...");
					Thread.sleep(2000);
					System.out.println(" There is no fifth character.");
					Thread.sleep(2000);
					System.out.print(" Then you wil see it is not the character that prints.");
					Thread.sleep(3000);
					System.out.println(" It is only yourself :).");
				
				}
				else{
					System.out.println("The fifth chaacter in this string is: " + spoon.charAt(4));
				}
				System.out.println();
				Thread.sleep(2000);
				break;
				
			case 4:
				System.out.println("What would you like me to reverse?");
				String mirror = scnr.next();
				reverse = "";
				for(int i = mirror.length() - 1; i >= 0; i--)
		        {
		            reverse = reverse + mirror.charAt(i);
		        }
				System.out.println("The reverse of " + mirror + " is " + reverse + ".");
				System.out.println();
				Thread.sleep(2000);
				break;
				
				
			case 5:
				System.out.println("Well this is awkward. My computer was having trouble installing "
						+ "the JSON simple package to use with Java so I'm just gonna make some pseudo JSON objects for you!");
				Thread.sleep(2000);
				System.out.println();
				System.out.println("So what would you like your object's first attribute to be?");
				String attribute1Title = scnr.next();
				System.out.println("And what is this object's " + attribute1Title + "?");
				String attribute1 = scnr.next();
				System.out.println("Got it!");
				Thread.sleep(1000);
				System.out.println("So what would you like your object's next attribute to be?");
				String attribute2Title = scnr.next();
				System.out.println("And what is this object's " + attribute2Title + "?");
				String attribute2 = scnr.next();
				System.out.println("Printing your poor man's JSON object:");
				System.out.println("{'" + attribute1Title + "': " + attribute1 + ", '" + attribute2Title 
						+ "': " + attribute2 + "}");
				System.out.println();
				Thread.sleep(2000);
						break;
						
			}
			System.out.println("What would you like to do now? \nEnter 1 to do something else. Enter 2 to crash my program.");
			int operation = scnr.nextInt();
			while (!(operation == 1 || operation == 2)) {
				System.out.println("Please either enter 1 or 2");
			}
			if (operation == 1) {
				System.out.println("Great!");
				System.out.println();
				Thread.sleep(1000);
			}
			else{
				System.out.println("ARE YOU SURE YOU WANT TO CRASH?");
				System.out.println("Enter 'yes' or 'no'");
				String answer1 = scnr.next();
				while (!(answer1.equals("yes") || answer1.equals("no"))) {
					System.out.println("Please either enter 'yes' or 'no'");
					answer1 = scnr.next();
				}
				if (answer1.equalsIgnoreCase("yes")) {
					System.out.println("ARE YOU REALLY SURE YOU WANT TO CRASH?");
					System.out.println("Enter 'yes' or 'no'");
					String answer2 = scnr.next();
					while (!(answer2.equals("yes") || answer2.equals("no"))) {
						System.out.println("Please either enter 'yes' or 'no'");
						answer2 = scnr.next();
					}
					if (answer2.equalsIgnoreCase("yes")) {
						System.out.println("Fine.");
						Thread.sleep(2000);
						System.out.println(":(");
						Thread.sleep(2000);
						System.out.println("Hope you liked my simple program!");
						Thread.sleep(2000);
						Desktop d = Desktop.getDesktop();
						scnr.close();
						d.browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
						System.exit(0);
					}
					else {
						System.out.println("Thank God. you had me worried there.");
						System.out.println();
					}

				}
				else {
					System.out.println("Very Responsible Decision");
					Thread.sleep(1000);
					System.out.println();
				}
				
			}
			
		}	
	}
		
		

}

