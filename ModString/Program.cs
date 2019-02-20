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
                            RunSplitStringsOnChar(filePath);
                            break;

                        case '5':

                            break;

                        case 'r':

                            break;

                        case 't':

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

            WriteLine(" p : Check for palindrome strings");
            WriteLine(" s : Split each string on a given character");
            WriteLine(" 5 : Find 5th character of each string that has length > 5");
            WriteLine(" r : Reverse each string");
            WriteLine(" t : Turn off prompt");
            WriteLine(" f : Change input file path");
            WriteLine(" q : Quit");

            WriteLine(stringBuilder.ToString());

        }

        private static void WriteLine(string inputString)
        {
            Console.Out.WriteLine(inputString);
        }

        //private static StreamReader OpenFile(string filePath)
        //{
        //    try
        //    {
        //        StreamReader sr = File.OpenText(filePath);
        //        return sr;
        //    } catch (Exception ex)
        //    {
        //        WriteLine("Failed to open " + filePath);
        //        return null;
        //    }
        //}

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
                    string[] wordArray = currentLine.Split(new char[] { ' ', '\t', '.', '"', '!', }, StringSplitOptions.RemoveEmptyEntries); //TODO add more puncuation
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

        private static void RunSplitStringsOnChar(string filePath)
        {
            Console.Out.Write("Enter character to split text on: ");
            char splitChar = Console.ReadKey().KeyChar;
            WriteLine("");

            WriteLine("File split on '" + splitChar + "'");
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

            //if (File.Exists(inputString))
            //{
            //    try
            //    {
            //        StreamReader sr = File.OpenText(inputString);
            //        sr.Close();
            //        return true;
            //    } catch (Exception ex)
            //    {
            //        WriteLine(ex.Message);
            //        return false;
            //    }
            //}
            //else
            //{
            //    return false;
            //}
        }
    }
}
