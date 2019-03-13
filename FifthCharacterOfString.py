''' Solidworks 2019 Summer Internship '''

# Find the 5th character of a string that has length > 5
# author: dhaval bhanderi

import os

print('Enter the String: ')
str = input()

def FifthCharacter():
    if len(str) > 4:
        #print(str[4])
        return str[4]
    else:
        return "The string length is less than 5 character"

# Call the methode
FifthCharacter()
