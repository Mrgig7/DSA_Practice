class Solution {
    public int longestWPI(int[] hr) {
        int n = hr.length;
        int su = 0;
        int ma = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            su += hr[i] > 8 ? 1 : -1;
            if (su > 0)
                ma = i + 1;
            else {
                if (!map.containsKey(su))
                    map.put(su, i);
                if (map.containsKey(su - 1))
                    ma = Math.max(ma, i - map.get(su - 1));
            }
        }
        return ma;
    }
}