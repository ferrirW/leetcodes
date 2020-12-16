import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2020, Xiaomi.
 * All rights reserved.
 *
 * @Author: wangfan8@xiaomi.com
 */

public class WordPattern {

  private static String pa1 = "abba";
  private static String s1 = "dog cat cat dog";

  private static String pa2 = "abba";
  private static String s2 = "dog cat cat fish";

  private static String pa3 = "aaaa";
  private static String s3 = "dog cat cat dog";

  private static String pa4 = "abba";
  private static String s4 = "dog dog dog dog";

  public boolean wordPattern(String pattern, String str) {
    Map<Character, String> ch2str = new HashMap<Character, String>();
    String[] item = str.split(" ");
    int len = item.length;
    if (pattern.length() != len) {
      return false;
    }

    for (int i = 0; i < len; i++) {
      char ch = pattern.charAt(i);
      if (!ch2str.containsKey(ch)) {
        if (!ch2str.containsValue(item[i])) {
          ch2str.put(ch, item[i]);
        } else {
          return false;
        }
      } else if (!ch2str.get(ch).equals(item[i])) {
        return false;
      }
    }
    return true;

  }



  public static void main(String[] args) {
    WordPattern wordPattern = new WordPattern();
    System.out.println(wordPattern.wordPattern(pa1, s1));;
    System.out.println(wordPattern.wordPattern(pa2, s2));;
    System.out.println(wordPattern.wordPattern(pa3, s3));;
    System.out.println(wordPattern.wordPattern(pa4, s4));;
  }
}
