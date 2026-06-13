Pattern Recognition: Simulation(simply given rules are used) + Modulus + conditional Building

Brute Force: Loop from 1 to n.
Use if-else if-else to check FizzBuzz, Fizz, Buzz, or the number.
Add the corresponding string to the result list. Time: O(n), Space: O(n)

Optimal: Loop from 1 to n and start with an empty string s.
Append "Fizz" if divisible by 3 and "Buzz" if divisible by 5.
If s is empty, use the number itself; then add s to the result list. Time: O(n), Space: O(n)

class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            String s = "";

            if (i % 3 == 0) {
                s += "Fizz";
            }

            if (i % 5 == 0) {
                s += "Buzz";
            }

            if (s.isEmpty()) {
                s = String.valueOf(i);
            }

            answer.add(s);
        }

        return answer;
    }
}
