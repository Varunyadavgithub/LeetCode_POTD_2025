package January;

// Data: 12/01/2025
//Leetcode 2116. Check if a Parentheses String Can Be Valid.

public class canBeValid {
    public static boolean isValidParenthesesString(String s, String locked) {
        int n = s.length();
        // If the string length is odd, it can never be valid
        if (n % 2 != 0) {
            return false;
        }

        // Variables to track minimum and maximum possible open parentheses
        int minOpen = 0, maxOpen = 0;

        // Left-to-right pass
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                // Wildcard can be either '(' or ')'
                maxOpen++; // Treat as '(' for maxOpen
                minOpen = Math.max(minOpen - 1, 0); // Treat as ')' for minOpen
            } else if (s.charAt(i) == '(') {
                // Fixed '('
                minOpen++;
                maxOpen++;
            } else {
                // Fixed ')'
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen--;
            }

            // If maxOpen is negative, it's invalid
            if (maxOpen < 0) {
                return false;
            }
        }
        // After the pass, minOpen must be 0 for the string to be valid
        return minOpen == 0;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "))()))";
        String locked1 = "010100";
        System.out.println(isValidParenthesesString(s1, locked1)); // Output: true

        // Test Case 2
        String s2 = "()()";
        String locked2 = "0000";
        System.out.println(isValidParenthesesString(s2, locked2)); // Output: true

        // Test Case 3
        String s3 = ")";
        String locked3 = "0";
        System.out.println(isValidParenthesesString(s3, locked3)); // Output: false
    }
}
