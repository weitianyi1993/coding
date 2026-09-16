class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(res, path, 1, n, k);
        return res;
    }

    // 1. 选或者不选
    // private void backtrack(List<List<Integer>> res, List<Integer> path, int curr, int n, int k) {
    //     if (path.size() == k) {
    //         res.add(new ArrayList<>(path));
    //         return;
    //     }

    //     if (curr == n + 1) {
    //         return;
    //     }

    //     backtrack(res, path, curr + 1, n, k);

    //     path.add(curr);
    //     backtrack(res, path, curr + 1, n, k);
    //     path.remove(path.size() - 1);
    // }

    // 2. 看结果
    private void backtrack(List<List<Integer>> res, List<Integer> path, int curr, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = curr; i <= n; i++) {
            path.add(i);
            backtrack(res, path, i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}