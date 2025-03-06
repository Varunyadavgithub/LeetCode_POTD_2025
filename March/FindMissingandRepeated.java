package March;

import java.util.HashSet;

// Data: 6/03/2025
//Leetcode 2965. Find Missing and Repeated Values.

public class FindMissingandRepeated {
    public static int[] findMissingAndRepeatedValues(int[][] grid){
        int n=grid.length;
        int expectedSum=(n*n*(n*n+1))/2;
        int actualSum=0;
        HashSet<Integer> seen=new HashSet<>();
        int repeated=-1;
        for(int i=0;i<n;i++){
            for(int j=0;i<n;j++){
                int num=grid[i][j];
                actualSum+=num;
                if(seen.contains(num)) repeated=num;
                else seen.add(num);
            }
        }
        int diff=expectedSum-actualSum;
        int missing=repeated+diff;
        return new int[]{repeated,missing};
    }
}