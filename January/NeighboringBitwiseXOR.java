package January;

// Data: 17/01/2025
//Leetcode 2683. Neighboring Bitwise XOR.

public class NeighboringBitwiseXOR {
    public static boolean doesValidOriginalExist(int[] derived) {
        return isValidOriginal(derived, 0) || isValidOriginal(derived, 1);
    }

    public static boolean isValidOriginal(int[] derived, int start) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = start; // Set the first element

        // Calculate the rest of the original array based on derived
        for (int i = 1; i < n; i++) {
            original[i] = derived[i - 1] ^ original[i - 1];
        }

        // Verify if the last element satisfies the circular XOR condition
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }

    public static void main(String[] args) {
        int[] derived1 = { 1, 1, 0 };
        System.out.println(doesValidOriginalExist(derived1)); // Output: true

        int[] derived2 = { 1, 1 };
        System.out.println(doesValidOriginalExist(derived2)); // Output: true

        int[] derived3 = { 1, 0 };
        System.out.println(doesValidOriginalExist(derived3)); // Output: false
    }
}
