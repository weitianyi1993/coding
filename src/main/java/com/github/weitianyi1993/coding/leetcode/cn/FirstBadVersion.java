package com.github.weitianyi1993.coding.leetcode.cn;

/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); */
abstract class VersionControl {
    protected abstract boolean isBadVersion(int version);
}

public abstract class FirstBadVersion extends VersionControl {
    public int firstBadVersionWithUnsingedMove(int n) {
        int left = -1;
        int right = n;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) right = mid;
            else left = mid;
        }
        return right;
    }

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid;
            else left = mid;
        }
        return right;
    }
}
