package freq5;

/**
 * Author: blueaken
 * Date: 7/19/14 11:17 下午
 */
public class ATOI_Improved {
    public static int atoi(String str) {
        int response_no_conversion = 0;
        int upLimit = Integer.MAX_VALUE;
        int lowLimit = Integer.MIN_VALUE;

        if (str == null || str.length()==0) return response_no_conversion;

        //remove begin and end white spaces
        str = str.trim();

        //process sign
        char firstChar = str.charAt(0);
        boolean isNeg = false;
        if (firstChar == '+'){
            str = str.substring(1);
        }
        if (firstChar == '-'){
            str = str.substring(1);
            isNeg = true;
        }

        //git rid of chars from first non-digit char
        char[] input = str.toCharArray();
        for (int i=0; i<input.length; i++){
            if (Character.isDigit(input[i])){
                continue;
            }

            str = str.substring(0, i);
            break;
        }

        //process main logic
        long temp = 0;
        if (isNeg){
            str = "-" + str;
        }
        try{
            temp = Long.parseLong(str);
        } catch (Exception e){
            return response_no_conversion;
        }

        if (temp > upLimit)
            return upLimit;
        if (temp < lowLimit)
            return lowLimit;
        else
            return (int)temp;

    }

    public static void main(String[] args){
        //String test = " +321";
        //String test = " -321";
//        String test = " -321rrr";
//        String test = "- 321rrr";
        String test = " +3 21";
        int value = atoi(test);
        System.out.println("Conversion result is: " + value);
    }
}
