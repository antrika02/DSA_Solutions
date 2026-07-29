class Solution {
    long[] fact;  // To store precomputed factorials
    static long maxK = 1000001;  // Limit for large calculations
    
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];  // Array to store frequency of each character in string s
        
        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) freq[c - 'a']++;

        String mid = "";  // String to hold the middle character (in case of odd frequency)
 
       
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
               mid = String.valueOf((char)(i + 'a'));  // Set middle character for palindrome
               break;
            }
        }
 
        int[] half = new int[26];  // Array to store half of the frequency for each character
        int len = 0;  // Length of half the palindrome
        
        // Populate the half array with half the frequency of each character (for palindrome construction)
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];  // Update the length of half palindrome
        }

        computeFactorials(len);  // Precompute factorials for efficient calculation of permutations

        StringBuilder halfStr = new StringBuilder();  // StringBuilder to construct the first half of the palindrome
        
        // Try to build the k-th palindrome by backtracking
        if (!buildKthPalindrome(half, k, halfStr, len)) return "";  // Return empty string if k-th palindrome not found

        // Reverse the first half and concatenate it with middle character to form the full palindrome
        StringBuilder rev = new StringBuilder(halfStr).reverse();
        return halfStr.toString() + mid + rev.toString();
    }

    // Recursive function to build the k-th lexicographically smallest palindrome
    private boolean buildKthPalindrome(int[] freq, long k, StringBuilder sb, int len) {
        if (len == 0) return true;  // Base case: If no more characters to add
        
        // Try adding characters to the half palindrome by checking all possibilities
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;  // Skip if no occurrences of this character

            freq[i]--;  // Decrease the count of the current character
            long perms = multinomial(freq);  // Calculate the number of permutations with the remaining characters

            // If k-th permutation is within the range of permutations for this character, add it
            if (k <= perms) {
                sb.append((char)(i + 'a'));  // Add the character to the half palindrome
                return buildKthPalindrome(freq, k, sb, len - 1);  // Recursively try to build the rest
            } else {
                k -= perms;  // If k-th permutation is not within the range, adjust k and try the next character
                freq[i]++;  // Restore the frequency of the current character
            }
        }
        return false;  // Return false if no valid k-th palindrome can be built
    }

    // Function to calculate the multinomial coefficient for the remaining character frequencies
    private long multinomial(int[] counts) {
        int tot = 0;
        for (int x : counts) tot += x;  // Total number of characters remaining

        long res = 1;
        // Calculate the multinomial coefficient
        for (int i = 0; i < 26; i++) {
            int cnt = counts[i];
            res = res * binom(tot, cnt);  // Multiply with the binomial coefficient for each character count
        if (res >= maxK) return maxK;  // Limit the result to maxK if it exceeds the limit
            tot -= cnt;  // Update the total count of characters remaining
        }
        return res;
    }

    // Function to calculate binomial coefficient C(n, k) (n choose k)
    private long binom(int n, int k) {
        if (k > n) return 0;  // If k > n, return 0 (invalid case)
        if (k > n - k) k = n - k;  // Use symmetry of binomial coefficients: C(n, k) = C(n, n - k)
        
        long res = 1;
        // Compute the binomial coefficient using the iterative approach
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;  // Calculate C(n, k) iteratively
            if (res >= maxK) return maxK;  // Limit the result to maxK if it exceeds the limit
        }
        return res;
    }

    // Precompute factorials up to a given number n
    private void computeFactorials(int n) {
        fact = new long[n + 1];
        fact[0] = 1;
        // Calculate factorials for numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }
}