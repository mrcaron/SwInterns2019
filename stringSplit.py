def stringSplit(string, character):
    output = string.split(character)
    return output

if __name__ == "__main__":
    string = input("Please Enter a string to split it\n")
    character = input("Please enter a character to split the string\n")
    if len(string)>0:
        print("output after split is:\n", stringSplit(string, character))
    else:
        print("Incorrect input.")
