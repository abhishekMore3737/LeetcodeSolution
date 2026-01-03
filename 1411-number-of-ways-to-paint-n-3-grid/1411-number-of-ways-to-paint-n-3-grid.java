class Solution {
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        double A = 6, B = 6;
        
        for (int i = 2; i <= n; i++) {
            double a = (2 * A + 2 * B) % MOD;
            double b = (2 * A + 3 * B) % MOD;
            A = a;
            B = b;
        }
        
        return (int) ((A + B) % MOD);
    }
}