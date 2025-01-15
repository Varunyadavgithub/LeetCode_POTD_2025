package January;

// Data: 15/01/2025
//Leetcode 2429. Minimize XOR.

public class MinimizeXOR {
    public static int minimizeXor(int num1, int num2) {
        // Count the number of set bits in num2
        int num2SetBits = Integer.bitCount(num2);

        // Create a variable to hold the result
        int result = 0;

        // Use the bits of num1 to form the smallest x
        for (int i = 31; i >= 0 && num2SetBits > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result |= (1 << i);
                num2SetBits--;
            }
        }

        // Use remaining set bits to fill from the least significant bit
        for (int i = 0; i <= 31 && num2SetBits > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i);
                num2SetBits--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int num1 = 3, num2 = 5;
        System.out.println("Output: " + minimizeXor(num1, num2)); // Output: 3

        // Example 2
        num1 = 1;
        num2 = 12;
        System.out.println("Output: " + minimizeXor(num1, num2)); // Output: 3
    }
}
