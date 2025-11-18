class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        int tot0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') tot0++;
        }
        int tot1 = n - tot0;
        
        long ans = 0;
        int lft0 = 0, lft1 = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ans += (long) lft0 * (tot0 - lft0);
                lft1++;
            } else {
                ans += (long) lft1 * (tot1 - lft1);
                lft0++;
            }
        }
        
        return ans;
    }
}