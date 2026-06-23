Pattern Recognition: HashMap

Brute Force Approach: Compare every string with every other string and check if they are anagrams by sorting both.
If two strings are anagrams, place them in the same group and mark them as visited.
Time : O(n² × k log k), where k is the average string length.

Optimal Approach: Use a HashMap<String, List<String>> where the key is the sorted version of each string.
For every string, sort its characters and add it to the corresponding list in the map.
Time : O(n × k log k), Space : O(n × k).

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // HashMap to store:
        // Key   -> sorted version of a string
        // Value -> list of all strings having the same sorted form
        HashMap<String, List<String>> map = new HashMap<>();

        // Traverse each string in the input array
        for (String s : strs) {

            // Convert string to character array
            char[] arr = s.toCharArray();

            // Sort the characters
            // Example:
            // "eat" -> ['e','a','t'] -> ['a','e','t']
            Arrays.sort(arr);

            // Convert sorted character array back to String
            // "eat", "tea", "ate" all become "aet"
            String key = new String(arr);

            // If key is not present, create a new empty list
            map.putIfAbsent(key, new ArrayList<>());

            // Add the original string to its anagram group
            map.get(key).add(s);
        }

        // Return all grouped anagrams as a List of Lists
        return new ArrayList<>(map.values());
    }
}