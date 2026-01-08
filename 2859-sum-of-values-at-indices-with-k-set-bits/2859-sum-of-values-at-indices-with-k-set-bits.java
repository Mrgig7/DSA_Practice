class Solution {
    public int sumIndicesWithKSetBits(List<Integer>a,int k) {
        int s=0;
        for (int i=0; i<a.size(); i++)if (Integer.bitCount(i)==k)s+=a.get(i);
        return s;
    }
}
