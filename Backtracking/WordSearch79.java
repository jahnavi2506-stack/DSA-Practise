class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;// number of rows
        int n = board[0].length;//number of columns

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Optimization: start only if first char matches
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Base case: all characters matched
        if (index == word.length()) return true;

        // Boundary + mismatch check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || board[i][j] != word.charAt(index)) {
            return false;//out of char and if char doesn't match
        }

        char temp = board[i][j];//store original char 
        board[i][j] = '#';// // Mark visited

        // Explore 4 directions
        boolean found = dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1);

        // Backtrack (restore)
        board[i][j] = temp;
        return found;
    }
}
You try starting from every cell → m * n
For each start:
First step → up to 4 choices
Next steps → up to 3 choices (excluding the previous cell) So:- O(m * n * 3^L)

Space Complexity:- O(L)
Recursion depth = length of word
At most L function calls in stack