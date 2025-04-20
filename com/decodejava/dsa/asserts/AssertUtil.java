package com.decodejava.dsa.asserts;

import java.text.MessageFormat;

public class AssertUtil {
    public static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("value mismatch");
        }
    }

    public static void assertValue(Object actual, Object expected) {
        if (actual != expected) {
            throw new AssertionError(MessageFormat.format("expected {0}, but value is {1}", expected, actual));
        }
    }
}
