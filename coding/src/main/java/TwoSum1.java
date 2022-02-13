public class TwoSum1 {

    public static int[] solution(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    System.out.println(i + ": " + j);
                    return new int[]{i, j};
                }

            }
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
        int[] nums = new int[]{3,2,4};
//        int target = 9;
        int target = 6;

        System.out.println(solution(nums, target));
    }
}
