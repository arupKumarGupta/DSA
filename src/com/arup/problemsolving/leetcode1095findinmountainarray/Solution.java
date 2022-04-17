package com.arup.problemsolving.leetcode1095findinmountainarray;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

interface MountainArray {
    int get(int index);
    int length();
}

class Solution {
    public int findInMountainArray(int target, MountainArray m) {
        int start = 0;
        int end = m.length() - 1;
        int peakIdx = findPeak(m);
        int left = bs(m,0,peakIdx,target, false);

        if(left == -1) {
            return  bs(m,peakIdx+1,end,target, true);
        }
        return left;
    }

    public int bs(MountainArray mountainArr, int start, int end, int target, boolean isDec) {

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid)  ==  target) {
                return mid;
            }
            if(!isDec) {
                if(mountainArr.get(mid)  > target ) {
                    end = mid-1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(mountainArr.get(mid)  > target ) {
                    start = mid+1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

    public int findPeak(MountainArray m) {
        int start = 0;
        int end = m.length() - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if(m.get(mid) >= m.get(mid+1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}