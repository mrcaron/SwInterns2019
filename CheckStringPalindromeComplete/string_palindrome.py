# Assuming ASCII strings (will not work properly with accents)
# Case insensitive ("Bob" is a palindrome)

def palindrome(string: str) -> bool:
    length = len(string)
    middle = length // 2
    end = length - 1
    lowercase = string.lower()
    for begin in range(0, middle):
        if begin == end:
            return True
        elif lowercase[begin] != lowercase[end]:
            return False
        end -= 1
    return True
