class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }
        
        int consistentCount = 0;
        
        // Step 2: Iterate through each word in the words array
        for (String word : words) {
            boolean isConsistent = true;
            
            // Step 3: Check if all characters in the word are in the allowed set
            for (char ch : word.toCharArray()) {
                if (!allowedSet.contains(ch)) {
                    isConsistent = false;
                    break;  // No need to check further if a non-allowed character is found
                }
            }
            
            // Step 4: Increment the count if the word is consistent
            if (isConsistent) {
                consistentCount++;
            }
        }
        
        return consistentCount;
    }
}