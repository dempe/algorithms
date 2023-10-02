package com.chrisdempewolf.lc._0015threesum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    public void test1() {
        final Solution solution = new Solution();
        final List<List<Integer>> actual   = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        final List<List<Integer>> expected = List.of(List.of(-1,-1,2), List.of(-1,0,1));

        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void test2() {
        final Solution solution = new Solution();
        final List<List<Integer>> actual   = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        final List<List<Integer>> expected = List.of(List.of(-1,-1,2), List.of(-1,0,1));

        assertEquals(expected.size(), actual.size());
    }
}
