class Solution {
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        int[] dlt=new int[2*limit+2];
        
        for(int i=0;i<n/2;i++){
            int a=nums[i],b=nums[n-1-i],sm=a+b,mn=Math.min(a,b),mx=Math.max(a,b);
            dlt[2]+=2;
            dlt[mn+1]-=1;
            dlt[sm]-=1;
            dlt[sm+1]+=1;
            dlt[mx+limit+1]+=1;
        }
        int cur = 0,res = n;
        for(int i=2;i<=2*limit;i++) {
            cur+=dlt[i];
            res=Math.min(res,cur);
        }
        return res;
    }
}