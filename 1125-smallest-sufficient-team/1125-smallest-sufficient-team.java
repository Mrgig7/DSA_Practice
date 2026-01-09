class Solution {
    public int[] smallestSufficientTeam(String[] req, List<List<String>>ppl) {
        int m=req.length,n=ppl.size();
        Map<String, Integer> mp=new HashMap<>();
        for (int i=0; i<m; i++)mp.put(req[i], i);

        int[] ps=new int[n];
        for (int i=0;i<n;i++){
            int mk=0;
            for (String s:ppl.get(i))mk|=1<<mp.get(s);
            ps[i]=mk;
        }
        int f=1<<m;
        long[] dp=new long[f];
        int[] sz=new int[f];
        Arrays.fill(sz, 1_000_000);
        sz[0]=0;
        for (int i=0;i<n;i++){
            int pm=ps[i];
            if (pm==0)continue;
            for (int ms=0;ms<f;ms++){
                if (sz[ms]==1_000_000)continue;
                int nm=ms|pm;
                long nt=dp[ms]|(1L<<i);
                int ns=sz[ms]+1;
                if (ns<sz[nm]){
                    sz[nm]=ns;
                    dp[nm]=nt;
                }
            }
        }
        long tm=dp[f-1];
        int[] ans=new int[sz[f-1]];
        int k=0;
        for (int i=0;i<n;i++)if(((tm>>i)&1L)!=0)ans[k++]=i;
        return ans;
    }
}
