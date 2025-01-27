//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[0]);

            String line = br.readLine();
            String[] tokens = line.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            boolean ans = new Solution().twoSum(arr, x);
            System.out.println(ans ? "true" : "false");
            // System.out.println("~");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Using HashSet
     * 
     * TC: O(N)
     * SC: O(N)
     */
    boolean twoSum(int arr[], int target) {
        int n = arr.length;
        Set<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int diff = target - arr[i];
            if (hs.contains(diff)) {
                return true;
            }
            hs.add(arr[i]);
        }
        return false;
    }

    /**
     * Using Two Pointers
     *
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    boolean twoSumTwoPointers(int arr[], int target) {
        int n = arr.length;
        Arrays.sort(arr); // TC: O(N x log(N))
        int p = 0;     // left pointer
        int q = n - 1; // right pointer
        while (p < q) {   // TC: O(N)
            int sum = arr[p] + arr[q];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                // increase sum so increase left pointer
                p++;
            } else {
                // decrease sum so decrease right pointer
                q--;
            }
        }
        return false;
    }
}
