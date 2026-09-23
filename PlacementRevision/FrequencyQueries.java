//HackerRank
Pattern Recognition: two-frequency-map / reverse-frequency pattern

Brute Force: Store element → frequency; for every type-3 query, scan all elements to find frequency f.
Insert/delete: O(1) average; type-3: O(n).
Overall: O(q²) worst case, Space: O(q).

Optimal: Maintain freq[x] and freqCount[f]; whenever x's frequency changes, move it from the old frequency bucket to the new one.
For 3 f, simply check freqCount[f] > 0.
Time: O(q) average, Space: O(q).

import java.util.*;

class Result {

    public static List<Integer> freqQuery(List<List<Integer>> queries) {

        // Map 1:
        // Stores how many times each actual number occurs.
        //
        // Example:
        // 5 -> 2 means number 5 occurs 2 times.
        Map<Integer, Integer> frequency = new HashMap<>();

        // Map 2:
        // Stores how many DISTINCT numbers have a particular frequency.
        //
        // Example:
        // frequencyCount[2] = 3
        // means 3 different numbers occur exactly 2 times.
        Map<Integer, Integer> frequencyCount = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for (List<Integer> query : queries) {

            int operation = query.get(0);
            int value = query.get(1);

            // ------------------------------------------------
            // OPERATION 1: Insert value
            // ------------------------------------------------
            if (operation == 1) {

                // Current frequency of value.
                int oldFreq = frequency.getOrDefault(value, 0);

                // The frequency increases by 1.
                int newFreq = oldFreq + 1;

                // If value already had a frequency,
                // remove it from its OLD frequency bucket.
                if (oldFreq > 0) {
                    frequencyCount.put(
                        oldFreq,
                        frequencyCount.get(oldFreq) - 1
                    );
                }

                // Update the actual frequency of value.
                frequency.put(value, newFreq);

                // Add value to its NEW frequency bucket.
                frequencyCount.put(
                    newFreq,
                    frequencyCount.getOrDefault(newFreq, 0) + 1
                );
            }

            // ------------------------------------------------
            // OPERATION 2: Delete one occurrence of value
            // ------------------------------------------------
            else if (operation == 2) {

                // Get current frequency.
                int oldFreq = frequency.getOrDefault(value, 0);

                // Only delete if the value actually exists.
                if (oldFreq > 0) {

                    // Remove value from its old frequency bucket.
                    frequencyCount.put(
                        oldFreq,
                        frequencyCount.get(oldFreq) - 1
                    );

                    // Frequency decreases by 1.
                    int newFreq = oldFreq - 1;

                    // If frequency becomes 0,
                    // the value no longer exists in our data structure.
                    if (newFreq == 0) {
                        frequency.remove(value);
                    }
                    else {
                        // Otherwise update its frequency.
                        frequency.put(value, newFreq);

                        // Put value into its new frequency bucket.
                        frequencyCount.put(
                            newFreq,
                            frequencyCount.getOrDefault(newFreq, 0) + 1
                        );
                    }
                }
            }

            // ------------------------------------------------
            // OPERATION 3: Check whether any number occurs
            // exactly 'value' times.
            // ------------------------------------------------
            else if (operation == 3) {

                // We don't scan all numbers.
                //
                // Just check whether at least one number
                // belongs to this frequency bucket.
                if (frequencyCount.getOrDefault(value, 0) > 0) {
                    result.add(1);
                }
                else {
                    result.add(0);
                }
            }
        }

        return result;
    }
}