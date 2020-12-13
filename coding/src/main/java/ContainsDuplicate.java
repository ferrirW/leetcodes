import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ContainsDuplicate {

    private static int[] nums = {1,2,3,1};
    private static int[] nums2 = {1,2,3,4};
    private static int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
    private static int[] nums4 = {3,3};
    private static int[] nums5 = {1,5,-2,-4,0};

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, AtomicInteger> res = new HashMap<>();
        for (int num : nums) {
            if (res.get(num) == null) {
                res.put(num, new AtomicInteger(0));
            }

            res.get(num).getAndIncrement();
            if (res.get(num).get() > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(nums));
        System.out.println(containsDuplicate.containsDuplicate(nums2));
        System.out.println(containsDuplicate.containsDuplicate(nums3));
        System.out.println(containsDuplicate.containsDuplicate(nums4));
        System.out.println(containsDuplicate.containsDuplicate(nums5));
    }
}
