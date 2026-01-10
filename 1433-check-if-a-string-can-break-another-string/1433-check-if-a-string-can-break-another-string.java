class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] a=new int[26],b=new int[26];
        for (int i=0;i<s1.length();i++) {
            a[s1.charAt(i)-'a']++;
            b[s2.charAt(i)-'a']++;
        }
        int d=0;
        boolean g1=true,g2=true;
        for (int i=0;i<26;i++) {
            d+=a[i]-b[i];
            if (d<0)g1=false;
            if (d>0)g2=false;
        }
        return g1||g2;
    }
}
