#include <iostream>
#include <string>

using namespace std;

//Declare methods to keep main at top
int checkPalindrome(string inputString, int strLength);
int findFifthChar(string inputString, int strLength);
int reverseString(string inputString, int strLength);

int main() {
    //Prompt user and record response
    cout << "Enter a string: ";
    string inputString;
    getline(cin, inputString);

    //Calculate length now to save time later
    int strLength = inputString.size();

    //Disregard empty input
    if (strLength < 0) {
        return 0;
    }

    //Manipulate string and print results
    checkPalindrome(inputString, strLength);
    findFifthChar(inputString, strLength);
    reverseString(inputString, strLength);

    return 0;
}

//Checks if inputString is a palindrome and prints results
int checkPalindrome(string inputString, int strLength) {
    //Compares each character with its mirror location across the center of the string
    for (int i = 0; i < strLength / 2; i++) {
        if (inputString[i] != inputString[(strLength - 1) - i]) {
            cout << inputString << " is not a palindrome" << endl;
            return 0;
        }
    }

    cout << inputString << " is a palindrome" << endl;
    return 0;
}

//Finds and prints the 5th character
int findFifthChar(string inputString, int strLength) {
    if (strLength > 5) {
        cout << "The 5th character in " << inputString << " is " << inputString[4] << endl;
    }
    return 0;
}

//Reverses input string and prints the results
int reverseString(string inputString, int strLength) {
    string inputStringCopy = inputString; //Save a copy for the output message
    
    //Switch each character with its mirror location across the center of the string
    char temp;
    for (int i = 0; i < strLength / 2; i++) {
        temp = inputString[i];
        inputString[i] = inputString[(strLength - 1) - i];
        inputString[(strLength - 1) - i] = temp;
    }

    cout << inputStringCopy << " reversed is " << inputString << endl;
    return 0;
}

