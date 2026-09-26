class 494TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        target = Math.abs(target);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        target += sum;
        if (target % 2 == 1) return 0;
        target = target / 2;
        
        int[][] memo = new int[nums.length + 1][target + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs(nums, nums.length - 1, target, memo);
    }

    private int dfs(int[] nums, int index, int target, int[][] memo) {
        if (index == -1) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (memo[index][target] != -1) {
            return memo[index][target];
        }

        if (target < nums[index]) {
            int ans = dfs(nums, index - 1, target, memo);
            memo[index][target] = ans;
            return ans;
        } else {
            int ans = dfs(nums, index - 1, target - nums[index], memo) + 
            dfs(nums, index - 1, target, memo);
            memo[index][target] = ans;
            return ans;
        }
    }
    
    
    public int findTargetSumWays2DDP(int[] nums, int target) {
        target = Math.abs(target);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        target += sum;
        // 如果 target < 0（加之前 abs 超大）或者不能整除 2，直接返回 0
        if (target < 0 || target % 2 == 1) return 0;
        target = target / 2;

        int n = nums.length;
        int[][] f = new int[2][target + 1];
        
        // 关键初始化：0 个数凑出和为 0 的方案数只有 1 种（即什么都不选）
        f[0][0] = 1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j <= target; j++) {
                f[(i + 1)%2][j] = f[i%2][j];
                if (x <= j) {
                    f[(i + 1)%2][j] += f[i%2][j - x];
                }
            }
        }

        // 答案就是用了前 n 个数，凑出总和为 target 的方案数
        return f[n%2][target];
    }
}