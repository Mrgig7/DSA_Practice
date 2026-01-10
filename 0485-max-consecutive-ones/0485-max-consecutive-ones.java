class Solution {
    public int findMaxConsecutiveOnes(int[] a) {
        int bst=0,cur=0;
        for (int x:a){if (x==1){cur++;if (cur>bst)bst=cur;}
            else cur=0;}
        return bst;
    }
}
