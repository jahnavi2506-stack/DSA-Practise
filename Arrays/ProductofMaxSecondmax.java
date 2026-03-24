//1464
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;// = 0
        int secondMax = Integer.MIN_VALUE;// = 0(works even for negative numbers)
      for(int i = 0; i < nums.length; i++) {
        int currentNum = nums[i];
        if(currentNum > max) {
            secondMax = max;
            max = currentNum;
        }
        else if(currentNum > secondMax) {
          secondMax = currentNum;
        }
      } 
      return (max - 1) * (secondMax - 1);

    }
}//o(n),o(1)
