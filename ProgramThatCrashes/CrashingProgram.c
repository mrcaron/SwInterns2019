#include <stdio.h>

// Dereferencing a null pointer: easy way to crash a program!

int main()
{
	int *number = NULL;
	int newNum = *number + 15;
	printf("%d\n", *number);
	printf("%d\n", newNum);
	return 0;
}