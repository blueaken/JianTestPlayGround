like the analyze of clean book from straightforward to complexed:
1 - brute force: merge 2 lists first each time. O(nk^2)
2 - heap: similar to priority queue solution. O(nklogk) - each insert into the heap is O(logk), space O(k)
3 - divide and conquer, reuse merge 2 lists algorithm - O(nklogk), space O(1).
