class Solution {
    public int minAnagramLength(String s) {
        int n = s.length();
        int[][] pre = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            System.arraycopy(pre[i], 0, pre[i + 1], 0, 26);
            int c = s.charAt(i) - 'a';
            pre[i + 1][c]++;
        }
        int[] tot = pre[n].clone();
        List<Integer> div = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                div.add(i);
                if (i != n / i) div.add(n / i);
            }
        }
        Collections.sort(div);
        for (int k : div) {
            int m = n / k;
            boolean ok = true;
            for (int c = 0; c < 26; c++) {
                if (tot[c] % m != 0) {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;
            int[] bas = new int[26];
            for (int c = 0; c < 26; c++)bas[c] = pre[k][c] - pre[0][c];
            boolean val = true;
            for (int i = 1; i < m; i++) {
                int st = i * k;
                for (int c = 0; c < 26; c++) {
                    if (pre[st + k][c] - pre[st][c] != bas[c]) {
                        val = false;
                        break;
                    }
                }
                if (!val) break;
            }
            if (val) return k;
        }
        return n;
    }
}