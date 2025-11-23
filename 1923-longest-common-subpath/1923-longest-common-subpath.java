class Solution {
    public int longestCommonSubpath(int n, int[][] paths) {
        Map<Integer,Long> powerPrime=new HashMap();
        long prime=100007;
        long mod=100000000007L;
        int max=0,min=0;
        for(int i=0;i<paths.length;i++){
            max=Math.max(paths[i].length,max);
        }
        powerPrime.put(0,1L);
        for(int i=1;i<=max;i++){
            long curPrime=(powerPrime.get(i-1)*prime)%mod;
            powerPrime.put(i,curPrime);
        }
        int st=1,en=max,ans=0;
        while(st<=en){
            int mid=(st+en)/2;
            if(checkIfKLengthCommonPath(paths,mid,powerPrime,prime,mod)){
                ans=mid;
                st=mid+1;
            }else{
                en=mid-1;
            }
        }
        return ans;
    }
    private boolean checkIfKLengthCommonPath(int[][] paths,int k,Map<Integer,Long> powerPrime,long prime,long mod){
        long curSum=0L;
        HashSet<Long> hashOfContPath=new HashSet();
        for(int i=0;i<paths[0].length;i++){
            if(i<k){
                curSum*=prime;
                curSum%=mod;
                curSum+=paths[0][i];
                curSum%=mod;
                if(i==k-1){
                    hashOfContPath.add(curSum);
                }
            } else{
                curSum*=prime;
                curSum-=(powerPrime.get(k)*paths[0][i-k])%mod;
                if(curSum<0){
                    curSum+=mod;
                }
                curSum%=mod;
                curSum+=paths[0][i];
                curSum%=mod;
                hashOfContPath.add(curSum);
            }
        }
        for(int i=1;i<paths.length;i++){
            HashSet<Long> nexthashOfContPath=new HashSet();
            curSum=0L;
            for(int j=0;j<paths[i].length;j++){
                if(j<k){
                    curSum*=prime;
                    curSum%=mod;
                    curSum+=paths[i][j];
                    curSum%=mod;
                    if(j==k-1 && hashOfContPath.contains(curSum)){
                        nexthashOfContPath.add(curSum);
                    }
                } else {
                curSum*=prime;
                curSum-=(powerPrime.get(k)*paths[i][j-k])%mod;
                if(curSum<0){
                    curSum+=mod;
                }
                curSum%=mod;
                curSum+=paths[i][j];
                curSum%=mod;
                    if(hashOfContPath.contains(curSum)){
                        nexthashOfContPath.add(curSum);
                    }
                }
            }
            hashOfContPath=nexthashOfContPath;
        }
        if(hashOfContPath.size()>0){
            return true;
        }
        return false;
    }
}