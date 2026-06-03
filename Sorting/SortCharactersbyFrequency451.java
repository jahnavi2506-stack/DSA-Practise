Pattern Recognition: HashMap + Sorting

Brute Force: Count frequency of every character.
Repeatedly scan all characters to find the highest unused frequency. Append that character frequency times and mark it as used.
Time: O(k² + n), Space: O(k)
where:
n = string length
k = unique characters

HashMap + Sorting (Most Practical): Use a HashMap to store character - frequency.
Convert entries into a list and sort by frequency in descending order.
Append each character frequency times to build the answer.
Time: O(n + k log k), Space: O(k)

HashMap + Max Heap: Use a HashMap to store character - frequency.
Insert all (character, frequency) pairs into a Max Heap.
Continuously poll the highest-frequency character and append it frequency times.
Time: O(n + k log k), Space: O(k)

                            HashMap + Sorting 
class Solution {

    public String frequencySort(String s) {

        // Step 1: Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Convert map entries into list
        List<Map.Entry<Character, Integer>> list =
                new ArrayList<>(freqMap.entrySet());

        // Step 3: Sort by frequency descending
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Step 4: Build answer
        StringBuilder answer = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {

            char ch = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                answer.append(ch);
            }
        }

        // Step 5: Return result
        return answer.toString();
    }
}

                            HashMap + Max Heap
class Solution {

    public String frequencySort(String s) {

        // Step 1: Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>(
                        (a, b) -> b.getValue() - a.getValue()
                );

        // Step 3: Insert all entries
        maxHeap.addAll(freqMap.entrySet());

        // Step 4: Build answer
        StringBuilder answer = new StringBuilder();

        while (!maxHeap.isEmpty()) {

            Map.Entry<Character, Integer> entry = maxHeap.poll();

            char ch = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                answer.append(ch);
            }
        }

        // Step 5: Return result
        return answer.toString();
    }
}