import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FindTheDifference {

    private static String s1 = "abcd";
    private static String t1 = "abcde";

    public char findTheDifference(String s, String t) {
        Map<Character, AtomicInteger> res = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!res.containsKey(ch)) {
                res.put(ch, new AtomicInteger(0));
            }
            res.get(ch).getAndIncrement();
        }

        for (char c : t.toCharArray()) {
            if (!res.containsKey(c)) {
                return c;
            }
            res.get(c).decrementAndGet();
        }

        for (Map.Entry<Character, AtomicInteger> entry : res.entrySet()) {
            if (entry.getValue().get() != 0) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        FindTheDifference findTheDifference = new FindTheDifference();
        System.out.println(findTheDifference.findTheDifference(s1, t1));
    }
}
