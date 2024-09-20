class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Create a new string that is the original plus a special separator
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        // KMP prefix table
        int[] lps = new int[combined.length()];

        // Build the LPS array for the combined string
        for (int i = 1; i < combined.length(); i++) {
            int j = lps[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        // The length of the longest palindromic prefix
        int maxLen = lps[combined.length() - 1];

        // Characters to add in front of the original string
        String toAdd = rev.substring(0, rev.length() - maxLen);

        // Construct the shortest palindrome
        return toAdd + s;
}
}