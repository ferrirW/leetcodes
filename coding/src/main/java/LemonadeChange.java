import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright 2020, Xiaomi.
 * All rights reserved.
 *
 * @Author: wangfan8@xiaomi.com
 */

public class LemonadeChange {

  private static int[] bills = {5,5,5,10,20};
  private static int[] bills2 = {5,5,10};
  private static int[] bills3 = {10,10};
  private static int[] bills4 = {5,5,10,10,20};
  private static int[] bills5 = {5,5,5,5,20,20,5,5,20,5};

  public boolean lemonadeChange(int[] bills) {
    Map<Integer, AtomicInteger> tmp = new HashMap<>();
    tmp.put(5, new AtomicInteger(0));
    tmp.put(10, new AtomicInteger(0));
    tmp.put(20, new AtomicInteger(0));
    for (int bill : bills) {
      switch (bill) {
        case 5:
          tmp.get(5).getAndIncrement();
          break;
        case 10:
          if (tmp.get(5).get() < 1) {
            return false;
          }
          tmp.get(5).getAndDecrement();
          tmp.get(10).getAndIncrement();
          break;
        case 20:
          if (tmp.get(5).get() >= 1 && tmp.get(10).get() >= 1) {
            tmp.get(5).decrementAndGet();
            tmp.get(10).decrementAndGet();
            tmp.get(20).getAndIncrement();
          } else if (tmp.get(5).get() >= 3) {
            int n = tmp.get(5).get();
            tmp.get(5).set(n - 3);
            tmp.get(20).getAndIncrement();
          } else {
            return false;
          }
          break;
        default:

      }
      System.out.println(tmp);

    }
    return true;
  }

  public static void main(String[] args) {
    LemonadeChange lemonadeChange = new LemonadeChange();
//    System.out.println(lemonadeChange.lemonadeChange(bills));
//    System.out.println(lemonadeChange.lemonadeChange(bills2));
//    System.out.println(lemonadeChange.lemonadeChange(bills3));
    System.out.println(lemonadeChange.lemonadeChange(bills5));
  }
}
