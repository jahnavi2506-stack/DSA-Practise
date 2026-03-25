Subsets pattern + size check
So we use: index pattern
class Solution {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(n, k, 1, current, result);

        return result;
    }

    private void backtrack(int n,
                           int k,
                           int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i <= n; i++) {

            current.add(i);

            backtrack(n, k, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}
We generate all combinations of k from n,
so total combinations = nCk.

Each combination has size k,
and copying takes O(k).

So time complexity = O(k × nCk).

We store all combinations in result,
so space complexity = O(k × nCk).

Recursion stack is O(k), but result dominates.