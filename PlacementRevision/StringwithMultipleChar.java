Pattern Recognition: Run Length Encoding (RLE) 



public class StringCompression {

    // Function to compress the string
    public static String compress(String str) {

        // Handles empty string
        if (str == null || str.length() == 0) {
            return "";
        }

        // Stores the compressed result
        StringBuilder ans = new StringBuilder();

        int i = 0;

        // Traverse the string
        while (i < str.length()) {

            // Current character
            char current = str.charAt(i);

            // Count starts with 1 because current character is already included
            int count = 1;

            // Count consecutive repeated characters
            while (i + count < str.length() &&
                   str.charAt(i) == str.charAt(i + count)) {
// While there is a next character, and that next character is the same as the leader, keep counting
                count++;
            }

            // Append character
            ans.append(current);

            // Append count only if frequency > 1
            if (count > 1) {
                ans.append(count);
            }

            // Skip the entire group
            i = i + count;
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String str = "aabbbbeeeeffggg";

        System.out.println(compress(str));

    }
}

Keep the leader fixed (i) and use count to look ahead for consecutive same characters.
While the next character exists and is the same as the leader, increase count.
After counting, append the leader (current) to the answer.
If count > 1, append the count; otherwise, append nothing (don't write a1).
Jump i by count (i += count) because the entire group has already been processed.


input: aabbb  Output: a2b3
| Feature           | Capgemini Problem         | LeetCode 443                       |
| ----------------- | ------------------------- | ---------------------------------- |
| Input             | String                    | Character array (`char[]`)         |
| Output            | Compressed string         | New length of compressed array     |
| Extra Space       | Allowed (`StringBuilder`) | Not allowed (must modify in-place) |
| Write Pointer     | ❌ Not needed              | ✅ Required                         |
| Return Type       | `String`                  | `int`                              |
| Interview Pattern | RLE using `i + count`     | Two Pointers (`read` + `write`)    |
