#include <iostream>
#include <string>

using namespace std;

int main() {
    cout << "Enter a string: ";
    string inputString;
    getline(cin, inputString);
    int strSize = inputString.size();

    for (int i = 0; i < strSize / 2; i++) {
        if (inputString[i] != inputString[(strSize - 1) - i]) {
            cout << inputString << " is not a palindrome" << endl;
            return 0;
        }
    }

    cout << inputString << " is a palindrome" << endl;
    return 0;
}