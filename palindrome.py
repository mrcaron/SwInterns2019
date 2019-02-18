import sys
import re

#take first positional argument from command line as the word to be tested
word = sys.argv[1].lower().replace(' ', '')

#use regex to keep only alphanumeric chars
word = re.sub(r"\W+", '', word)

#if word is equal to reversed word, it is a palindrome
ans = "Is a palindrome" if word == word[::-1] else "Is not a palindrome" 

#display the answer
print(ans)
