Pattern Recognition: HashMap

Brute Force: Pick one element and compare it with every other element. Count its occurrences.
Mark visited elements so they aren't counted again. Time: O(n²), Space: O(n) (visited array)

Optimal: Traverse the array once.
Store each element and its count in a HashMap. Print every key with its frequency. Time: O(n), Space: O(n)


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();

        // Create array
        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        /*
         * HashMap stores:
         * Key   -> Array element
         * Value -> Frequency (number of occurrences)
         */
        HashMap<Integer, Integer> map = new HashMap<>();

        /*
         * Count frequency of each element
         *
         * getOrDefault(num, 0)
         * -> If num exists, return its current frequency.
         * -> Otherwise, return 0.
         *
         * Then increase frequency by 1 and store it back.
         */
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /*
         * entrySet() gives all key-value pairs.
         *
         * Each iteration:
         * entry.getKey()   -> Element
         * entry.getValue() -> Frequency
         */
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            System.out.println(
                    entry.getKey() + " occurs " +
                    entry.getValue() + " times"
            );
        }

        sc.close();
    }
}