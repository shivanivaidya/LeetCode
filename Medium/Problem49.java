/*

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.

*/


class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> map = new HashMap<String, List>();
        for(int i = 0; i<strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList(map.values());  
    }
}