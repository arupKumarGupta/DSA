package com.arup.problemsolving.leetcode410splitarraylargestsum.ceilingofnumber;

class Solution {
    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        for(int n: nums) {
            start = Math.max(start, n);
            end+=n;
        }
        while(start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int seg = 1;
            for(int n : nums) {
                if(sum + n > mid) {
                    sum = n;
                    seg++;
                } else {
                    sum += n;
                }
            }
            if(seg > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}