package Chapter10;

import java.util.*;

/**
 * Created by Hao on 9/24/15.
 */

public class Solution1002 {

    public static void main(String[] args) {
        String[] strs = {"ab", "ba", "aa", "bc", "daa", "aad", "bbbc"};
        sortAnagram(strs);
        System.out.println(Arrays.toString(strs));
    }

    // use hashmap to arrange anagrams
    public static void sortAnagram(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            // sort the string in ascending order, use sortedStr as key to arrange anagrams.
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if (!anagrams.containsKey(sortedStr)) {
                anagrams.put(sortedStr, new ArrayList<String>());
            }
            anagrams.get(sortedStr).add(str);
        }
        int pos = 0;
        // refill string array, since anagrams are in the same list, they would be next to each other in the str array.
        for (Map.Entry<String, List<String>> entry : anagrams.entrySet()) {
            for (String str : entry.getValue()) {
                strs[pos] = str;
                ++pos;
            }
        }
    }
}
