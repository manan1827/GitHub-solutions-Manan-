class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
         Map<String, Integer> wordCount = new HashMap<>();
        
        // Split both sentences into words and update the word counts
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        // Add words from the first sentence
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Add words from the second sentence
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // List to store the uncommon words
        List<String> result = new ArrayList<>();
        
        // Traverse the map and find words with a frequency of exactly 1
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        // Convert the result list to an array and return it
        return result.toArray(new String[0]);
        
    }
}