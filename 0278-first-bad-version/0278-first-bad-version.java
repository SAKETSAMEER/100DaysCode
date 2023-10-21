/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

    while (low <= high) {
       int mid = low + (high - low) / 2; // Avoid potential overflow

        if (isBadVersion(mid)) {
            high = mid - 1; // Set high to mid - 1 to search in the left half
        } else {
            low = mid + 1; // Set low to mid + 1 to search in the right half
        }
    }
    return low;
    }
}