import java.io.*;

public class DistanceEquation {
    
    // public static int levenshteinRecursive(String str1, String str2, int m, int n) {
    //     // str1 is empty
    //     if (m == 0) {
    //         return n;
    //     }

    //     // str2 is empty
    //     if (n == 0) {
    //         return m;
    //     }

    //     if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
    //         return levenshteinRecursive(str1, str2, m - 1, n - 1);
    //     }
    //     return 1 + Math.min(
    //         //Insert 
    //         levenshteinRecursive(str1, str2, m, n - 1),
    //         Math.min(
    //             // Remove
    //             levenshteinRecursive(str1, str2, m - 1, n),
    //             // Replace
    //             levenshteinRecursive(str1, str2, m - 1, n - 1)
    //         )
    //     );
    // }

    public static int editDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
	    int dp[][] = new int[n+1][m+1];
	    for (int i = 0; i <= n; i++) {
	        for (int j = 0; j <= m; j++) {
	            if (i == 0)
	                dp[i][j] = j;      
	            else if (j == 0)
	                dp[i][j] = i; 
	            else if (word1.charAt(i-1) == word2.charAt(j-1))
	                dp[i][j] = dp[i-1][j-1];	            
	            else if (i>1 && j>1  && word1.charAt(i-1) == word2.charAt(j-2) 
	            		&& word1.charAt(i-2) == word2.charAt(j-1))
	            	dp[i][j] = 1+Math.min(Math.min(dp[i-2][j-2], dp[i-1][j]), Math.min(dp[i][j-1], dp[i-1][j-1]));
	            else
	                dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])); 
	        }
	    } 
	    return dp[n][m];
	}

    public static void main(String[] args) {
        String str1 = "kitten";
        String str2 = "sitting";

        //int distance = levenshteinRecursive(str1, str2, str1.length(), str2.length());
        //System.out.println("Levenshtein Distance: " + distance);
    }
}
