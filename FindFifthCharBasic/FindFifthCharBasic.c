#include <stdio.h>
#include <conio.h>
#include "FindFifthCharBasic.h"

int main()
{
	char inputStr[100] = { '\0' };
	printf("Enter input: ");
	char fifthChar;
	if (fgets(inputStr, 100, stdin) != NULL)
	{
		fifthChar = findFifthChar(inputStr);
		if (fifthChar == '\0')
		{
			printf("Length is less than 5.\n");
		}
		else
		{
			printf("The fifth char is %c.\n", fifthChar);
		}
	}
	printf("Press any key to continue\n");
	getch();
	return 0;
}

char findFifthChar(char* str)
{
	int length = calculateStrLength(str);
	if (length < 5)
	{
		return '\0';
	}
	else
	{
		return str[4];
	}
}

int calculateStrLength(char* str)
{
	int length = 0;
	int i = 0;
	for (i = 0; str[i] != '\0'; ++i)
	{
	}
	length = i - 1;
	return length;
}