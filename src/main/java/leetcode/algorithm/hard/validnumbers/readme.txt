//try the solution similar to atoi

Not frequent on interview since it is intended for the problem statement to be ambiguous. You have to gather all
requirements up front before implementing one. My solution's assumption is as follows:

 s1. Leading whitespaces (optional).
 s2. Plus (+) or minus (–) sign (optional).
 s3. Number.
 s4. Optional trailing whitespaces (optional).

 We ignore s1, s2, s4 and evaluate whether s3 is a valid number. We realize that a number
 could either be a whole number or a decimal number. For a whole number, it is easy: We
 evaluate whether s3 contains only digits and we are done.

 On the other hand, a decimal number could be further divided into three parts:
 a. Integer part
 b. Decimal point
 c. Fractional part

 The integer and fractional parts contain only digits. For example, the number “3.64” has
 integer part (3) and fractional part (64). Both of them are optional, but at least one of
 them must present. For example, a single dot ‘.’ is not a valid number, but “1.”, “.1”, and
 “1.0” are all valid. Please note that “1.” is valid because it implies “1.0”.


Further Thoughts:

A number could contain an optional exponent part, which is marked by a character ‘e’
followed by a whole number (exponent). For example, “1e10” is numeric. Modify the code to adapt to this new requirement.

This is pretty straightforward to extend from the previous solution. Solution_WithE

Note there is a bug on the "e" logic on the example of the clean book, which takes "e9" as true, but OJ takes it as fales.
It is fixed in Solution_WithE.

//can also consider fighting for your dreams 的解法，直接用正则表达式
    public static boolean isNumber(String s) {
        if(s.trim().isEmpty()){
            return false;
        }
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        if(s.trim().matches(regex)){
            return true;
        }else{
            return false;
        }
    }

