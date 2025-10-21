class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;
        Set<String> vis = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.add(s);
        vis.add(s);
        boolean fnd = false;
        while(!que.isEmpty()) {
            String cur = que.poll();
            if(isV(cur)) {
                res.add(cur);
                fnd = true;
            }
            if(fnd) continue;
            for(int i = 0; i < cur.length(); i++) {
                if(cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                String nxt = cur.substring(0, i) + cur.substring(i + 1);
                if(!vis.contains(nxt)) {
                    que.add(nxt);
                    vis.add(nxt);
                }
            }
        }
        return res;
    }
    
    private boolean isV(String s) {
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') cnt++;
            else if(c == ')') {
                cnt--;
                if(cnt < 0) return false;
            }
        }
        return cnt == 0;
    }
}