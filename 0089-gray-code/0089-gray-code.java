class Solution {
    public List<Integer> grayCode(int n) {
        int sz=1<<n;
        List<Integer>res=new ArrayList<>(sz);
        for (int i=0;i<sz;i++)res.add(i^(i>>1));
        return res;
    }
}
