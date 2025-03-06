package March;

// Data: 5/03/2025
//Leetcode 2579. Count Total Number of Colored Cells.

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