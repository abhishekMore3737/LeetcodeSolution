class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] min_prefix = new long[k];
        for (int i = 0; i < k; i++){
            min_prefix[i] = Long.MAX_VALUE / 2;
        }
        long prefix = 0;
        long res = Long.MIN_VALUE;
        min_prefix[k -1] = 0;
        for (int i = 0; i < n; i++){
            prefix += nums[i];
            long mod_min = min_prefix[i % k];
            res = Math.max(res, prefix - mod_min);
            mod_min = Math.min(prefix, mod_min);
            min_prefix[i % k] = mod_min;
        }
        return res;
    }
}