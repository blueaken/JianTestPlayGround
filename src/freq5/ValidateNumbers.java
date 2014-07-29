package freq5;

/**
 * Author: blueaken
 * Date: 7/27/14 11:07 下午
 */
public class ValidateNumbers {
    //my first try
//    public static boolean isNumber(String str) {
//        if (str == null) return false;
//
//        //remove begin and end white spaces
//        str = str.trim();
//
//        if (str.length()==0) return false;
//
//        try{
//            Long.parseLong(str);
//            return true;
//        } catch (Exception e1){
//            try{
//                Float.parseFloat(str);
//                return true;
//            } catch (Exception e2){
//                try{
//                    Double.parseDouble(str);
//                    return true;
//                } catch (Exception e3){
//                    return false;
//                }
//            }
//        }
//
//    }

    //fight for your dreams 的解法，直接用正则表达式
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

    public static void main(String[] args){
//        String test = " +321";
        //String test = " -321";
//        String test = " -321rrr";
//        String test = "- 321rrr";
//        String test = " 2e10";
//        String test = "3.65f";
//        String test = "0xff";
        String test = "959440.94f";

        boolean value = isNumber(test);
        System.out.println("String " + test + " is a number: " + value);
    }

}
