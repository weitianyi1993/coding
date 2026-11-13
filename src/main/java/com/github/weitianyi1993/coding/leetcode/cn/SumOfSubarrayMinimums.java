package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayMinimums {
    private static final long MOD = (long) 1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        // 对一个滑动窗口，如果要找当前最小，那我应该要用一个双端队列
        // 里面是维护递增，因为后面新来的更小的话，前面更大的就没用了。新来的更大的话，可能还有用就加上去
        // 从左往右，维护递增栈的时候，我会把之前跟我一样的也pop了，这时候就是说以这个i的都算在它头上
        // 从右往左，维护递增栈的时候，一样的我不会pop，因为它“更”有用
        long sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(-1);
        for (int i = 0; i <= arr.length; i++) {
            int curr = i == arr.length ? -1 : arr[i];
            while (deque.size() > 1 && arr[deque.peek()] >= curr) {
                int index = deque.pop();
                sum += (long) (arr[index]) * (i - index) * (index - deque.peek());
            }
            deque.push(i);
        }
        return (int) (sum % MOD);
    }
}
