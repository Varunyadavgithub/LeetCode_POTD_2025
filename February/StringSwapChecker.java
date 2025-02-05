package February;

// Data: 5/02/2025
//Leetcode 1790. Check if One String Swap Can Make Strings Equal.

public class StringSwapChecker {
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true; // If both strings are already equal

        int n = s1.length();
        int first = -1, second = -1; // To store mismatching indices
        int count = 0; // To count mismatches

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count == 1)
                    first = i;
                else if (count == 2)
                    second = i;
                else
                    return false; // More than 2 mismatches
            }
        }

        // If exactly 2 mismatches exist, check if swapping them makes strings equal
        return count == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(areAlmostEqual("bank", "kanb")); // true
        System.out.println(areAlmostEqual("attack", "defend")); // false
        System.out.println(areAlmostEqual("kelb", "kelb")); // true
        System.out.println(areAlmostEqual("abcd", "abdc")); // true
        System.out.println(areAlmostEqual("abcd", "abcd")); // true
    }

}
