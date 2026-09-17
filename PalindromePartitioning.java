class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(res, path, s, 0);
        return res;
    }

    // private void backtrack(List<List<String>> res, List<String> path, String s, int start, int index) {

    //     if (index == s.length()) {
    //         if (start == s.length()) {
    //             res.add(new ArrayList<>(path));
    //         }
    //         return;
    //     }

    //     // 不选
    //     backtrack(res, path, s, start, index + 1);

    //     // 选
    //     if (isPalindrome(s, start, index)) {
    //         path.add(s.substring(start, index + 1));
    //         backtrack(res, path, s, index + 1, index + 1);
    //         path.remove(path.size() - 1);
    //     }
    // }

    private void backtrack(List<List<String>> res, List<String> path, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (isPalindrome(s, start, i - 1)) {
                path.add(s.substring(start, i));
                backtrack(res, path, s, i);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}