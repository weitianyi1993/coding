class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(res, path, nums, used);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtrack(res, path, nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}