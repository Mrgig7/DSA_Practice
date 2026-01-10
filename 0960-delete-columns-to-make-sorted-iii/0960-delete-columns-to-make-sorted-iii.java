class Solution {
    public int minDeletionSize(String[] st) {
        int n=st.length,m=st[0].length();
        int[] dp=new int[m];
        int bst=0;
        for (int j=0;j<m;j++){
            dp[j]=1;
            for (int i=0;i<j;i++){
                boolean ok=true;
                for (int r=0;r<n;r++){
                    if (st[r].charAt(i)>st[r].charAt(j)){ok=false;break;}
                }
                if (ok)dp[j]=Math.max(dp[j],dp[i]+1);
            }
            bst=Math.max(bst,dp[j]);
        }
        return m-bst;
    }
}