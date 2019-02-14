import json
# Check if a String is a palindrome or not
def checkIfPalindrome(s):
    if s == s[::-1]:
        print(s, 'is a Palindrome String')
    else:
        print(s, 'is not a Palindrome String')

# Split a string into parts based off a given character
def split(s, c):
    temp = s.split(c)
    print(temp)

# Split a string into parts based off a given character
def withoutSplit(s, c):
    while c in s:
        print(s[0:s.index(c)])
        s = s[s.index(c)+1:]
    print(s)

# Find the 5th character of a string that has length > 5            
def findFifthCharOfStriing(s):
    if(len(s)>=5):
        print('the 5th character of a string:' + s[4])
    else:
        print('Enter a string that has length > 5')

# Reverse a string
def reverseAString(s):
    print(s[::-1])
    
# Write code to crash your program
def crash():
    crash()

# Print out a JSON object that has two attributes
def jsonObject(dictionary):
    #{"Name": "Alice", "Age": 15, "Address": "Chicago"}
    count = 0
    for each in dictionary.items():
        count += 1
    if count == 2:
        print('JSON object that has two attributes')
        print(dictionary)
    elif count < 2:
        print('JSON object has less than two attributes')
    else:
        print('JSON object has more than two attributes')


if __name__ == "__main__":
    print("Choose functionality: ")
    print("1 Check if a String is a palindrome or not")
    print("2 Split a string into parts based off a given character")
    print("3 Find the 5th character of a string that has length > 5")
    print("4 Reverse a string")
    print("5 Crash the program")
    print("6 Print out a JSON object that has two attributes")
    s = str(input())
    def getInput():
        print("Please input a string.")
        return str(input())
    if s == '1':
        checkIfPalindrome(getInput())
    elif s == '2':
        split(getInput(), input("Please provide a character."))
    elif s == '3':
        findFifthCharOfStriing(getInput())
    elif s == '4':
        reverseAString(getInput())
    elif s == '5':
        crash()
    elif  s == '6':
        print('Enter a JSON object')
        jsonObject(json.loads(input()))
    else:
        print("Plese select an option from above")
        exit()