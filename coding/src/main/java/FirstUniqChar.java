public class FirstUniqChar {

    private static String s = "leetcode";
    private static String s1 = "loveleetcode";
    private static String s2 = "cc";
    private static String s3 = "z";

    public int firstUniqChar(String s) {
        int[] arr = new int[256];
        int first = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (arr[s.charAt(i)] == 0) {
                first = i;
                arr[s.charAt(i)] = i;
            }
        }
        if (first == s.length() - 1 && s.length() > 1) {
            first = -1;
        }
        return first;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar(s));
        System.out.println(firstUniqChar.firstUniqChar(s1));
        System.out.println(firstUniqChar.firstUniqChar(s2));
        System.out.println(firstUniqChar.firstUniqChar(s3));
    }
}
