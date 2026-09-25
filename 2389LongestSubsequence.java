class 2389LongestSubsequence {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] result = new int[queries.length];
        int[] prefixSum = new int[nums.length];
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        int index = 0;
        //[4,5,2,1]
        //[1,3,7,12] -> [3,10,21]
        for (int i = 0; i < queries.length; i++) {
            int idx = Arrays.binarySearch(prefixSum, queries[i]);
            result[index++] = idx < 0 ? ~idx : idx + 1;
        }
        return result;
    }
}