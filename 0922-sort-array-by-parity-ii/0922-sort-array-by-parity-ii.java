class Solution {
    public int[] sortArrayByParityII(int[] a) {
        int n=a.length,i=0,j=1;
        while (i<n&&j<n){
            while(i<n&&(a[i]&1)==0)i+=2;
            while(j<n&&(a[j]&1)==1)j+=2;
            if(i<n&&j<n){
                int t=a[i];a[i]=a[j]; a[j]=t;
                i+=2;j+=2;
            }
        }
        return a;
    }
}
