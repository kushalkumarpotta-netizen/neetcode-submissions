class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> nums1 = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            nums1.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];

            if(nums1.containsKey(temp) && nums1.get(temp) != i) {
                return new int[]{i, nums1.get(temp)};
            }
        }

        return new int[]{};
    }
}