follow clean book solution

==================
This makes the problem a lot more complicated, because it can be called multiple times
and involves storing states.

Therefore, we design the following class member variables to store the states:

i. buffer – An array of size 4 use to store data returned by read4 temporarily. If
the characters were read into the buffer and were not used partially, they will
be used in the next call.

ii. offset – Use to keep track of the offset index where the data begins in the next
read call. The buffer could be read partially (due to constraints of reading up
to n bytes) and therefore leaving some data behind.

iii. bufsize – The real buffer size that stores the actual data. If bufsize > 0, that
means there is partial data left in buffer from the last read call and we should
consume it before calling read4 again. On the other hand, if bufsize == 0, it
means there is no data left in buffer.

This problem is a very good coding exercise. Coding it correctly is extremely tricky due
to the amount of edge cases to consider.
