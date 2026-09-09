class Solution {
    //this problem is trucky because of it explanation
    //basically we have to find a largest substring such that 
    //replacement of atmost k characters will make the substring with
    //same letters, for that we will maintain a sliding window and
    //record frequency of characters in a map for a given substring
    //update the map frequency as we update size of window ->shrink or expand
    //in every iteration we need to find a window which 
    //satisfy the condition :: <length of substring> - <max Frequency of present substring> because we won't want to replace the most frequent character because they contribute most to same letter substring
    //i.e -> (r - l + 1) - maxFrequency <= k
    // if thats not the case then in order to reduce the max frequency
    // we move l to right, i.e l++ and reduce the frequency in of charAt(l) as it's no longer part of substring
    // finally record the max length of window
    public int characterReplacement(String s, int k) {
        int max = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int l = 0;
        int n = s.length();
        for (int r = 0; r < n; r++) {
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            while ((r - l + 1) - maxFreq(freq) > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    int maxFreq(Map<Character, Integer> map) {
         return map.values().stream().max((a, b) -> a - b).get();
    }






}
