//217
HashSet stores only values, HashMap stores key–value pairs.
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}//o(n),o(n)

class Solution {
    public int removeDuplicates(int[] nums) {
      
       int i = 0;
       for(int j = 1; j < nums.length; j++){
        if(nums[i] != nums[j]) {
            i++;
           nums[i] = nums[j];
        }
       } 
       return i + 1;
    }
}//o(n),o(1)
According to constraints, length is at least 1. If it was guaranteed.