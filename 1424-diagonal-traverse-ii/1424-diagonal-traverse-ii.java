class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int ma = 0, cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            for (int j =0; j<row.size(); j++) {
                int k =i+j;
                map.putIfAbsent(k, new ArrayList<>());
                map.get(k).add(row.get(j));
                ma = Math.max(ma, k);
                cnt++;
            }
        }
        
        int[] res = new int[cnt];
        int idx=0;
        for (int k =0; k <= ma; k++) {
            List<Integer> list = map.get(k);
            if (list != null) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    res[idx++] = list.get(i);
                }
            }
        }
        return res;
    }
}