#167 Two Sum II - Input array is sorted
(paid question)

O(n) runtime, O(1) space – Two pointers:
Let’s assume we have two indices pointing to the ith and jth elements, Ai and Aj
respectively. The sum of Ai and Aj could only fall into one of these three possibilities:
i. Ai + Aj > target. Increasing i isn’t going to help us, as it makes the sum even
bigger. Therefore we should decrement j.
ii. Ai + Aj < target. Decreasing j isn’t going to help us, as it makes the sum even
smaller. Therefore we should increment i.
iii. Ai + Aj == target. We have found the answer.

Clean Code book