# Coding Exercises

Java coding exercises and a dependency-cycle checker, built with Gradle.

## Requirements

JDK 17 or newer. The Gradle Wrapper downloads and runs the pinned Gradle version, so a separate Gradle installation is not needed.

## Build and run

```sh
./gradlew build
./gradlew run
```

Application code is under `src/main/java/com/github/weitianyi1993/coding`. LeetCode solutions live in the `leetcode` package, and dependency graph utilities live in the `dependency` package.

## LeetCode Review List

Priority uses a 1–5 scale, where 5 is the highest. The two problems added today are rated 5; earlier additions start at 2. Update the level as review priorities change.

| Level | Region | Problem | Solution |
|---:|:---:|---|---|
| 5 | CN | 1871. 跳跃游戏 VII | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/JumpGameVII.java) · [LeetCode](https://leetcode.cn/problems/jump-game-vii/) |
| 5 | CN | 1793. 好子数组的最大分数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MaximumScoreOfAGoodSubarray.java) · [LeetCode](https://leetcode.cn/problems/maximum-score-of-a-good-subarray/) |
| 5 | CN | 26. 删除有序数组中的重复项 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/RemoveDuplicatesFromSortedArray.java) · [LeetCode](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/) |
| 5 | CN | 2444. 固定界限子数组的数目 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/CountSubarraysWithFixedBounds.java) · [LeetCode](https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/) |
| 5 | CN | 1574. 删除最短的子数组使剩余数组有序 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/ShortestSubarrayToBeRemovedToMakeArraySorted.java) · [LeetCode](https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/) |
| 4 | CN | 3936. 将 0 移到末尾的最少交换次数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MinimumSwapsToMoveZerosToEnd.java) · [LeetCode](https://leetcode.cn/problems/minimum-swaps-to-move-zeros-to-end/) |
| 3 | CN | 3694. 删除子字符串后不同的终点 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/DistinctPointsReachableAfterSubstringRemoval.java) · [LeetCode](https://leetcode.cn/problems/distinct-points-reachable-after-substring-removal/) |
| 4 | CN | 3439. 重新安排会议得到最多空余时间 I | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/RescheduleMeetingsForMaximumFreeTimeI.java) · [LeetCode](https://leetcode.cn/problems/reschedule-meetings-for-maximum-free-time-i/) |
| 3 | CN | 2904. 最短且字典序最小的美丽子字符串 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/ShortestAndLexicographicallySmallestBeautifulSubstring.java) · [LeetCode](https://leetcode.cn/problems/shortest-and-lexicographically-smallest-beautiful-string/) |
| 2 | US | 388. Longest Absolute File Path | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/LongestAbsoluteFilePath.java) |
| 2 | US | 269. Alien Dictionary | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/AlienDictionary.java) |
| 2 | US | 207. Course Schedule | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/CourseSchedule.java) |
| 2 | US | 210. Course Schedule II | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/CourseScheduleII.java) |
| 2 | US | 802. Find Eventual Safe States | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/FindEventualSafeStates.java) |
| 2 | US | 165. Compare Version Numbers | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/CompareVersionNumbers.java) |
| 2 | CN | 1456. 定长子串中元音的最大数目 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MaximumNumberOfVowelsInSubstringOfGivenLength.java) |
| 2 | CN | 643. 子数组最大平均数 I | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MaximumAverageSubarrayI.java) |
| 2 | CN | 2697. 字典序最小回文串 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/LexicographicallySmallestPalindrome.java) · [LeetCode](https://leetcode.cn/problems/lexicographically-smallest-palindrome/) |
| 2 | CN | 1052. 爱生气的书店老板 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/GrumpyBookstoreOwner.java) |
| 2 | CN | 209. 长度最小的子数组 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MinimumSizeSubarraySum.java) |
| 2 | CN | 27. 移除元素 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/RemoveElement.java) |
| 2 | CN | 713. 乘积小于 K 的子数组 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/SubarrayProductLessThanK.java) |
| 2 | CN | 3649. 完美对的数目 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/NumberOfPerfectPairs.java) · [LeetCode](https://leetcode.cn/problems/number-of-perfect-pairs/) |
| 2 | CN | 3679. 使库存平衡的最少丢弃次数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MinimumNumberOfArrivalsToDiscard.java) · [LeetCode](https://leetcode.cn/problems/minimum-discards-to-balance-inventory/) |
| 2 | CN | 3795. 不同元素和至少为 K 的最短子数组长度 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/ShortestSubarrayWithDistinctSumAtLeastK.java) · [LeetCode](https://leetcode.cn/problems/minimum-length-subarray-with-distinct-sum-at-least-k/) |
