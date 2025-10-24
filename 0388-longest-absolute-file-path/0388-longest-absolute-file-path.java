class Solution {
    public int lengthLongestPath(String input) {
        String[] lin = input.split("\n");
        int[] len = new int[lin.length + 1];
        int ma = 0;
        
        for(String s : lin) {
            int lvl = s.lastIndexOf("\t") + 1;
            int cur = s.length()-lvl;
            if(s.contains(".")) ma = Math.max(ma, len[lvl] + cur);
            else len[lvl + 1] = len[lvl] + cur + 1;
        }
        return ma;
    }
}