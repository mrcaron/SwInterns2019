public class FindFifth {

    /**
     * Gets the 5th character of string if length is > 5
     *
     * @param string - The given string
     * @return The fifth character or null character if string is null or has length <= 5
     */
    private char getFifth(String string) {
        // Assumption: Given string does not contain null character as its fifth character

        // Return null character if null string or does not have length > 5
        if (string == null || string.length() <= 5) {
            return '\0';
        }

        // Return 5th character
        return string.charAt(4);
    }

    public static void main(String[] args) {
        FindFifth fifth = new FindFifth();

        // Test the method

        // Test 1: null
        String string = null;
        char fifthChar = fifth.getFifth(string);
        System.out.println("String: null");

        if (fifthChar == '\0') {
            System.out.println("Character is null");
        }
        System.out.println();

        // Test 2: Small string
        string = "four";
        fifthChar = fifth.getFifth(string);
        System.out.println("String: " + string);
        if (fifthChar == '\0') {
            System.out.println("Character is null");
        } else {
            System.out.println("Fifth character: " + fifthChar);
        }
        System.out.println();

        // Test 3: Valid fifth char
        string = "program";
        fifthChar = fifth.getFifth(string);
        System.out.println("String: " + string);
        if (fifthChar == '\0') {
            System.out.println("Character is null");
        } else {
            System.out.println("Fifth character: " + fifthChar);
        }
    }
}
