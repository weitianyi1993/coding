class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(res, path, nums, 0);
        return res;
    }

    // 
    // private void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
    //     if (index == nums.length) {
    //         res.add(new ArrayList<>(path));
    //         return;
    //     }


    //     // don't choose
    //     backtrack(res, path, nums, index + 1);

    //     // choose
    //     path.add(nums[index]);
    //     backtrack(res, path, nums, index + 1);
    //     path.remove(path.size() - 1);
    // }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
        
        res.add(new ArrayList<>(path));
        if (index == nums.length) return;

        

        // multiple branch tree
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}