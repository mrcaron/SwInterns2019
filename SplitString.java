public class SplitString {

    /**
     * Get regex to use in split method (Just the character if not a metacharacter)
     *
     * @param character - The character based off to split string.
     * @return regex String
     */
    private String getRegex(char character) {
        switch(character) {
            case '(':
                return "\\(";
            case ')':
                return "\\)";
            case '[':
                return "\\[";
            case ']':
                return "\\]";
            case '{':
                return "\\{";
            case '}':
                return "\\}";
            case '\\':
                return "\\\\";
            case '$':
                return "\\$";
            case '|':
                return "\\|";
            case '?':
                return "\\?";
            case '*':
                return "\\*";
            case '+':
                return "\\+";
            case '.':
                return "\\.";
            case '<':
                return "\\<";
            case '>':
                return "\\>";
            case '-':
                return "\\-";
            case '=':
                return "\\=";
            case '!':
                return "\\!";
            default:
                return "" + character;
        }
    }

    /**
     * Splits the given string into different tokens.
     *
     * @param string - The string to split
     * @param character - The character based off to split string.
     * @return split parts
     */
    private String[] splitString(String string, char character) {
        // Assumption: Case sensitive (Uppercase letters will not split the same lowercase ones)

        if (string == null || string.isEmpty()) {
            return new String[0];
        }

        // Split based off all white spaces if character is an empty space
        if (character == ' ') {
            return string.split("\\s");
        }

        // Get required regex to split string with
        String regex = getRegex(character);
        return string.split(regex);
    }

    public static void main(String[] args) {
        SplitString split = new SplitString();

        // Test the method
        String string = "Split a string into parts based off a given character";

        // Test 1
        char character = 's';
        String[] parts = split.splitString(string, character);
        System.out.println("String: " + string + ", Char: " + character);
        System.out.println();

        for (String part: parts) {
            System.out.println(part);
        }
        System.out.println();

        // Test 2: Metacharacter (No change to above string)
        character = '(';
        parts = split.splitString(string, character);
        System.out.println("String: " + string + ", Char: " + character);
        System.out.println();

        for (String part: parts) {
            System.out.println(part);
        }
        System.out.println();

        // Test 3: Space
        character = ' ';
        parts = split.splitString(string, character);
        System.out.println("String: " + string + ", Char: " + character);
        System.out.println();

        for (String part: parts) {
            System.out.println(part);
        }
        System.out.println();

        // Test 4: Uppercase
        character = 'S';
        parts = split.splitString(string, character);
        System.out.println("String: " + string + ", Char: " + character);
        System.out.println();

        for (String part: parts) {
            System.out.println(part);
        }
    }
}
