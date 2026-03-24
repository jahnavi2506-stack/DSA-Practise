//303
// Why NOT O(nq)?
Because we are NOT looping inside each query.
If we used brute force:
Each query = O(n)
Then:
O(n × q)
That would be slow.
Private: It is accessible to the class scope, not method scope.
class NumArray {
      private int[] prefix;
    public NumArray(int[] nums) {
        int n = nums.length;
         prefix = new int[n];
        
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
          prefix[i] = prefix[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) {
            return prefix[right];
        }
            return prefix[right] - prefix[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
