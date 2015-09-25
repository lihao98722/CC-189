package Chapter10;

/**
 * Created by Hao on 9/24/15.
 */
public class Solution1006 {

    /* Obviously, all of the data can not be loaded into memory together, so we can not use in-memory sorting algorithms.
     * we should divide the whole data set into several smaller data sets(depends on the memory limits), then sort each
     * smaller data set in memory to make them in order.
     * Then use external sort(maintain a heap in memory to combine-sort these small data sets) to get fully sorted file.
     */
}
