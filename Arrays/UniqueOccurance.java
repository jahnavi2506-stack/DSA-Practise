Pattern Recognition: HashMap for frequency counting + HashSet for duplicate-frequency detection.

Brute Force: Count each distinct element's frequency using nested loops.
Compare every pair of frequencies to check whether any two are equal. Time: O(n²) | Space: O(n).

Optimal Approach: Use a HashMap to store element → frequency in one traversal.
Put each frequency into a HashSet; if it already exists, return false. Time: O(n) average | Space: O(n).

//“If every element is unique, both HashMap and HashSet can grow to size n, so extra space is O(n).”

class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        // Step 1: Count frequency of every element.
        // HashMap stores: number -> how many times it appears.
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {

            // If num exists, increase its count by 1.
            // Otherwise, getOrDefault() gives 0 and we store 1.
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store frequencies we have already seen.
        // If the same frequency appears again, occurrences are NOT unique.
        HashSet<Integer> freqSet = new HashSet<>();

        for (int freq : freqMap.values()) {

            // Frequency already exists → two numbers have the same count.
            if (freqSet.contains(freq)) {
                return false;
            }

            // Store this frequency for future duplicate checking.
            freqSet.add(freq);
        }

        // All frequencies are different.
        return true;
    }
}
