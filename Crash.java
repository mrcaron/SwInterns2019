public class Crash {

    /**
     * Recursively call crash() infinitely to throw StackOverflowError
     */
    private void crash() {
        crash();
    }

    public static void main(String[] args) {
        Crash cr = new Crash();
        cr.crash();
    }
}
