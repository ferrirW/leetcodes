import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class RemoveDuplicateLetters {
    private static String s = "acba";
    private static String s1 = "cbacdcbc";

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] ++;
        }

        boolean[] inStack = new boolean[256];
        for (char ch : s.toCharArray()) {
            count[ch] --;
            if (inStack[ch]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch) {
                if (count[stack.peek()] == 0) {
                    break;
                }

                inStack[stack.pop()] = false;
            }

            stack.push(ch);
            inStack[ch] = true;
            System.out.println(stack);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(s));
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(s1));
    }
}
