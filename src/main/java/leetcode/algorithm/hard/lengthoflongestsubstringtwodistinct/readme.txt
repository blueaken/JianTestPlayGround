The clean book generalized solution makes more sense to me, notice it also use a ascii char size array:

Although the above method works fine, it could not be easily generalized to the case
where T contains at most k distinct characters.
The key is when we adjust the sliding window to satisfy the invariant, we need a counter
of the number of times each character appears in the substring.