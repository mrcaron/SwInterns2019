def stringReverse(string):
    output = string[::-1]
    return output

if __name__ == "__main__":
    string = input("Please Enter a string to reverse.\n")
    if len(string)>0:
        print(stringReverse(string))
    else:
        print("Incorrect input")
