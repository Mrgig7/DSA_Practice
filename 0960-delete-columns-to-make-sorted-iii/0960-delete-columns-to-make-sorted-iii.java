class Solution {
    public int minDeletionSize(String[] st) {
        int n=st.length,m=st[0].length();
        char[][]ch=new char[n][];
        for (int i=0;i<n;i++)ch[i]=st[i].toCharArray();
        boolean[][]ok=new boolean[m][m];
        for (int i=0;i<m;i++){
            for (int j=i+1;j<m;j++){
                boolean gd=true;
                for (int r=0;r<n;r++)if (ch[r][i]>ch[r][j]){gd=false;break;}
                ok[i][j]=gd;
            }
        }
        int[] dp=new int[m];
        int bst=0;
        for (int j=0;j<m;j++){
            int mx=1;
            for (int i=0;i<j;i++)if(ok[i][j])mx=Math.max(mx,dp[i]+1);
            dp[j]=mx;
            if (mx>bst)bst=mx;
        }
        return m-bst;
    }
}
