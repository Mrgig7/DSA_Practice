class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frq=new int[26];
        for (char t : tasks) frq[t - 'A']++;
        int ma=0,cnt=0;
        for (int f:frq) ma = Math.max(ma,f);    
        for (int f:frq) if (f==ma) cnt++;
        int ga=(ma-1)*(n+1)+cnt;
        return Math.max(ga,tasks.length);
    }
}