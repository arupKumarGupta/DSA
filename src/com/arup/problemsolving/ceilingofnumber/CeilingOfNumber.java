package com.arup.problemsolving.ceilingofnumber;

public class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,14,55,76,327};
        int target = 26;
        System.out.println(solve(arr,target));
    }

    static int solve(int [] arr, int target) {
        if(target >= arr[arr.length -1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == target) {
                return target;
            }
            if(arr[mid] > target) {
                end = mid-1;
            } else  {
                start = mid+1;
            }
        }
        return arr[start];
    }
}
