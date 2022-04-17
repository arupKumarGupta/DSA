package com.arup.problemsolving.leetcode34FindFirstandLastPositionofElementinSortedArray;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = bs(nums, target, true);
        if(start == -1 || nums[start] != target) {
            return new int[]{-1,-1};
        }

        int end = bs(nums, target, false);
        return new int[]{start, end};

    }

    public int bs(int[] arr, int target, boolean isFloor) {
        if(arr.length == 0) { return -1;}
        if(target > arr[arr.length -1]) {
            return -1;
        }

        int start = 0;
        int end = arr.length -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(isFloor) {
                if(arr[mid] >= target) {
                    end = mid-1;
                } else  {
                    start = mid+1;
                }
            } else {
                if(arr[mid] > target) {
                    end = mid-1;
                } else  {
                    start = mid+1;
                }
            }

        }
        return isFloor ? end+1 : start-1;
    }
}
