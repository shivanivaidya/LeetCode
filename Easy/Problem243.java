/*

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

*/

class Problem243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDist = words.length;
        for(int i = 0; i< words.length; i++) {
            if(words[i].equals(word1)) {
                    i1 = i;
            }
            else if(words[i].equals(word2)) {
                i2 = i;
            }
            
            if(i1 != -1 && i2 != -1) {
                minDist = Math.min(minDist, Math.abs(i1-i2));
            }
        }
        return minDist;
    }
}