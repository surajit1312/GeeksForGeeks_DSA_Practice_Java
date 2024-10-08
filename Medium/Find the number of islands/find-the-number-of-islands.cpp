//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    vector<vector<char>>directions{
        {-1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, 
        { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }
    };

    /**
    * TC: O(N x M)
    * SC: O(N x M) -  Recursion Stack space
    * DFS take TC: O(N x M) as it visits all the grid cells
    */
    // Function to find the number of islands.
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int countIslands = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (grid[i][j] == '1') {
                    dfsGraph(i, j, n, m, grid);
                    countIslands++;
                }
            }
        }
        return countIslands;
    }
    
    private:
    void dfsGraph(int i, int j, int rows, int cols, vector<vector<char>>& grid) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        // move in all 8 directions
        for (auto &dir : directions) {
            dfsGraph(i + dir[0], j + dir[1], rows, cols, grid);
        }
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<char>> grid(n, vector<char>(m, '#'));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        int ans = obj.numIslands(grid);
        cout << ans << '\n';
    }
    return 0;
}
// } Driver Code Ends