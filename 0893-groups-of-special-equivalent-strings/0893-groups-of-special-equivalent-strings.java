class Solution {
    public int numSpecialEquivGroups(String[] w) {
        HashSet<String>st=new HashSet<>();
        for (String s:w){
            int[] ev=new int[26],od=new int[26];
            for (int i=0;i<s.length();i++) {
                int c=s.charAt(i)-'a';
                if((i&1)==0)ev[c]++;
                else od[c]++;
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<26;i++)sb.append(ev[i]).append(',');
            sb.append('|');
            for(int i=0;i<26;i++)sb.append(od[i]).append(',');
            st.add(sb.toString());
        }
        return st.size();
    }
}
