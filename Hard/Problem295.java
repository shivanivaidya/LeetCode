/*

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

*/

class Problem295 {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0 || maxHeap.peek() > num)
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        
        int maxSize = maxHeap.size();
        int minSize = minHeap.size();
        
        if(Math.abs(maxSize - minSize) > 1) {
            if(maxSize > minSize) 
                minHeap.offer(maxHeap.poll());
            else
                maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int maxSize = maxHeap.size();
        int minSize = minHeap.size();
        
        if(maxSize == minSize) 
            return (double) (maxHeap.peek() + minHeap.peek())/2;
        
        if(maxSize > minSize)
            return maxHeap.peek();
        else
            return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */