package com.github.weitianyi1993.coding.dependency.resolver;

import java.util.Objects;

public class Version implements Comparable<Version> {
    private final int major;
    private final int minor;
    private final int patch;
    private final String raw;

    public Version(String raw) {
        this.raw = raw.trim();
        String[] parts = this.raw.split("\\.");
        this.major = parts.length > 0 ? Integer.parseInt(parts[0]) : 0;
        this.minor = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
        this.patch = parts.length > 2 ? Integer.parseInt(parts[2]) : 0;
    }

    @Override
    public int compareTo(Version o) {
        if (this.major != o.major) return Integer.compare(this.major, o.major);
        if (this.minor != o.minor) return Integer.compare(this.minor, o.minor);
        return Integer.compare(this.patch, o.patch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Version)) return false;
        return compareTo((Version) o) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(major, minor, patch);
    }

    @Override
    public String toString() {
        return raw;
    }
}
