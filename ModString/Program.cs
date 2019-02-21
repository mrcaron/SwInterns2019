using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ModString
{
    class Program
    {
        private static int DivideLength = 40;
        private static char DivideChar = '-';
        private static char[] charsToRemove = new char[] { ' ', '\t', '.', '"', '!', }; //TODO add more punctuation

        private static bool showPrompt = true;

        static void Main(string[] args)
        {
            string filePath = UpdateFilePath();

            char inputChar;
            do
            {
                PrintActionPrompt(filePath);
                inputChar = Console.ReadKey().KeyChar;
                WriteLine("");
                inputChar = Char.ToLower(inputChar);
                WriteLine("");
                try
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
                            showPrompt = !showPrompt;

                            if (!showPrompt)
                            {
                                WriteLine("Prompt has been turned off. Use 't' to turn it back on.");
                            }
                            break;

                        case 'f':
                            filePath = UpdateFilePath();
                            break;

                        case 'q':

                            break;
                        default:
                            break;
                    }
                } catch(Exception ex)
                {
                    WriteLine(ex.Message);
                }
                
            } while (inputChar != 'q');
        }

        private static void PrintActionPrompt(string filePath)
        {
            //Create our divider string
            StringBuilder stringBuilder = new StringBuilder(DivideLength);
            stringBuilder.Append(DivideChar, DivideLength);
            
            WriteLine(stringBuilder.ToString());
            WriteLine("");
            Console.Out.Write("Current file path: ");
            WriteLine(filePath);
            WriteLine("");

            if (showPrompt)
            {
                WriteLine(" p : Check for palindrome strings");
                WriteLine(" s : Split each string on a given character");
                WriteLine(" 5 : Find 5th character of each string that has length > 5");
                WriteLine(" r : Reverse each string");
                WriteLine(" t : Turn off prompt");
                WriteLine(" f : Change input file path");
                WriteLine(" q : Quit");
            }

            WriteLine(stringBuilder.ToString());

        }

        private static void WriteLine(string inputString)
        {
            Console.Out.WriteLine(inputString);
        }

        private static bool CheckPalindrome(string inputString)
        {
            char[] stringArray = inputString.ToCharArray();
            for (int i = 0; i < stringArray.Length / 2; i++)
            {
                if (stringArray[i] != stringArray[(stringArray.Length - 1) - i])
                {
                    return false;
                }
            }

            return true;
        }

        private static void RunPalindromeCheck(string filePath)
        {
            using (StreamReader sr = File.OpenText(filePath))
            {
                List<string> palindromeList = new List<string>();
                string currentLine;
                while ((currentLine = sr.ReadLine()) != null)
                {
                    string[] wordArray = currentLine.Split(charsToRemove, StringSplitOptions.RemoveEmptyEntries); //TODO add more puncuation
                    foreach (string word in wordArray) {
                        if (CheckPalindrome(word))
                        {
                            palindromeList.Add(word);
                        }
                    }
                }

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
            WriteLine("");
        }

        private static void RunSplitStringOnChar(string filePath)
        {
            Console.Out.Write("Enter character to split text on: ");
            char splitChar = Console.ReadKey().KeyChar;
            WriteLine("");

            WriteLine("File split on '" + splitChar + "':");
            using (StreamReader sr = File.OpenText(filePath))
            {
                string currentLine;
                while ((currentLine = sr.ReadLine()) != null)
                {
                    string[] wordArray = currentLine.Split(new char[] {splitChar, ' '}, StringSplitOptions.RemoveEmptyEntries);
                    foreach (string phrase in wordArray)
                    {
                        Console.Out.Write(" " + phrase);
                    }
                    WriteLine("");
                }
            }
        }

        private static void RunFindFifthChar(string filePath)
        {
            WriteLine("Every 5th character in every word longer than 5 characters:");
            using (StreamReader sr = File.OpenText(filePath))
            {
                string currentLine;
                while ((currentLine = sr.ReadLine()) != null)
                {
                    string[] wordArray = currentLine.Split(charsToRemove, StringSplitOptions.RemoveEmptyEntries);
                    foreach (string word in wordArray)
                    {
                        if (word.Length > 5)
                        {
                            Console.Out.Write(" " + word[4]); //TODO State assumptions
                        }
                    }
                    WriteLine("");
                }
            }
        }

        private static string ReverseString(string inputString)
        {
            char[] charArray = inputString.ToCharArray(); //Strings immutable. Use array
            //charArray.Reverse
            char temp;
            for (int i = 0; i < charArray.Length/2; i++)
            {
                temp = charArray[i];
                charArray[i] = charArray[(charArray.Length - 1) - i];
                charArray[(charArray.Length - 1) - i] = temp;
            }

            return new string(charArray);
        }

        private static void RunReverseString(string filePath)
        {
            WriteLine("Every word reversed:");
            using (StreamReader sr = File.OpenText(filePath))
            {
                string currentLine;
                while ((currentLine = sr.ReadLine()) != null)
                {
                    string[] wordArray = currentLine.Split(charsToRemove, StringSplitOptions.RemoveEmptyEntries);
                    foreach (string word in wordArray)
                    {
                        Console.Out.Write(" " + ReverseString(word));
                    }
                    WriteLine("");
                }
            }
        }



        private static string UpdateFilePath()
        {
            Console.Out.Write("Enter a file path: ");
            string newFilePath = Console.In.ReadLine();
            while (!File.Exists(newFilePath))
            {
                WriteLine("Can't find " + newFilePath);
                Console.Out.Write("Enter a file path: ");
                newFilePath = Console.In.ReadLine();
            }

            return newFilePath;
        }
    }
}
