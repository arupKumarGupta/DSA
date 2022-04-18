package com.arup.problemsolving.leetcode81searchinrotatedsortedarray2.leetcode153mininrotatedsortedarray.leetcode33searchinrotatedsortedarray;


public class Solution {
    public int findMin(int[] nums) {
        int peakIdx = peakOrDipIndex(nums);
        if(peakIdx == -1 || peakIdx == nums.length - 1) {
            return nums[0];
        }
        return nums[peakIdx + 1];

    }

    public int peakOrDipIndex(int[] a) {

        int start = 0;
        int end = a.length-1;
        while(start < end) {
            int mid = start + (end - start )/2;
            if(a[mid] > a[mid+1]  ) {
                return mid;
            } else if(mid - 1 > 0 && a[mid -1 ] > a[mid]) {
                return mid - 1;
            }
            if(a[start] > a[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    public int bs(int[] a, int s, int e, int t) {
        while(s<=e) {
            int m = s + (e-s)/2;
            if(a[m] == t) {
                return m;
            }
            if(a[m] > t) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }
}

