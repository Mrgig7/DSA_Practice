class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Map<Integer, Integer> numAndLastIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int div = valueDiff == 0 ? 1 : valueDiff;
            int l = valueDiff == 0 ? nums[i] : nums[i] / valueDiff - 1;
            int r = valueDiff == 0 ? nums[i] : nums[i] / valueDiff + 1;
            for (int j = l; j <= r; j++) {
                if (numAndLastIndex.containsKey(j)) if (Math.abs(nums[i] - nums[numAndLastIndex.get(j)]) <= valueDiff && i - numAndLastIndex.get(j) <= indexDiff) return true;
            }
            numAndLastIndex.put(nums[i] / div, i);
        }
        return false;
    }
}