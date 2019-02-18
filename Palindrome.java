public class Palindrome {
    /**
     * Checks whether the given string is a valid palindrome.
     *
     * @param string - The string to check
     * @return true if string is a palindrome
     *         false otherwise
     */
    private boolean isPalindrome(String string) {
        // Assumption: Null and empty strings are palindromes
        if (string == null) {
            return true;
        }

        // Assumption: Palindromes are valid only with space characters removed
        // (Eg. "race car" is a palindrome). Also, case does not matter.
        string = string.toLowerCase().replaceAll("\\s", "");

        int i = 0;
        int j = string.length() - 1;

        // Check characters from both sides
        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();

        // Test the method
        String test1 = "Race Car";
        System.out.println(test1 + ": " + palindrome.isPalindrome(test1));

        String test2 = "Redivider";
        System.out.println(test2 + ": " + palindrome.isPalindrome(test2));

        String test3 = null;
        System.out.println(test3 + ": " + palindrome.isPalindrome(test3));

        String test4 = "Palindrome";
        System.out.println(test4 + ": " + palindrome.isPalindrome(test4));

        String test5 = "";
        System.out.println(test5 + ": " + palindrome.isPalindrome(test5));
    }
}
