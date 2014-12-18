package freq5;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 7/19/14 3:42 下午
 */
public class ATOI {
    //level 3
    public static int atoi(String str) {
        //可以参考http://blog.csdn.net/fightforyourdream/article/details/13019151,
        //用Exception检查与用regex过滤white space
        //也可以考虑用trim()来过滤WHITE SPACE, 这篇分析的很好：http://www.2cto.com/kf/201403/285742.html

        int response_no_conversion = 0;
        int upLimit = Integer.MAX_VALUE;
        int lowLimit = Integer.MIN_VALUE;

        if (str == null) return response_no_conversion;

        char[] charArray = str.toCharArray();
        List<Character> signList = new ArrayList<Character>(2);
        signList.add('+');
        signList.add('-');

        boolean isStart = false;
        boolean isSignExist = false;
        char sign = 'n';
        StringBuilder temp = new StringBuilder();
        long tempLong = 0;

        for (char c : charArray){
            if (!isStart && !isSignExist && Character.isWhitespace(c)) continue;

            if (isSignExist && !isStart && !Character.isDigit(c)) return response_no_conversion;

            if (signList.contains(c)){
                sign = c;
                isSignExist = true;
                continue;
            }

            if (!Character.isDigit(c)){
                //if existing digit is not null return conversion
                if (temp.length() > 0){
                    break;
                } else{
                    return response_no_conversion;
                }

            } else {
                isStart = true;
                temp.append(c);
            }

        }

        if (temp.length() > 0){
            String valueString = temp.toString();
            if (sign == '-') {
                valueString = "-" + valueString;
            }
            tempLong = Long.parseLong(valueString);
        } else{
            return response_no_conversion;
        }

        if (tempLong > upLimit)
            return upLimit;
        if (tempLong < lowLimit)
            return lowLimit;
        else
            return (int)tempLong;

    }

    public static void main(String[] args){
        String test = " +321";
        int value = atoi(test);
        System.out.println("Conversion result is: " + value);
    }
}
