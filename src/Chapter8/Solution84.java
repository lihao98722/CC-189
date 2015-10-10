package Chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hao on 10/6/15.
 */
public class Solution84 {

    public static void main(String[] args) {
        Integer[] set = {-1, 1, 3, 5, 7, 9};
        List<List<Integer>> allSubsets = getSubsets(Arrays.asList(set));
        System.out.println("total subsets: " + allSubsets.size());
        for (List<Integer> subset : allSubsets) {
            System.out.println(Arrays.deepToString(subset.toArray()));
        }
    }

    public static List<List<Integer>> getSubsets(final List<Integer> set) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> allSubsets = new ArrayList<>();
        getSubsets(set, 0, subset, allSubsets);
        return allSubsets;
    }

    private static void getSubsets(final List<Integer> set, final int start, List<Integer> subset,
                                           List<List<Integer>> allSubsets) {
        allSubsets.add(new ArrayList<>(subset));
        for (int pos = start; pos < set.size(); ++pos) {
            subset.add(set.get(pos));
            getSubsets(set, pos + 1, subset, allSubsets);
            subset.remove(subset.size() - 1);
        }
    }
}
