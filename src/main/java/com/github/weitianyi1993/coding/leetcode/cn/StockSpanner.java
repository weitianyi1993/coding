package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {

    Deque<int[]> deque; // index -> price
    // List<Integer> list;
    int index = 0;

    public StockSpanner() {
        deque = new ArrayDeque<>(); // monotonic decerasing stack
        // list = new ArrayList<>();
        deque.push(new int[]{-1, -1});
    }

    public int next(int price) {
        while (deque.size() > 1 && price >= deque.peek()[1]) {
            deque.poll();
        }
        // int ans = list.size() - deque.peek();
        // deque.push(list.size());
        // list.add(price);
        // return ans;
        int ans = index - deque.peek()[0];
        deque.push(new int[]{index++, price});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
