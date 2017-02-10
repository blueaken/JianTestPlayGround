inspired by 2.9.2017 MS onsite interview -

Why LinkedList(LL) is faster than ArrayList(AL) in add/remove?

It is a commonly asked question, but the tricky part is: if LL need to iterate to find the position first then the time
 cost should still be O(n), in real world the AL is actual faster than LL since since AL's System.arraycopy is a
 blazing-fast operation and, on the other hand, each insertion into LL requires the allocation of node instance.

After research, it looks use List Iterator to remove/add can achieve constant time because the it can remember the
last position to insert/remove, but it can only insert/remove for the last position. And the benefit will show up when
the list size is bigger than 1000 due to some expensive heads up setup (I guess).

Here is a testing to code to verify this thoughts.

Ref:
http://stackoverflow.com/questions/16808777/is-linkedlist-really-faster-than-arraylist-in-the-case-of-insertion-in-the-middl
