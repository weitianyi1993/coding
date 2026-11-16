package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class RideSharingSystem {

    Deque<Integer> riderDeque = new ArrayDeque<>();
    Deque<Integer> driverDeque = new ArrayDeque<>();
    Set<Integer> activeRiders = new HashSet<>();

    public RideSharingSystem() {
    }

    public void addRider(int riderId) {
        riderDeque.offerLast(riderId);
        activeRiders.add(riderId);
    }

    public void addDriver(int driverId) {
        driverDeque.add(driverId);
    }

    public int[] matchDriverWithRider() {
        while (!riderDeque.isEmpty() && !activeRiders.contains(riderDeque.peekFirst())) {
            riderDeque.pollFirst();
        }
        if (riderDeque.isEmpty() || driverDeque.isEmpty()) return new int[]{-1, -1};
        int rider = riderDeque.pollFirst();
        cancelRider(rider);
        return new int[]{driverDeque.pollFirst(), rider};
    }

    public void cancelRider(int riderId) {
        activeRiders.remove(riderId);
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */
