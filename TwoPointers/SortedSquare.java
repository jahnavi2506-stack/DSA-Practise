//977
//Brute force
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }
}//o(n log n),o(n)
class Solution {
    public int[] sortedSquares(int[] nums) {
      int n = nums.length;
      int left = 0;
      int right = n - 1;
      int pos = n - 1;
      int[] result = new int[n];
      while(left <= right) {
        if(Math.abs(nums[left]) > Math.abs(nums[right])) {
             result[pos] = nums[left] * nums[left];
             left++;
        }
        else{
            result[pos] = nums[right] * nums[right];
            right--;
        }
        pos--; 
      }
      return result;
    }
}//o(n),o(n)
//Negative numbers may produce the largest squares, so always compare Math.abs(nums[left]) and Math.abs(nums[right]).
