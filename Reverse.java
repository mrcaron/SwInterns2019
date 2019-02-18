public class Reverse {

    /**
     * Reverses the given string
     *
     * @param string - The string to be reversed
     * @return The reversed string, null if given string is null
     */
    private String reverse(String string) {
        if (string == null) {
            return null;
        }

        String reversed = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversed += string.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {
        Reverse rev = new Reverse();

        // Test the method
        // Test 1: null
        String string = null;
        String revString = rev.reverse(string);
        System.out.println("String: " + string + ", Reverse: " + revString);

        // Test 2: Empty string
        string = "";
        revString = rev.reverse(string);
        System.out.println("String: " + string + ", Reverse: " + revString);

        // Test 3:
        string = "DevOps";
        revString = rev.reverse(string);
        System.out.println("String: " + string + ", Reverse: " + revString);
    }
}
