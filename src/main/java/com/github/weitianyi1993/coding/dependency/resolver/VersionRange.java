package com.github.weitianyi1993.coding.dependency.resolver;

public class VersionRange {
    public final Version minVer;
    public final boolean minInc;
    public final Version maxVer;
    public final boolean maxInc;

    public VersionRange(Version minVer, boolean minInc, Version maxVer, boolean maxInc) {
        this.minVer = minVer;
        this.minInc = minInc;
        this.maxVer = maxVer;
        this.maxInc = maxInc;
    }

    public static VersionRange any() {
        return new VersionRange(null, true, null, true);
    }

    public boolean contains(Version v) {
        if (minVer != null) {
            int cmp = v.compareTo(minVer);
            if (minInc && cmp < 0 || !minInc && cmp <= 0) return false;
        }

        if (maxVer != null) {
            int cmp = v.compareTo(maxVer);
            if (maxInc && cmp > 0 || !maxInc && cmp >= 0) return false;
        }
        return true;
    }

    public VersionRange intersect(VersionRange other) {
        if (other == null) return this;

        // 1. 计算下界 (取大值)
        Version newMin = this.minVer;
        boolean newMinInc = this.minInc;
        if (other.minVer != null) {
            if (newMin == null || other.minVer.compareTo(newMin) > 0) {
                newMin = other.minVer;
                newMinInc = other.minInc;
            } else if (other.minVer.compareTo(newMin) == 0) {
                newMinInc = this.minInc && other.minInc; // 开区间优先
            }
        }

        // 2. 计算上界 (取小值)
        Version newMax = this.maxVer;
        boolean newMaxInc = this.maxInc;
        if (other.maxVer != null) {
            if (newMax == null || other.maxVer.compareTo(newMax) < 0) {
                newMax = other.maxVer;
                newMaxInc = other.maxInc;
            } else if (other.maxVer.compareTo(newMax) == 0) {
                newMaxInc = this.maxInc && other.maxInc;
            }
        }

        // 3. 校验有效性
        if (newMin != null && newMax != null) {
            int cmp = newMin.compareTo(newMax);
            if (cmp > 0) return null; // 下界大于上界
            if (cmp == 0 && (!newMinInc || !newMaxInc)) return null; // 端点重合但含开区间
        }

        return new VersionRange(newMin, newMinInc, newMax, newMaxInc);
    }

    @Override
    public String toString() {
        String left = (minVer == null) ? "(-∞" : (minInc ? "[" : "(") + minVer;
        String right = (maxVer == null) ? "+∞)" : maxVer + (maxInc ? "]" : ")");
        return left + ", " + right;
    }
}
