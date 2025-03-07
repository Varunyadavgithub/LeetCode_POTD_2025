package March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Data: 7/03/2025
//Leetcode 2523. Closest Prime Numbers in Range.

public class ClosestPrimeNumber {
    public int[] closestPrimes(int left, int right) {
        int limit = (int) 1e6;
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i])
                primes.add(i);
        }
        if (primes.size() < 2)
            return new int[] { -1, -1 };
        int minDiff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primes.get(i - 1);
                num2 = primes.get(i);
            }
        }
        return new int[] { num1, num2 };
    }
}
