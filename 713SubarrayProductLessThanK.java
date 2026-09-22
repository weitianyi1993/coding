class 713SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int right = 0;
        int left = 0;
        int curr = 1;
        while (right < n) {
            curr = curr * nums[right];
            while (left <= right && curr >= k) {
                curr = curr / nums[left++];
            }
            res += (right - left) + 1;
            right++;
        }
        return res;
    }
}