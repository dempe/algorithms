package com.chrisdempewolf.lc._0015threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionWithBinarySearch {

    public static void main(String[] args) {
        final SolutionWithBinarySearch solution = new SolutionWithBinarySearch();

        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(solution.threeSum(new int[]{0,1,1}));
        System.out.println(solution.threeSum(new int[]{0,0,0}));
        System.out.println(solution.threeSum(new int[]{-1,0,1,1}));
        System.out.println(solution.threeSum(new int[]{30,-40,-20,-10,40,0,10,5}));
        //MyStopWatch.calculateRunTime();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final Set<Integer>                hashedTriplets = new HashSet<>();
        final List<List<Integer>>         results        = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                final int ival = nums[i];
                final int jval = nums[j];
                final int sum = ival + jval;
                final int kval = sum * -1;
                final List<Integer> candidates = findCandidates(kval, nums);

                //Arrays.binarySearch(nums, kval);

                if (candidates.isEmpty()) { continue; }

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

    private static List<Integer> findCandidates(final int key, final int[] nums) {
        final List<Integer> candidates = new ArrayList<>();

        int lo  = 0;
        int hi  = nums.length - 1;
        int mid; // Declared here for use below
        while (lo <= hi) {
            mid        = lo + (hi - lo) / 2;
            int midVal = nums[mid];

            if      (key < midVal) { hi = mid - 1; }
            else if (key > midVal) { lo = mid + 1; }
            else                   {
                candidates.add(mid);
                break;  // Otherwise, loops infinitely
            }
        }

        // Find all other equal values.
//        candidates.addAll(findCandidates(key, Arrays.copyOfRange(nums, lo, mid)));
//        candidates.addAll(findCandidates(key, Arrays.copyOfRange(nums, mid, hi)));

        return candidates;
    }
}
