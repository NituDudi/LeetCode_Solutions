## LeetCode 215 - Kth Largest Element in an Array
### Problem Statement: 
Given an integer array nums and an integer k, return the kth largest element in the array.
Note: It is the kth largest in sorted order, not the kth distinct element.

### Approach:
This solution uses a max-heap, implemented using Java's PriorityQueue with Collections.reverseOrder().
Add all elements from nums into a max-heap.
Remove the maximum element k - 1 times.
The next top of the heap is the kth largest element.

### Data Structures Used:
PriorityQueue (Max-Heap)
Java’s PriorityQueue is a min-heap by default.
We use Collections.reverseOrder() to make it behave like a max-heap.
Provides efficient access to the largest element using poll() and peek().


#### Time complexity- 0(n logn)

