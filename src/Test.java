public class Test {

    /**
     * Extends a String to recursively compare it against another String lexicographically.
     * @param string1 The "1st string" - to be compared against the "2nd string"
     * @param string2 The "2nd string" - to be compared against the "1st string"
     * @return 0 if the strings two string are equal, or if one of the strings are empty or null,
     */
    public static int compareTo(String string1, String string2) {
        if (string1 == null || string2 == null || string1.isEmpty() && string2.isEmpty())
            return 0;

        if (string1.equals(string2))
            return 0;

        if (string1.length() < string2.length())
            return -1;
        else if (string1.length() > string2.length())
            return 1;

        if (string1.charAt(0) < string2.charAt(0))
            return -1;
        else if (string1.charAt(0) > string2.charAt(0))
            return 1;

            return compareTo(string1.substring(1), string2.substring(1));

    } // end int

    /**
     * Checks if the passed string is null or empty
     * @param string The string to check
     * @return True if the string is null or empty, else returns false
     */
    public static boolean isNullOrEmpty(String string) {
        if (string == null || string.isEmpty())
            return true;
        return false;

    } // end boolean

} // end class
