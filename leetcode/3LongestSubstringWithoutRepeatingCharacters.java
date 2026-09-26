class 3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, 0);
        }

        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.get(c) + 1);
            while (map.get(c) == 2) {
                char ch = s.charAt(left++);
                map.put(ch, map.get(ch) - 1);
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}