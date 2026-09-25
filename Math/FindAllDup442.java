Pattern recognition:

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       HashMap <Integer, Integer> freq = new HashMap<>();
       List<Integer> result = new ArrayList<>();

       for(int num : nums) {
         freq.put(num, freq.getOrDefault(num, 0) + 1);
       } 

       for(int num :freq.keySet()) {
         if(freq.get(num) == 2) {
            result.add(num);
         }
       }
       return result;
    }
}

