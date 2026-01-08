class Solution {
    public long maxRunTime(int n, int[] b) {
        long l=0,r=0;
        for (int x:b)r+=x;
        r/=n;
        while (l<r){
            long m=(l+r+1)>>1;
            long s=0;
            for (int x:b)s+=Math.min(x,m);
            if (s>=m*n)l=m;
            else r=m-1;
        }
        return l;
    }
}
