// ReverseStringBasic.cpp : This file contains the 'main' function. Program execution begins and ends there.
// I assume that an ASCII string is used.

#include "pch.h"
#include <iostream>
#include "ReverseStringBasic.h"

int main()
{
	std::string strInput;
	std::cout << "Enter a string to reverse: ";
	std::getline(std::cin, strInput);
	std::string reversedStr = reverseString(strInput);
	std::cout << "Reversed string: " << reversedStr << std::endl;
	return 0;
}

std::string reverseString(std::string str)
{
	std::string newStr = "";
	if (str.length() <= 1)
	{
		return str;
	}
	for (std::string::reverse_iterator it = str.rbegin(); it != str.rend(); ++it)
	{
		newStr += *it;
	}
	return newStr;
}

