package freq5;

/**
 * Author: blueaken
 * Date: 7/27/14 11:07 下午
 */
public class ValidateNumbers {
    public static boolean isNumber(String str) {
        if (str == null) return false;

        //remove begin and end white spaces
        str = str.trim();

        if (str.length()==0) return false;

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

        try{
            long temp = Long.parseLong(str);
        } catch (Exception e1){
            try{
                double temp = Double.parseDouble(str);
                return true;
            } catch (Exception e2){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
//        String test = " +321";
        //String test = " -321";
//        String test = " -321rrr";
//        String test = "- 321rrr";
//        String test = " 2e10";
//        String test = "3.65f";
        String test = "0xff";

        boolean value = isNumber(test);
        System.out.println("String " + test + " is a number: " + value);
    }

}
