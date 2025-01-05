package January;

// Data: 05/01/2025
//Leetcode 2381. Shifting Letters II.

public class shiftingLetters {
    public static String applyShiftsToString(String s, int[][] shifts) {
        int n = s.length();
        int[] arr = new int[n]; // Array to store the cumulative effect of shifts
        // Update prefix sum array for the shifts
        for (int[] shift : shifts) {
            if (shift[2] == 1) { // Forward shift
                arr[shift[0]]++;
                if (shift[1] + 1 < n) {
                    arr[shift[1] + 1]--;
                }
            } else { // Backward shift
                arr[shift[0]]--;
                if (shift[1] + 1 < n) {
                    arr[shift[1] + 1]++;
                }
            }
        }
        StringBuilder res = new StringBuilder(s);
        int sum = 0;
        // Apply the shifts to the characters
        for (int i = 0; i < n; i++) {
            sum = (sum + arr[i]) % 26; // Calculate cumulative shift
            if (sum < 0) {
                sum += 26; // Handle negative shifts
            }
            // Calculate the shifted character
            char shiftedChar = (char) ('a' + ((s.charAt(i) - 'a' + sum) % 26));
            res.setCharAt(i, shiftedChar);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "abc";
        int[][] shifts1 = { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 } };
        System.out.println(applyShiftsToString(s1, shifts1)); // Output: "ace"

        String s2 = "dztz";
        int[][] shifts2 = { { 0, 0, 0 }, { 1, 1, 1 } };
        System.out.println(applyShiftsToString(s2, shifts2)); // Output: "catz"
    }
}
