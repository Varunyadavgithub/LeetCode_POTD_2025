package March;

// Data: 2/02/2025
//Leetcode 1752. Check if Array Is Sorted and Rotated.

public class CountColoredCells {
    public static long coloredCells(int n) {
        // Solution - 1
        long count = 1;
        long jumpSize = 4;
        while (n > 1) {
            count += jumpSize;
            jumpSize += 4;
            n--;
        }
        return count;

        // Solution - 2
        // return 1+4*(n*(n-1)/2);
    }
}