class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int lft = 0, rgt = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '(') lft++;
            else if(c == ')') {
                if(lft > 0) lft--;
                else rgt++;
            }
        }
        Set<String> set = new HashSet<>();
        dfs(s, 0, lft, rgt, 0, new StringBuilder(), set);
        res.addAll(set);
        return res;
    }
    
    private void dfs(String s, int idx, int lft, int rgt, int opn, StringBuilder sb, Set<String> set) {
        if(idx == s.length()) {
            if(lft == 0 && rgt == 0 && opn == 0) set.add(sb.toString());
            return;
        }
        char c = s.charAt(idx);
        int len = sb.length();
        if(c == '(' && lft > 0) dfs(s, idx + 1, lft - 1, rgt, opn, sb, set);
        if(c == ')' && rgt > 0) dfs(s, idx + 1, lft, rgt - 1, opn, sb, set);
        sb.append(c);
        if(c != '(' && c != ')') dfs(s, idx + 1, lft, rgt, opn, sb, set);
        else if(c == '(') dfs(s, idx + 1, lft, rgt, opn + 1, sb, set);
        else if(opn > 0) dfs(s, idx + 1, lft, rgt, opn - 1, sb, set);
        sb.setLength(len);
    }
}