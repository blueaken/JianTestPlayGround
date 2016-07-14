A tricky one for me - spend some time to understand the solution.

When you have found a repeated character (let’s say at index j), it means that the current
substring (excluding the repeated character of course) is a potential maximum, so update
the maximum if necessary. It also means that the repeated character must have appeared
before at an index i, where i is less than j.
Since you know that all substrings that start before or at index i would be less than your
current maximum, you can safely start to look for the next substring with head which
starts exactly at index i + 1.
Therefore, you would need two indices to record the head and the tail of the current
substring. Since i and j both traverse at most n steps, the worst case would be 2n steps,
which the runtime complexity must be O(n).