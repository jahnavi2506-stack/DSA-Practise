Pattern Recognition: HashMap + Two-way mapping.

| Problem wording                                  | Think                        |
| ------------------------------------------------ | ---------------------------- |
| Character → character mapping                    | HashMap                      |
| Same character must always map to same character | Map consistency              |
| No two characters can map to same character      | **Two HashMaps**             |
| Same pattern between two strings                 | Isomorphic pattern           |
| `s[i]` corresponds to `t[i]`                     | Traverse both simultaneously |

Brute Force
For every character in s, find its corresponding character in t and check whether the mapping is consistent.
Also check that no two different characters in s map to the same character in t.
Time: O(n²) | Space: O(1) (ASCII characters)

Optimal — Two HashMaps
Maintain two maps: s → t and t → s, and traverse both strings simultaneously.
If either mapping conflicts with an existing mapping, return false; otherwise create the mapping.
Time: O(n) | Space: O(1) (ASCII characters)

import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        // Map characters from s -> t
        HashMap<Character, Character> mapST = new HashMap<>();

        // Map characters from t -> s
        // This ensures two different characters don't map to the same character
        HashMap<Character, Character> mapTS = new HashMap<>();

        // Traverse both strings at the same time
        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            // Check s -> t mapping
            // If 'a' was already mapped to a different character, return false
            if (mapST.containsKey(a) && mapST.get(a) != b) {
                return false;
            }

            // Check t -> s mapping
            // If 'b' was already mapped to a different character, return false
            if (mapTS.containsKey(b) && mapTS.get(b) != a) {
                return false;
            }

            // Create the mappings
            mapST.put(a, b);
            mapTS.put(b, a);
        }

        // All mappings are valid
        return true;
    }
}