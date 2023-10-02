package com.chrisdempewolf.lc._0015threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        final Map<Integer, List<Integer>> memo           = buildMap(nums);
        final Set<Integer>                hashedTriplets = new HashSet<>();
        final List<List<Integer>>         results        = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                final int ival = nums[i];
                final int jval = nums[j];
                final int sum = ival + jval;
                final int kval = sum * -1;
                final List<Integer> candidates = memo.get(kval);

                if (candidates == null || candidates.isEmpty()) { continue; }

                for (final int candidate : candidates) {
                    if (candidate <= j) { continue; }

                    final List<Integer> triplet = Arrays.asList(ival, jval, kval);
                    Collections.sort(triplet);
                    final int hash = triplet.hashCode();
                    if (hashedTriplets.contains(hash)) { continue; }

                    results.add(triplet);
                    hashedTriplets.add(hash);
                }
            }
        }

        return results;
    }

    private static HashMap<Integer, List<Integer>> buildMap(final int[] nums) {
        final HashMap<Integer, List<Integer>> memo = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            memo.putIfAbsent(nums[i], new ArrayList<>());
            memo.get(nums[i]).add(i);
        }

        return memo;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(solution.threeSum(new int[]{0,1,1}));
        System.out.println(solution.threeSum(new int[]{0,0,0}));
        System.out.println(
    }

}