class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        // Reverse the array for easier processing
        List<Integer> reversedList = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) reversedList.add(nums[i]);
        // Initialize pointers and variables
        int left = 0;                    // Left pointer
        int minSumOfDifferences = Integer.MAX_VALUE;  // Minimum sum of differences
        int sumOfDifferences = 0;        // Current sum of differences
        int minLeft = left;              // Left index of the minimum sum range
        int minRight = left;             // Right index of the minimum sum range

        for (int right = 0; right < reversedList.size(); right++) {
            sumOfDifferences += Math.abs(x - reversedList.get(right));  // Calculate the absolute difference
            if (right - left + 1 >= k) {  // Check if the window size is greater than or equal to k
                if (sumOfDifferences <= minSumOfDifferences) {  // Update minimum sum and indices
                    minSumOfDifferences = sumOfDifferences;
                    minLeft = left;
                    minRight = right;
                }
                sumOfDifferences -= Math.abs(x - reversedList.get(left++));  // Subtract the left element's difference
            }
        }
        // Construct the result
        List<Integer> closestElements = new ArrayList<>();
        for(int i = minRight; i >= minLeft; i--)
         closestElements.add(reversedList.get(i));  
        // Add elements in reverse order to get ascending order
        return closestElements;
    }
}