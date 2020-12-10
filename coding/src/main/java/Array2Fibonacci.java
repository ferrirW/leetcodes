import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2020, Xiaomi.
 * All rights reserved.
 *
 * @Author: wangfan8@xiaomi.com
 */

public class Array2Fibonacci {

  private static String input = "5511816597";

  public List<Integer> solution(String S) {
    List<Integer> res = new ArrayList<Integer>();
    tst(S, res, 0);

    System.out.println(res);
    return res;
  }

  private boolean tst(String subs, List<Integer> result, int index) {
    if (index == subs.length() && result.size() >= 3) {
      return true;
    }

    for (int i = index; i < subs.length(); ++i) {
      String ns = subs.substring(index, i+1);
      if (ns.startsWith("0") && ns.length() > 1) {
        break;
      }
      int n;
      try {
         n = Integer.parseInt(ns);
      } catch (NumberFormatException e) {
        break;
      }

      int size = result.size();
      if (size >= 2 && n > result.get(size-1) + result.get(size-2)) {
        break;
      }

      if (size < 2 || n == result.get(size-1) + result.get(size-2)) {
        result.add(n);
        if (tst(subs, result, i+1)) {
          return true;
        }
        result.remove(result.size() - 1);
      }

    }

    return false;
  }

  private boolean isFibonacci(List<Integer> list) {
    for (int i = 0; i < list.size(); ++i) {
      if (i + 2 >= list.size()) {
        break;
      }

      if (list.get(i) + list.get(i+1) != list.get(i+2)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Array2Fibonacci array2Fibonacci = new Array2Fibonacci();
    array2Fibonacci.solution(input);

  }

//for (int range = 0; range < index; ++ range) {
//    if (index + loop > S.length()) {
//      break;
//    }
//
//    String subs = S.substring(index, index + loop);
//    if (subs.startsWith("0") && subs.length() > 1) {
//      break;
//    }
//
//    ttmp.add(Integer.parseInt(subs));
//  }
//
//        if (index == S.length()) {
//    tmp.add(ttmp);
//  }


}
