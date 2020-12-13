public class WiggleMaxLength {

    private static int[] nums = {1,7,4,9,2,5};
    private static int[] nums2 = {1,17,5,10,13,15,10,5,16,8};
    private static int[] nums3 = {1,2,3,4,5,6,7,8,9};
    private static int[] nums4 = {1,4,7,2,5};
    private static int[] nums5 = {1,7,4,5,5};
    private static int[] nums6 = {0,0};
    private static int[] nums7 = {0,0,0};

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;

    }

    public static void main(String[] args) {
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();
        System.out.println(wiggleMaxLength.wiggleMaxLength(nums));
        System.out.println(wiggleMaxLength.wiggleMaxLength(nums2));
        System.out.println(wiggleMaxLength.wiggleMaxLength(nums3));
        System.out.println(wiggleMaxLength.wiggleMaxLength(nums4));
        System.out.println(wiggleMaxLength.wiggleMaxLength(nums5));
        System.out.println(wiggleMaxLength.wiggleMaxLength(nums6));
        System.out.println(wiggleMaxLength.wiggleMaxLength(nums7));
    }



}
