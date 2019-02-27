using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;


namespace Challenges.Tests
{
    [TestClass()]
    public class SolutionsTests
    {
        [TestMethod()]
        public void isPalindromeTest()
        {
            ISolution s = new Solutions();

            //We assume that we can ignore case
            Assert.AreEqual(true, s.isPalindrome("Noon"));

            //Test odd word lengths
            Assert.AreEqual(true, s.isPalindrome("Bob"));

            //We assume that single letter words are palindromes
            Assert.AreEqual(true, s.isPalindrome("a"));

            //We assume spaces are ignored
            Assert.AreEqual(true, s.isPalindrome("Race Car"));
            Assert.AreEqual(true, s.isPalindrome(" Race Car"));
            Assert.AreEqual(true, s.isPalindrome("Race Car "));

            Assert.AreEqual(false, s.isPalindrome("not a palindrome"));
            Assert.AreEqual(false, s.isPalindrome("blab"));
        }

        [TestMethod()]
        [ExpectedException(typeof(Exception))]
        public void crashTest()
        {
            ISolution s = new Solutions();
            s.crash();
        }

        [TestMethod()]
        public void splitTest()
        {
            ISolution s = new Solutions();

            // Basic Test
            CollectionAssert.AreEqual(new[] {"two", "words"}, s.split("two words",' '));

            // Test no split
            CollectionAssert.AreEqual(new[] { "no splitting" }, s.split("no splitting", 'u'));

            // Test multiple splits.  We assume empty strings are returned if the splitting character
            // is found at the beginning or end of a string
            CollectionAssert.AreEqual(new[] { "M", "ss", "ss", "pp", "" }, s.split("Mississippi", 'i'));
        }

        [TestMethod()]
        public void fifthCharTest()
        {
            ISolution s = new Solutions();

            // Test exactly five characters (we assume we aren't zero indexing)
            Assert.AreEqual('s', s.fifthChar("fives"));

            // Another test
            Assert.AreEqual(' ', s.fifthChar("This is a significantly longer string"));
        }

        [TestMethod()]
        [ExpectedException(typeof(ArgumentException))]
        public void fifthCharInvalidTest()
        {
            ISolution s = new Solutions();

            // Test less than five characters
            s.fifthChar("four");
        }

        [TestMethod()]
        public void reverseTest()
        {
            ISolution s = new Solutions();
            Assert.AreEqual("a", s.reverse("a"));

            //Odd number characters
            Assert.AreEqual("cat", s.reverse("tac"));

            //Even number characters
            Assert.AreEqual("lock", s.reverse("kcol"));
        }
    }
}