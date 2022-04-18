package com.arup.problemsolving.leetcode81searchinrotatedsortedarray2.leetcode33searchinrotatedsortedarray;

public class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
        boolean left = bs(nums,0,pivot, target);
        if(!left) {
            return bs(nums,pivot + 1, nums.length - 1, target);
        }
        return left;
    }

    public boolean bs(int []a, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start )/2;
            if(a[mid] == target) {
                return true;
            }
            if(a[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public int findPivot(int a[]) {
        int start = 0;
        int end = a.length - 1;
        while(start < end) {
            int mid = start + (end - start )/2;
            if(mid < end && a[mid] > a[mid + 1]) {
                return mid;
            }
            if(mid > start && a[mid - 1] > a[mid]) {
                return mid - 1;
            }
            if(a[start] == a[mid] && a[end] == a[mid]) {
                if(a[start] > a[start + 1]) {
                    return start;
                }
                start ++;
                if(a[end] < a[end - 1]) {
                    return end -1;
                }
                end--;
            } else if(a[start] < a[mid] || (a[start] == a[mid] && a[mid] > a[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
    }
}
