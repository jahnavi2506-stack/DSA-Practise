Pattern Recognition: Traverse rows → calculate row sum → update maximum.

Brute Force Approach: For every customer, calculate wealth by adding all their bank balances.
Store all customer wealth values in an extra array, then find the maximum.
Time: O(m × n) | Space: O(m)


Optimal Approach: Traverse each row and calculate currentWealth using the inner loop.
Immediately compare it with maxWealth using Math.max().
Time: O(m × n) | Space: O(1) — best possible because every element must be visited.
Where: m = number of customers/rows, n = maximum number of banks/columns

class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int i = 0; i < accounts.length; i++) {
            int currentWealth = 0;

            for (int j = 0; j < accounts[i].length; j++) {
                currentWealth += accounts[i][j];
            }

            maxWealth = Math.max(maxWealth, currentWealth);
        }

        return maxWealth;
    }
}//o(m x n),o(1)
