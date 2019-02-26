using System;

namespace Challenges
{
    public class Solutions : ISolution
    {
        public bool isPalindrome(string s)
        {
            s = s.ToLower();
            s = s.Trim();

            int index;
            while ((index = s.IndexOf(' ')) > 0)
            {
                s = s.Substring(0, index) + s.Substring(index + 1);
            }

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
            // Don't reinvent the wheel
            return s.Split(new char[] {c});
        }

        public char fifthChar(string s)
        {
            throw new System.NotImplementedException();
        }

        public string reverse(string s)
        {
            throw new System.NotImplementedException();
        }

        public void crash()
        {
            throw new Exception("Don't catch this exception!");
        }
    }
}
