Pattern Recognition: Stable Partition / Read-Write Pointer

Brute Force: Create two strings: one for # and another for remaining characters.
Traverse the string once and append accordingly. Concatenate both strings.
Time  : O(n²)   (using String + character repeatedly),Space : O(n)

Better Approach: Count the number of #.
Append # using StringBuilder.
Traverse again and append all non-# characters. Time  : O(n),Space : O(n)

Optimal: Convert string into char[].
Count #, then copy non-# characters from index hashCount.
Fill the first hashCount positions with #. Time  : O(n), Space : O(1) extra

import java.util.*;

public class MoveHash {

    // Function to move all '#' to the beginning
    public static String moveHash(String str) {

        // StringBuilder is used to efficiently build the answer
        StringBuilder result = new StringBuilder();

        // Count total number of '#'
        int hashCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                hashCount++;
            }
        }

        // Append all '#' first
        for (int i = 0; i < hashCount; i++) {
            result.append('#');
        }

        // Append all remaining characters
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                result.append(str.charAt(i));
            }
        }

        // Convert StringBuilder to String
        return result.toString();
    }

    public static void main(String[] args) {

        // Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Read input string
        String str = sc.nextLine();

        // Print modified string
        System.out.println(moveHash(str));

        // Close scanner
        sc.close();
    }
}


public class MoveHash {

    // Function to move all '#' to the beginning
    public static String moveHash(String str) {

        // Convert String to character array
        char[] arr = str.toCharArray();

        // Count total number of '#'
        int hashCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '#') {
                hashCount++;
            }
        }

        // Next position to place a non-# character
        int insertIndex = hashCount;

        // Read each character
        for (int read = 0; read < arr.length; read++) {

            // Copy only non-# characters
            if (arr[read] != '#') {
                arr[insertIndex] = arr[read];
                insertIndex++;
            }
        }

        // Fill the beginning with '#'
        for (int i = 0; i < hashCount; i++) {
            arr[i] = '#';
        }

        // Convert character array back to String
        return new String(arr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(moveHash(str));

        sc.close();
    }
}
read scans every character one by one.
insertIndex tells us where to place the next non-# character.