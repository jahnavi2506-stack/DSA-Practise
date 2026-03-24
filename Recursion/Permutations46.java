class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, current, visited, result);

        return result;
    }

    private void backtrack(int[] nums,
                           List<Integer> current,
                           boolean[] visited,
                           List<List<Integer>> result) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) continue;

            current.add(nums[i]);
            visited[i] = true;

            backtrack(nums, current, visited, result);

            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}