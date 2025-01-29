package January;

// Data: 29/01/2025
//Leetcode 684. Redundant Connection.

import java.util.*;

public class RedundantConnection {

    // Union-Find class to handle union and find operations
    static class UnionFind {
        int[] parent;

        // Constructor initializes the parent array
        public UnionFind(int n) {
            parent = new int[n + 1]; // We are using 1-based indexing
            for (int i = 1; i <= n; i++) {
                parent[i] = i; // Initially, each node is its own parent
            }
        }

        // Find method with path compression
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        // Union method to merge two components
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent[rootX] = rootY; // Union operation
            }
        }
    }

    // Main function to find the redundant connection
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        // Traverse the edges in order
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            // If u and v are already connected, it means this edge is redundant
            if (uf.find(u) == uf.find(v)) {
                return edges[i];
            }

            // Union the two nodes if they are not connected
            uf.union(u, v);
        }

        // If no redundant edge is found, return an empty array
        return new int[0];
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] edges1 = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[] result1 = findRedundantConnection(edges1);
        System.out.println("Redundant Edge: [" + result1[0] + ", " + result1[1] + "]");

        // Test case 2
        int[][] edges2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        int[] result2 = findRedundantConnection(edges2);
        System.out.println("Redundant Edge: [" + result2[0] + ", " + result2[1] + "]");
    }
}
