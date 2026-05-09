Pattern Recognition:- Sorting + Custom Comparator

Brute Force:- Store names and heights together, then use simple comparison sorting (like bubble/selection sort) to repeatedly compare 
heights and swap both name + height together in descending order.
Time Complexity: O(n^2)
Space Complexity: O(1)

Optimal Approach:- Store each person as a pair/object (name,height) and use efficient custom sorting based on height in descending order,
 then extract names from sorted pairs.
Time Complexity: O(nlog n)
Space Complexity: O(n)

Since names and heights are related by index, I first combine them into a single structure representing a person. 
Then I sort this structure in descending order based on height. Finally, I extract the names from the sorted structure.

import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        // Step 1:
        // Create array of pairs -> (height, name)
        // We store both together so relation is not lost during sorting
        Pair[] arr = new Pair[names.length];

        for (int i = 0; i < names.length; i++) {
            arr[i] = new Pair(heights[i], names[i]);
        }

        // Step 2:
        // Sort pairs based on height in descending order
        Arrays.sort(arr, (a, b) -> b.height - a.height);

        // Step 3:
        // Extract names from sorted pairs
        String[] result = new String[names.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].name;
        }

        // Step 4:
        // Return final sorted names array
        return result;
    }
}

// Custom Pair class to store height + name together
class Pair {

    int height;
    String name;

    Pair(int height, String name) {
        this.height = height;
        this.name = name;
    }
}