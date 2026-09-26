class 42TrappingRainWater {
    // public int trap(int[] height) {
    //     int n = height.length;
    //     int[] premax = new int[n];
    //     int[] sufmax = new int[n];
    
    //     int max = 0;
    //     for (int i = 0; i < n; i++) {
    //         max = Math.max(max, height[i]);
    //         premax[i] = max;
    //     }
    //     max = 0;
    //     for (int i = n - 1; i >= 0; i--) {
    //         max = Math.max(max, height[i]);
    //         sufmax[i] = max;
    //     }

    //     int sum = 0;
    //     for (int i = 0; i < n; i++) {
    //         sum += Math.min(premax[i], sufmax[i]) - height[i];
            
    //     }
    //     return sum;
    // }
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int premax = 0;
        int sufmax = 0;
        int sum = 0;
        while (left <= right) {
            // premax = Math.max(premax, height[left]);
            // sufmax = Math.max(sufmax, height[right]);
            // if (premax <= sufmax) {
            //     sum += premax - height[left++];
            // } else {
            //     sum += sufmax - height[right--];
            // }
            // 1. 先用历史最高挡板判定并算水
            if (premax <= sufmax) {
                if (height[left] < premax) {
                    sum += premax - height[left]; // 矮于历史墙，积水
                } else {
                    premax = height[left];        // 成为新的历史墙，不积水
                }
                left++;
            } else {
                if (height[right] < sufmax) {
                    sum += sufmax - height[right];
                } else {
                    sufmax = height[right];
                }
                right--;
            }
        }
        return sum;
    }
}