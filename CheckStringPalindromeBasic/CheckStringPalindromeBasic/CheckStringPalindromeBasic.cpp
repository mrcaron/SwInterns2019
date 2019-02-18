// CheckStringPalindromeBasic.cpp : This file contains the 'main' function. Program execution begins and ends there.
// I assume that palindromes are case-insensitive, and can be sentences.
// Extra whitespace at end of string will mess up program.

#include "pch.h"
#include <iostream>
#include "CheckStringPalindromeBasic.h"

int main()
{
	std::string strInput;
	std::cout << "Enter the string to see if it is a palindrome or not: ";
	std::getline(std::cin, strInput);
	bool palindrome = checkIfPalindrome(strInput);
	if (palindrome)
	{
		std::cout << strInput << " is a palindrome." << std::endl;
	}
	else
	{
		std::cout << strInput << " is not a palindrome." << std::endl;
	}
	return 0;
}

bool checkIfPalindrome(std::string str)
{
	if (str.length() == 0 || str.length() == 1)
	{
		return true;
	}
	else
	{
		int middle = str.length() / 2;
		int j = str.length() - 1;
		for (int i = 0; i < middle; ++i)
		{
			if (i == j)
			{
				return true;
			}
			else
			{
				if (str[i] >= 65 && str[i] <= 90 && 
					str[i] != str[j] && str[i] != str[j] - 32)
				{
					return false;
				}
				else if (str[i] >= 97 && str[i] <= 122 && 
					str[i] != str[j] && str[i] != str[j] + 32)
				{
					return false;
				}
			}
			--j;
		}
		return true;
	}
}