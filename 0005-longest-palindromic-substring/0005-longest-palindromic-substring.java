public class Solution {
    public String longestPalindrome(String s) {
        // Insert boundary characters to handle even-length palindromes
        StringBuilder modifiedString = new StringBuilder("^#");
        for (char c : s.toCharArray()) {
            modifiedString.append(c).append("#");
        }
        modifiedString.append("$");
        String modifiedStr = modifiedString.toString();
        
        int len = modifiedStr.length();
        int[] palindromeLengths = new int[len];
        int center = 0, rightBoundary = 0;
        
        for (int i = 1; i < len - 1; i++) {
            if (i < rightBoundary) {
                int mirror = 2 * center - i;
                palindromeLengths[i] = Math.min(rightBoundary - i, palindromeLengths[mirror]);
            }
            
            // Attempt to expand palindrome centered at i
            while (modifiedStr.charAt(i + 1 + palindromeLengths[i]) == modifiedStr.charAt(i - 1 - palindromeLengths[i])) {
                palindromeLengths[i]++;
            }
            
            // If this palindrome's right boundary exceeds the rightmost boundary so far,
            // adjust center and right boundary
            if (i + palindromeLengths[i] > rightBoundary) {
                center = i;
                rightBoundary = i + palindromeLengths[i];
            }
        }
        
        // Find the maximum length of palindromic substring
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 0; i < len; i++) {
            if (palindromeLengths[i] > maxLen) {
                maxLen = palindromeLengths[i];
                centerIndex = i;
            }
        }
        
        // Calculate original string indices from modified string
        int start = (centerIndex - maxLen) / 2;
        int end = start + maxLen;
        return s.substring(start, end);
    }
}
