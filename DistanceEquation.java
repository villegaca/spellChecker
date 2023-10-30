import java.io.*;

public class DistanceEquation {
    
    public static int levenshteinRecursive(String str1, String str2, int m, int n) {
        // str1 is empty
        if (m == 0) {
            return n;
        }

        // str2 is empty
        if (n == 0) {
            return m;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return levenshteinRecursive(str1, str2, m - 1, n - 1);
        }
        return 1 + Math.min(
            //Insert 
            levenshteinRecursive(str1, str2, m, n - 1),
            Math.min(
                // Remove
                levenshteinRecursive(str1, str2, m - 1, n),
                // Replace
                levenshteinRecursive(str1, str2, m - 1, n - 1)
            )
        );
    }

    public static void main(String[] args) {
        String str1 = "kitten";
        String str2 = "sitting";

        int distance = levenshteinRecursive(str1, str2, str1.length(), str2.length());
        System.out.println("Levenshtein Distance: " + distance);
    }
}