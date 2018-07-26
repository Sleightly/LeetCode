class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        //first index is start of substring
        //second index is end of substring
        boolean[][] longest_sub = new boolean[s.length()][s.length()];
        
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                
                //base cases
                if (j == i) {
                    longest_sub[i][j] = true;
                    continue;
                }
                else if (j < i) {
                    longest_sub[i][j] = false;
                    continue;
                }
                
                else if (j-i == 1 && s.charAt(j) == s.charAt(i)) {
                    longest_sub[i][j] = true;
                    continue;
                } 
                
                //dp, cases
                if (s.charAt(j) == s.charAt(i)) {
                    longest_sub[i][j] = longest_sub[i+1][j-1];
                }
                else {
                    longest_sub[i][j] = false;
                }
                
            }
        }
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (longest_sub[i][j] && j-i+1 > max) {
                    max = j-i+1;
                    start = i;
                    end = j;
                } 
            }
        }
        return s.substring(start,end+1);
    }
}