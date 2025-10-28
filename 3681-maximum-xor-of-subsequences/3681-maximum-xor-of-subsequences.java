class Solution {
    public int maxXorSubsequences(int[] nums) {
        int[] arr=new int[32];
        for (int x:nums) {
            for (int i=31;i>=0;i--){
                if(((x>>i)&1)==1){
                    if(arr[i]==0){
                        arr[i]=x;
                        break;
                    }else x ^= arr[i];
                }
            }
        }
        int r=0;
        for (int i=31;i>=0;i--) {
            if ((r^arr[i])>r) {
                r^=arr[i];  
            }
        }
        return r;
    }
}