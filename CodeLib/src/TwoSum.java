import java.util.*;

public class TwoSum {
    public static int[] Sum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public static int[] Sum2(int[] nums, int target) {
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            sumMap.put(nums[i], i);
        }
        //&&
        for (int i = 0; i < sumMap.size(); ++i) {
            int otherNum = target - nums[i];
            if (sumMap.containsKey(otherNum) && sumMap.get(otherNum) != i) {
                return new int[]{i, sumMap.get(otherNum)};
            }
        }
        throw new IllegalArgumentException();
    }

    public static int[] Sum3(int[] nums, int target) {
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int otherNum = target - nums[i];
            if (sumMap.containsKey(otherNum)) {
                return new int[]{i, sumMap.get(otherNum)};
            }
            sumMap.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.printf("%d, %d\n", Sum(nums, target)[0], Sum(nums, target)[1]);
        System.out.printf("%d, %d\n", Sum2(nums, target)[0], Sum2(nums, target)[1]);
        System.out.printf("%d, %d\n", Sum3(nums, target)[0], Sum3(nums, target)[1]);
    }
}


