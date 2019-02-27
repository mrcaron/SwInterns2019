using System;

namespace Challenges
{
    public class Solutions : ISolution
    {
        public bool isPalindrome(string s)
        {
            if (s == null)
                throw new ArgumentException("s cannot be null");

            // Assume caps and spaces are ignored
            s = s.Trim();
            s = s.ToLower();

            // Remove spaces
            int index;
            while ((index = s.IndexOf(' ')) > 0)
            {
                s = s.Substring(0, index) + s.Substring(index + 1);
            }

            // Compare the first char to the last, working our way to the middle
            int check = 0;
            while (check < s.Length / 2)
            {
                if (s[check] != s[s.Length - 1 - check])
                    return false;
                check++;
            }

            return true;
        }

        public string[] split(string s, char c)
        {
            if (s == null)
                throw new ArgumentException("s cannot be null");

            // Don't reinvent the wheel
            return s.Split(new char[] {c});
        }

        public char fifthChar(string s)
        {
            if(s == null || s.Length < 5)
                throw new ArgumentException("s must be five characters or longer");

            // Once again, we're not 0 indexing
            return s[4];
        }

        public string reverse(string s)
        {
            if(s == null)
                throw new ArgumentException("s cannot be null");

            char[] chars = s.ToCharArray();
            for (int i = 0; i < chars.Length / 2; i++)
            {
                char temp = chars[i];
                chars[i] = chars[chars.Length - 1 - i];
                chars[chars.Length - 1 - i] = temp;
            }

            return new string(chars);
        }

        public void crash()
        {
            // Any uncaught exception is fine
            throw new Exception("Don't catch this exception!");
        }
    }
}
