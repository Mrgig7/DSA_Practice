class Solution {
    public int numSpecialEquivGroups(String[] w) {
        HashSet<String> st=new HashSet<>();
        for (String s:w){
            int[] ev=new int[26],od=new int[26];
            for (int i=0;i<s.length();i++) {
                int c=s.charAt(i)-'a';
                if((i&1)==0)ev[c]++;
                else od[c]++;
            }
            char[] k=new char[52];
            for (int i=0;i<26;i++)k[i]=(char)(ev[i]+'0'); 
            for (int i=0;i<26;i++)k[i+26]=(char)(od[i]+'0'); 
            st.add(new String(k));
        }
        return st.size();
    }
}
