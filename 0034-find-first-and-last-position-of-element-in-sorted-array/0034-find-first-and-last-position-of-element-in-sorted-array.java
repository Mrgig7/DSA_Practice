class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0) return res;
        res[0] = fnd(nums, target, true);
        if(res[0] == -1) return res;
        res[1] = fnd(nums, target, false);
        return res;
    }
    
    private int fnd(int[] num, int tar, boolean lft) {
        int lo = 0, hi = num.length - 1;
        int idx = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(num[mid] == tar) {
                idx = mid;
                if(lft) hi = mid - 1;
                else lo = mid + 1;
            }
            else if(num[mid] < tar) lo = mid + 1;
            else hi = mid - 1;
        }
        return idx;
    }
}