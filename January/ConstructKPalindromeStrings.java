package January;

// Data: 11/01/2025
//Leetcode 1400. Construct K Palindrome Strings.

public class ConstructKPalindromeStrings {
    public static boolean canConstruct(String str,int k){
        if (str.length()<k) return false;
        int[] charCounts=new int[26];
        for(char ch:str.toCharArray()){
            charCounts[ch-'a']++;
        }
        int oddCount=0;
        for(int count:charCounts){
            if (count%2!=0) oddCount++;
        }
        return oddCount<=k;
    }
    public static void main(String[] args) {
        // Example 1
        String s1 = "annabelle";
        int k1 = 2;
        System.out.println(canConstruct(s1, k1)); // Output: true

        // Example 2
        String s2 = "leetcode";
        int k2 = 3;
        System.out.println(canConstruct(s2, k2)); // Output: false

        // Example 3
        String s3 = "true";
        int k3 = 4;
        System.out.println(canConstruct(s3, k3)); // Output: true
    }
}
