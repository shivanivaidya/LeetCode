/*

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/

class Problem451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        int n = s.length();
        
        if(n <= 1) 
            return s;
        
        for(int i = 0; i<n; i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch,0) + 1);
        }
        
        PriorityQueue<Character> minHeap = new PriorityQueue<Character>(n, new Comparator<Character>() {
            @Override
            public int compare(Character x, Character y) {
                return freq.get(y) - freq.get(x);
            }
        });
        
        for(char ch : freq.keySet()) {
            minHeap.offer(ch);
        }
        
        StringBuilder result = new StringBuilder();
        while(!minHeap.isEmpty()) {
            char ch = minHeap.poll();
            for(int i = 0; i<freq.get(ch); i++)
                result.append(ch);
        }
        
        return result.toString();
    }
}