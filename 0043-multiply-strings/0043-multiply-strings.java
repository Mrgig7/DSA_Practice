class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2;
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + arr[p2];
                arr[p2] = sum % 10;
                arr[p1] += sum / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int val : arr) if(!(sb.length() == 0 && val == 0)) sb.append(val);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}