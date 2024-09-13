class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
         int n = arr.length;
        int[] prefixXor = new int[n];
        int[] result = new int[queries.length];

        // Step 1: Compute the prefix XOR array
        prefixXor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }

        // Step 2: Process each query
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // If the left index is 0, the answer is simply prefixXor[right]
            if (left == 0) {
                result[i] = prefixXor[right];
            } else {
                result[i] = prefixXor[right] ^ prefixXor[left - 1];
            }
        }

        return result;
}
}