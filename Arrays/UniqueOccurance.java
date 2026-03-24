//1207
//“If every element is unique, both HashMap and HashSet can grow to size n, so extra space is O(n).”
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> freqSet = new HashSet<>();
        for (int freq : freqMap.values()) {
            if(freqSet.contains(freq)) {
                return false;
            }
            freqSet.add(freq);
        }
        return true;
    }
}
