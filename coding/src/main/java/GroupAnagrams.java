import java.util.*;

public class GroupAnagrams {

    private static String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

    public Collection<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(strings));
    }
}
