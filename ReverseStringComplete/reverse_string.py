def reverse_string(string: str) -> str:
    if len(string) <= 1:
        return string
    newStr = ""
    for i in reversed(string):
        newStr += i
    return newStr
