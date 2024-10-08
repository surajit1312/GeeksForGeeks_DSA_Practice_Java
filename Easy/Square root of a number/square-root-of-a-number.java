//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        if (n <= 1) {
            return (long) n;
        }
        long low = 1L;
        long high = n;
        long sqrt = 1L;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sqr = mid * mid;
            if (sqr <= n) {
                sqrt = Math.max(sqrt, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return sqrt;
    }
}
