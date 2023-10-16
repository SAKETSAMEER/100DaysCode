class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;

        // First pass: Find the start index.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }

        // Second pass: Find the end index.
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                end = i;
                break;
            }
        }

        return new int[]{start, end};
    }
}