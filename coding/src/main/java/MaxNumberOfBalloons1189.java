import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxNumberOfBalloons1189 {

    public static int maxNumberOfBalloons(String text) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);

        for (char key : text.toCharArray()) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }
        }

        if (map.containsValue(0)) {
            return 0;
        }

        int min = map.get('b');

        if (map.get('a') < min) {
            min = map.get('a');
        }

        if (map.get('l') / 2 < min) {
            min = map.get('l') / 2;
        }

        if (map.get('o') / 2 < min) {
            min = map.get('o') / 2;
        }

        if (map.get('n') < min) {
            min = map.get('n');
        }


        return map.values().stream().min(Integer::compareTo).get();
    }

    public static void main(String[] args) {

        System.out.println(maxNumberOfBalloons("nlaebolko"));
    }
}
