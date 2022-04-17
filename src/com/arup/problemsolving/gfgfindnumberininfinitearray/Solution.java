package com.arup.problemsolving.gfgfindnumberininfinitearray;

public class Solution {
    public int solve (int arr[], int target) {
        int start = 0;
        int end = 1;
        while(arr[end] < target) {
            end = start + (end - start +1) * 2;
            start = end + 1;

        }
        return bs(arr, start, end, target);
    }

    int bs(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1,2,3,3,5,6,7,8,9,10,10,12};
        int target = 14;
        System.out.println(solution.solve(a, target));
    }

}
