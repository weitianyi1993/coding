# Coding Exercises

Java coding exercises and a dependency-cycle checker, built with Gradle.

## Requirements

JDK 17 or newer. The Gradle Wrapper downloads and runs the pinned Gradle version, so a separate Gradle installation is not needed.

## Build and run

```sh
./gradlew build
./gradlew run
```

Application code is under `src/main/java/com/github/weitianyi1993/coding`. LeetCode solutions are organized into `leetcode.cn` and `leetcode.us` packages, and dependency graph utilities live in the `dependency` package.

## LeetCode Review List

Priority uses a 1–5 scale, where 5 is the highest. The two problems added today are rated 5; earlier additions start at 2. Update the level as review priorities change.

| Level | Region | Problem | Solution |
|---:|:---:|---|---|
| 5 | CN | 1871. 跳跃游戏 VII | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/JumpGameVII.java) · [LeetCode](https://leetcode.cn/problems/jump-game-vii/) |
| 5 | CN | 1793. 好子数组的最大分数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MaximumScoreOfAGoodSubarray.java) · [LeetCode](https://leetcode.cn/problems/maximum-score-of-a-good-subarray/) |
| 5 | CN | 26. 删除有序数组中的重复项 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/RemoveDuplicatesFromSortedArray.java) · [LeetCode](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/) |
| 4 | CN | 374. 猜数字大小 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/GuessNumberHigherOrLower.java) · [LeetCode](https://leetcode.cn/problems/guess-number-higher-or-lower/) |
| 5 | CN | 69. x 的平方根 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/SqrtX.java) · [LeetCode](https://leetcode.cn/problems/sqrtx/) |
| 5 | CN | 275. H 指数 II | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/HIndexII.java) · [LeetCode](https://leetcode.cn/problems/h-index-ii/) |
| 5 | CN | 668. 乘法表中第 k 小的数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/KthSmallestNumberInMultiplicationTable.java) · [LeetCode](https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/) |
| 5 | CN | 1539. 第 k 个缺失的正整数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/KthMissingPositiveNumber.java) · [LeetCode](https://leetcode.cn/problems/kth-missing-positive-number/) |
| 5 | CN | 4008. 击败所有怪物的最小初始强度 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MinimumInitialStrengthToDefeatAllMonsters.java) · [LeetCode](https://leetcode.cn/problems/minimum-initial-strength-to-defeat-all-monsters/) |
| 5 | CN | 2576. 找出最多标记下标 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/FindTheMaximumNumberOfMarkedIndices.java) · [LeetCode](https://leetcode.cn/problems/find-the-maximum-number-of-marked-indices/) |
| 5 | CN | 2444. 固定界限子数组的数目 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/CountSubarraysWithFixedBounds.java) · [LeetCode](https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/) |
| 5 | CN | 1234. 替换子串得到平衡字符串 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/ReplaceTheSubstringForBalancedString.java) · [LeetCode](https://leetcode.cn/problems/replace-the-substring-for-balanced-string/) |
| 5 | CN | 1574. 删除最短的子数组使剩余数组有序 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/ShortestSubarrayToBeRemovedToMakeArraySorted.java) · [LeetCode](https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/) |
| 4 | CN | 3936. 将 0 移到末尾的最少交换次数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MinimumSwapsToMoveZerosToEnd.java) · [LeetCode](https://leetcode.cn/problems/minimum-swaps-to-move-zeros-to-end/) |
| 4 | CN | 2825. 循环增长使字符串子序列等于另一个字符串 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MakeStringASubsequenceUsingCyclicIncrements.java) · [LeetCode](https://leetcode.cn/problems/make-string-a-subsequence-using-cyclic-increments/) |
| 4 | CN | 350. 两个数组的交集 II | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/IntersectionOfTwoArraysII.java) · [LeetCode](https://leetcode.cn/problems/intersection-of-two-arrays-ii/) |
| 5 | CN | 2762. 不间断子数组 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/ContinuousSubarrays.java) · [LeetCode](https://leetcode.cn/problems/continuous-subarrays/) |
| 3 | CN | 3694. 删除子字符串后不同的终点 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/DistinctPointsReachableAfterSubstringRemoval.java) · [LeetCode](https://leetcode.cn/problems/distinct-points-reachable-after-substring-removal/) |
| 4 | CN | 3439. 重新安排会议得到最多空余时间 I | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/RescheduleMeetingsForMaximumFreeTimeI.java) · [LeetCode](https://leetcode.cn/problems/reschedule-meetings-for-maximum-free-time-i/) |
| 3 | CN | 2904. 最短且字典序最小的美丽子字符串 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/ShortestAndLexicographicallySmallestBeautifulSubstring.java) · [LeetCode](https://leetcode.cn/problems/shortest-and-lexicographically-smallest-beautiful-string/) |
| 2 | US | 388. Longest Absolute File Path | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/us/LongestAbsoluteFilePath.java) |
| 4 | CN | 278. 第一个错误的版本 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/FirstBadVersion.java) · [LeetCode](https://leetcode.cn/problems/first-bad-version/) |
| 2 | US | 269. Alien Dictionary | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/us/AlienDictionary.java) |
| 2 | US | 207. Course Schedule | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/us/CourseSchedule.java) |
| 2 | US | 210. Course Schedule II | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/us/CourseScheduleII.java) |
| 2 | US | 802. Find Eventual Safe States | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/us/FindEventualSafeStates.java) |
| 2 | US | 165. Compare Version Numbers | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/us/CompareVersionNumbers.java) |
| 2 | CN | 1456. 定长子串中元音的最大数目 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MaximumNumberOfVowelsInSubstringOfGivenLength.java) |
| 2 | CN | 35. 搜索插入位置 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/SearchInsertPosition.java) · [LeetCode](https://leetcode.cn/problems/search-insert-position/) |
| 3 | CN | 704. 二分查找 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/BinarySearch.java) · [LeetCode](https://leetcode.cn/problems/binary-search/) |
| 3 | CN | 410. 分割数组的最大值 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/SplitArrayLargestSum.java) · [LeetCode](https://leetcode.cn/problems/split-array-largest-sum/) |
| 3 | CN | 2529. 正整数和负整数的最大计数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MaximumCountOfPositiveAndNegativeInteger.java) · [LeetCode](https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/) |
| 3 | CN | 2080. 区间内查询数字的频率 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/RangeFreqQuery.java) · [LeetCode](https://leetcode.cn/problems/range-frequency-queries/) |
| 3 | CN | 1898. 可移除字符的最大数目 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MaximumNumberOfRemovableCharacters.java) · [LeetCode](https://leetcode.cn/problems/maximum-number-of-removable-characters/) |
| 4 | CN | 3488. 距离最小相等元素查询 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/ClosestEqualElementQueries.java) · [LeetCode](https://leetcode.cn/problems/closest-equal-element-queries/) |
| 3 | CN | 3296. 移山所需的最少秒数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MinimumNumberOfSecondsToMakeMountainHeightZero.java) · [LeetCode](https://leetcode.cn/problems/minimum-number-of-seconds-to-make-mountain-height-zero/) |
| 4 | CN | 1802. 有界数组中指定下标处的最大值 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MaximumValueAtAGivenIndexInABoundedArray.java) · [LeetCode](https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/) |
| 5 | CN | 131. 分割回文串（两种解法，重点复习选或不选） | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/PalindromePartitioning.java) · [LeetCode](https://leetcode.cn/problems/palindrome-partitioning/) |
| 4 | CN | 46. 全排列 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/Permutations.java) · [LeetCode](https://leetcode.cn/problems/permutations/) |
| 3 | CN | 90. 子集 II | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/SubsetsII.java) · [LeetCode](https://leetcode.cn/problems/subsets-ii/) |
| 3 | CN | 77. 组合 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/Combinations.java) · [LeetCode](https://leetcode.cn/problems/combinations/) |
| 4 | CN | 216. 组合总和 III | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/CombinationSumIII.java) · [LeetCode](https://leetcode.cn/problems/combination-sum-iii/) |
| 4 | CN | 805. 数组的均值分割 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/SplitArrayWithSameAverage.java) · [LeetCode](https://leetcode.cn/problems/split-array-with-same-average/) |
| 4 | CN | 3376. 破解锁的最少时间 I | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MinimumTimeToBreakLocksI.java) · [LeetCode](https://leetcode.cn/problems/minimum-time-to-break-locks-i/) |
| 3 | CN | 491. 非递减子序列 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/NonDecreasingSubsequences.java) · [LeetCode](https://leetcode.cn/problems/non-decreasing-subsequences/) |
| 5 | CN | 3850. 统计结果等于 K 的序列数目（记忆化搜索） | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/CountSequencesToK.java) · [LeetCode](https://leetcode.cn/problems/count-sequences-to-k/) |
| 5 | CN | 1079. 活字印刷 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/LetterTilePossibilities.java) · [LeetCode](https://leetcode.cn/problems/letter-tile-possibilities/) |
| 3 | CN | 3566. 等积子集的划分方案 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/PartitionArrayIntoTwoEqualProductSubsets.java) · [LeetCode](https://leetcode.cn/problems/partition-array-into-two-equal-product-subsets/) |
| 4 | CN | 2982. 找出出现至少三次的最长特殊子字符串 II | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/FindLongestSpecialSubstringThatOccursThriceII.java) · [LeetCode](https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-ii/) |
| 2 | CN | 2187. 完成旅途的最少时间 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MinimumTimeToCompleteTrips.java) · [LeetCode](https://leetcode.cn/problems/minimum-time-to-complete-trips/) |
| 2 | CN | 1011. 在 D 天内送达包裹的能力 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/CapacityToShipPackagesWithinDDays.java) · [LeetCode](https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/) |
| 1 | CN | 2226. 每个小孩最多能分到多少糖果 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MaximumCandiesAllocatedToKChildren.java) · [LeetCode](https://leetcode.cn/problems/maximum-candies-allocated-to-k-children/) |
| 1 | CN | 2300. 咒语和药水的成功对数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/SuccessfulPairsOfSpellsAndPotions.java) · [LeetCode](https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/) |
| 1 | CN | 1170. 比较字符串最小字母出现频次 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/CompareStringsByFrequencyOfTheSmallestCharacter.java) · [LeetCode](https://leetcode.cn/problems/compare-strings-by-frequency-of-the-smallest-character/) |
| 2 | CN | 643. 子数组最大平均数 I | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MaximumAverageSubarrayI.java) |
| 2 | CN | 2697. 字典序最小回文串 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/LexicographicallySmallestPalindrome.java) · [LeetCode](https://leetcode.cn/problems/lexicographically-smallest-palindrome/) |
| 2 | CN | 1052. 爱生气的书店老板 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/GrumpyBookstoreOwner.java) |
| 2 | CN | 209. 长度最小的子数组 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MinimumSizeSubarraySum.java) |
| 2 | CN | 27. 移除元素 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/RemoveElement.java) |
| 2 | CN | 713. 乘积小于 K 的子数组 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/SubarrayProductLessThanK.java) |
| 2 | CN | 3649. 完美对的数目 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/NumberOfPerfectPairs.java) · [LeetCode](https://leetcode.cn/problems/number-of-perfect-pairs/) |
| 2 | CN | 3679. 使库存平衡的最少丢弃次数 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/MinimumNumberOfArrivalsToDiscard.java) · [LeetCode](https://leetcode.cn/problems/minimum-discards-to-balance-inventory/) |
| 2 | CN | 3795. 不同元素和至少为 K 的最短子数组长度 | [Java](src/main/java/com/github/weitianyi1993/coding/leetcode/cn/ShortestSubarrayWithDistinctSumAtLeastK.java) · [LeetCode](https://leetcode.cn/problems/minimum-length-subarray-with-distinct-sum-at-least-k/) |
