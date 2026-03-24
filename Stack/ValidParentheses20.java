Need last opened bracket → stack
Need matching rule → hashmap
Need fast operations → deque
import java.util.Deque;
import java.util.HashMap;   
import java.util.Map;
import java.util.ArrayDeque;
class ValidParentheses20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}