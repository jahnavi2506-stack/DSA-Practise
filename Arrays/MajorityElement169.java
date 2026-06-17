// 169
// If an element appears more than n/2 times,
// it cannot be fully cancelled out by other elements.
// We use:
// •	candidate
// •	count
// "This works because the majority element appears more than n/2 times. Even if we cancel it against every other element, 
// it will still remain. The algorithm simulates this cancellation process in O(n) time and O(1) space."
class Solution {
    public int majorityElement(int[] nums) {
      int candidate = 0;
      int count = 0;
      for(int num : nums) {
        if(count == 0) {
            candidate = num;
        }
        if(num == candidate) {
            count++;
        } else {
            count--;
        }
      } 
      return candidate;
    }
}
