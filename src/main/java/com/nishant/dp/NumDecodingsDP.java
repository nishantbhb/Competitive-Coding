package com.nishant.dp;


class NumDecodingsDP {


    static public int numDecodings(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                int a = Integer.parseInt(s.substring(i, i + 2));
                dp[i] = (a <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(numDecodings("01101"));
    }

}