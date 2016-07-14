Another "easy" but 1x% AC rate question. think clearly of the requirements before coding is the key to success.

Also the meat is to find overflow. Previously I used Long to parse the string value, but it doesn't work when the input is
Long overflow. The clean book solution is elegant - in each step it appends a digit to the number by doing a multiplication
 and addition. If the current number is greater than 214748364, we know it is going to overflow. On the other hand, if the
 current number is equal to 214748364, we know that it will overflow only when the current digit is greater than or equal to
 8. Remember to also consider edge case for the smallest number, –2147483648 (–231).
