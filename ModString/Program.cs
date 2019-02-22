using System;
using System.IO;
using System.Collections.Generic;
using System.Text;

namespace ModString
{
    class Program
    {
        private static int DivideLength = 40; //Length of visual line surrounding prompt
        private static char DivideChar = '-'; //Character making the line surrounding prompt

        //Characters to remove while processing words. I am assuming the user wants all other punctuation left in
        private static char[] charsToRemove = new char[] { ' ', '\t', '.', '"', '!', '?'};

        private static bool isPromptShown = true; //Flag used to store visibility status of prompt

        static void Main(string[] args)
        {
            string filePath = UpdateFilePath(); //Get initial file name

            char inputChar;
            do
            {
                //Print prompt and read user's input
                PrintActionPrompt(filePath);
                inputChar = Console.ReadKey().KeyChar;
                WriteLine("");
                inputChar = Char.ToLower(inputChar);
                WriteLine("");

                try //Try block to catch possible File openning exceptions
                {
                    switch (inputChar)
                    {
                        case 'p':
                            RunPalindromeCheck(filePath);
                            break;
                        case 's':
                            RunSplitStringOnChar(filePath);
                            break;

                        case '5':
                            RunFindFifthChar(filePath);
                            break;

                        case 'r':
                            RunReverseString(filePath);
                            break;

                        case 't':
                            isPromptShown = !isPromptShown; //Toggle prompt

                            if (!isPromptShown)
                            {
                                //Warn the user
                                WriteLine("Prompt has been turned off. Use 't' to turn it back on.");
                            }
                            break;

                        case 'f':
                            filePath = UpdateFilePath();
                            break;

                        case 'q':
                            //Exit condition of loop will be met. Do nothing
                            break;

                        default:
                            WriteLine("Unrecognized Command");
                            break;
                    }
                }
                catch (Exception ex)
                {
                    WriteLine(ex.Message); //Show user exception message
                }
                
            } while (inputChar != 'q');
        }

        //Show user current file path and action options
        private static void PrintActionPrompt(string filePath)
        {
            //Create our divider string
            StringBuilder stringBuilder = new StringBuilder(DivideLength);
            stringBuilder.Append(DivideChar, DivideLength);
            
            //Print prompt
            WriteLine(stringBuilder.ToString()); //Line
            WriteLine("");
            Console.Out.Write("Current file path: "); //File path
            WriteLine(filePath);
            WriteLine("");
            if (isPromptShown) //Actions
            {
                WriteLine(" p : Check for palindrome strings");
                WriteLine(" s : Split each string on a given character");
                WriteLine(" 5 : Find 5th character of each string that has length > 5");
                WriteLine(" r : Reverse each string");
                WriteLine(" t : Turn off prompt");
                WriteLine(" f : Change input file path");
                WriteLine(" q : Quit");
            }
            WriteLine(stringBuilder.ToString()); //Line
        }

        //Wrapper method to provide shorter method call and potential output flexibility
        private static void WriteLine(string inputString)
        {
            Console.Out.WriteLine(inputString);
        }

        //Returns whether or not inputString is a palindrome
        private static bool CheckPalindrome(string inputString)
        {
            //Loops through input string and compares each char to it's mirror location across the center of the string
            //Ex: 1,2,3,4,3,2,1 -> Compare 1s, 2s, 3s, and 4s.
            for (int i = 0; i < inputString.Length / 2; i++)
            {
                if (inputString[i] != inputString[(inputString.Length - 1) - i])
                {
                    //If 2 characters don't match, the inputString is not a palindrome
                    return false;
                }
            }
            //If all chars match, inputString is a palindrome
            return true;
        }

        //Checks each word from the file at filePath with CheckPalindrome and prints results
        private static void RunPalindromeCheck(string filePath)
        {
            //Open file
            using (StreamReader sr = File.OpenText(filePath))
            {
                List<string> palindromeList = new List<string>(); //Container for palindromes
                string currentLine;
                while ((currentLine = sr.ReadLine()) != null) //Read each line
                {
                    //Split the line on spaces while removing unwanted punctuation
                    string[] wordArray = currentLine.Split(charsToRemove, StringSplitOptions.RemoveEmptyEntries); //TODO add more puncuation
                    //Check each word
                    foreach (string word in wordArray) {
                        if (CheckPalindrome(word))
                        {
                            palindromeList.Add(word);
                        }
                    }
                }

                //Print the results
                if (palindromeList.Count == 0)
                {
                    WriteLine("This file contains no palindromes");
                }
                else
                {
                    WriteLine("This file's palindromes:");
                    foreach (string word in palindromeList)
                    {
                        WriteLine(" " + word);
                    }
                }
            }
            WriteLine(""); //Add space
        }

        //Splits each word on a user-specified char and prints the results
        private static void RunSplitStringOnChar(string filePath)
        {
            //Prompt user for a character and record their input
            Console.Out.Write("Enter character to split text on: ");
            char splitChar = Console.ReadKey().KeyChar;
            WriteLine("");

            WriteLine("File split on '" + splitChar + "':"); //Label results

            //Open file
            using (StreamReader sr = File.OpenText(filePath))
            {
                string currentLine;
                while ((currentLine = sr.ReadLine()) != null) //Read each line
                {
                    //Seperate each word and remove unwanted punctuation
                    string[] wordArray = currentLine.Split(new char[] {splitChar, ' '}, StringSplitOptions.RemoveEmptyEntries);

                    //Print the results
                    foreach (string phrase in wordArray)
                    {
                        Console.Out.Write(" " + phrase);
                    }
                    WriteLine(""); //Seperate each line
                }
            }
        }

        //Finds the 5th character of all strings length > 5 in the file at filePath and prints the results
        private static void RunFindFifthChar(string filePath)
        {
            WriteLine("Every 5th character in every word longer than 5 characters:"); //Label results

            //Open file
            using (StreamReader sr = File.OpenText(filePath))
            {
                string currentLine;
                while ((currentLine = sr.ReadLine()) != null) //Read each line
                {
                    //Seperate each word and remove unwanted punctuation
                    string[] wordArray = currentLine.Split(charsToRemove, StringSplitOptions.RemoveEmptyEntries);

                    //Find and print 5th char of each word in wordArray
                    foreach (string word in wordArray)
                    {
                        if (word.Length > 5)
                        {
                            Console.Out.Write(" " + word[4]); 
                        }
                    }
                    WriteLine(""); //Seperate lines
                }
            }
        }

        //Returns inputString reversed
        private static string ReverseString(string inputString)
        {
            //Strings are immutable. Create array for manipulation
            char[] charArray = inputString.ToCharArray(); 
            //NOTE: could use charArray.Reverse for an easier solution

            //Swap each char with its mirror location across the center
            //Ex: 1,2,3,4,3,2,1 -> Swap 1s, 2s, and 3s
            char temp;
            for (int i = 0; i < charArray.Length/2; i++) 
            {
                temp = charArray[i];
                charArray[i] = charArray[(charArray.Length - 1) - i];
                charArray[(charArray.Length - 1) - i] = temp;
            }

            return new string(charArray);
        }

        //Reverses every word in the file at filePath and prints the results
        private static void RunReverseString(string filePath)
        {
            WriteLine("Every word reversed:"); //Label output

            //Open file
            using (StreamReader sr = File.OpenText(filePath))
            {
                string currentLine;
                while ((currentLine = sr.ReadLine()) != null) //Read each line
                {
                    //Seperate each word and remove unwanted punctuation
                    string[] wordArray = currentLine.Split(charsToRemove, StringSplitOptions.RemoveEmptyEntries);

                    //Reverse each string and print out the results
                    foreach (string word in wordArray)
                    {
                        Console.Out.Write(" " + ReverseString(word));
                    }
                    WriteLine("");
                }
            }
        }

        //Returns a valid file path entered by the user
        private static string UpdateFilePath()
        {
            //Prompt user for a file path and read their input
            Console.Out.Write("Enter the path of a text file: ");
            string newFilePath = Console.In.ReadLine();

            //Repeat the request if input is invalid
            while (!File.Exists(newFilePath)) //This check also prevents unreadable formats
            {
                WriteLine("Invalid file: " + newFilePath);
                Console.Out.Write("Enter the path of a text file: ");
                newFilePath = Console.In.ReadLine();
            }
            return newFilePath;
        }

    }
}
