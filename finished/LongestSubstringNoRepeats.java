
import java.util.HashMap;
import java.lang.Math;
class LongestSubstringNoRepeats {
    public int lengthOfLongestSubstring(String s) {
        HashMap map = new HashMap<Character, Integer>();
        int answer = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                last = Math.max((int)map.get(s.charAt(i)), last);
            }
            
            answer = Math.max(i - last + 1, answer);
            map.put(s.charAt(i), i+1);
        }
        return answer;
    }
}