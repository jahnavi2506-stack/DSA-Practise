Pattern Recognition:- Queue + sliding Window

BruteForce:- Checking old useless data again and again,Not removing anything. Each operation is O(n), so total becomes O(n²) in worst case

Since timestamps are strictly increasing, I use a queue to maintain a sliding window. For each ping, 
I add the timestamp and remove all elements older than t - 3000 from the front. The queue size then gives the number of valid requests.



class RecentCounter {

    // Queue to store timestamps of recent pings
    Queue<Integer> q;

    // Constructor → initialize queue
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {

        // Step 1: Add current timestamp to queue
        // This represents a new request coming in at time t
        q.add(t);

        // Step 2: Remove outdated timestamps
        // Condition: keep only those timestamps in range [t - 3000, t]
        // If (t - oldest_time) > 3000 → it is OUTSIDE window → remove it
        while (!q.isEmpty() && t - q.peek() > 3000) {
            q.poll(); // remove oldest element
        }

        // Step 3: Remaining queue contains only valid requests
        // Return count of valid pings
        return q.size();
    }
}

