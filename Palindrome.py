def palindrome(string):
    i = 0
    j = len(string)-1
    while i<j:
        if string[i] != string[j]:
            return False
        i += 1
        j -= 1
    return True

if __name__ == "__main__":
    string = input("Please Enter a string to check if string is palindrome\n")
    if len(string)>0:
        print("palindrome of given string is:\n", palindrome(string))
    else:
        print("Incorrect input.")
