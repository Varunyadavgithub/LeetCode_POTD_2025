package January;

// Data: 13/01/2025
//Leetcode 3223. Minimum Length of String After Operations.

public class minimumLength {
    public static int minLength(String s) {
        int n = s.length();
        int[] ferq = new int[n];
        for (char ch : s.toCharArray()) {
            ferq[ch - 'a']++;
        }
        int length = 0;
        for (int count : ferq) {
            if (count % 2 == 1) {
                length += 1;
            } else {
                length += Math.min(2, count);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s1 = "abaacbcbb";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + minLength(s1)); // Expected: 5

        // Test case 2
        String s2 = "aa";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + minLength(s2)); // Expected: 2

        // Test case 3
        String s3 = "a";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + minLength(s3)); // Expected: 1

        // Test case 4
        String s4 = "abca";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + minLength(s4)); // Expected: 4
    }
}
