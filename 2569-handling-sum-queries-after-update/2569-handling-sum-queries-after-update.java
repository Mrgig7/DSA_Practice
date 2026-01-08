class Solution {
    int[] cnt,lz;
    int n;
    void bld(int i,int l,int r,int[] a) {
        if (l==r){
            cnt[i]=a[l];
            return;
        }
        int m=(l+r)>>1;
        bld(i<<1,l,m,a);
        bld(i<<1|1,m+1,r,a);
        cnt[i]=cnt[i<<1]+cnt[i<<1|1];
    }
    void app(int i,int l,int r){
        cnt[i]=(r-l+1)-cnt[i];
        lz[i]^=1;
    }
    void psh(int i,int l,int r){
        if (lz[i]==0)return;
        int m=(l+r)>>1;
        app(i<<1,l,m);
        app(i<<1|1,m+1,r);
        lz[i]=0;
    }
    void upd(int i,int l,int r,int ql,int qr){
        if (ql>r||qr<l)return;
        if (ql<=l&&r<=qr){
            app(i,l,r);
            return;
        }
        psh(i,l,r);
        int m=(l+r)>>1;
        upd(i<<1,l,m,ql,qr);
        upd(i<<1|1,m+1,r,ql,qr);
        cnt[i]=cnt[i<<1]+cnt[i<<1|1];
    }
    public long[] handleQuery(int[] a, int[] b, int[][] q) {
        n=a.length;
        cnt=new int[4*n];
        lz=new int[4*n];
        bld(1,0,n-1,a);
        long sum=0;
        for (int x:b) sum+=x;
        int k=0;
        for (int[] x:q)if (x[0]==3)k++;
        long[] res=new long[k];
        int idx=0;
        for (int[] x:q){
            if (x[0]==1)upd(1,0,n-1,x[1],x[2]);
            else if (x[0]==2)sum+=(long)cnt[1]*x[1];
            else res[idx++]=sum;
        }
        return res;
    }
}
