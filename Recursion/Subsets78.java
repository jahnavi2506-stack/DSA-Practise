class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, 0, current, result);

        return result;
    }


    private void backtrack(int[] nums,
                           int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            current.add(nums[i]);

            backtrack(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}

Time Complexity = O(n * 2^n)
because we generate all 2^n subsets
and copying each subset takes O(n)

Space Complexity = O(n * 2^n)
because we store all subsets
and recursion stack is O(n)