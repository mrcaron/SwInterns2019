def NthCharacter(string):
    output = string[4]
    return output

if __name__ == "__main__":
    string = input("Please Enter a string with length greater then 5.\n")
    if len(string)>5:
        print("5th character of string is:", NthCharacter(string))
    else:
        print("Incorrect input.")
