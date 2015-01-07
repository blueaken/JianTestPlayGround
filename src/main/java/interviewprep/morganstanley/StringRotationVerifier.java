package interviewprep.morganstanley;

/**
 * Created by jianshen on 12/23/14.
 */
public class StringRotationVerifier {
    public static void main(String[] args){
        String str1 = "Password";
        String str2 = "ordPassw";

        isRotation(str1, str2);
    }

    private static void isRotation(String str1, String str2){
        if (str1 == null || str2 == null) {
            System.out.println("Input string is null.");
            return;
        }

        if (str1.length() == str2.length() && (str1+str1).indexOf(str2) != -1){
            System.out.println("String 2 is the rotation of String 1.");
        } else {
            System.out.println("String 2 is not the rotation of String 1.");
        }

        return;
    }

    /*
    * first attempt - works but clumsy, see this post has a very elegant solution:
    * http://stackoverflow.com/questions/2553522/interview-question-check-if-one-string-is-a-rotation-of-other-string
     */
//    private static void isRotation(String str1, String str2){
//        if (str1 == null || str2 == null) {
//            System.out.println("Input string is null.");
//            return;
//        }
//
//        if (str1.length() != str2.length()){
//            System.out.println("String 2 is not the rotation of String 1.");
//            return;
//        }
//
//        int ind1 = 0;
//        int ind2 = 0;
//        boolean findStartChar = false;
//        while (ind2 < str2.length()){
//            if (str2.charAt(ind2) == str1.charAt(ind1)){
//                findStartChar = true;
//                break;
//            }
//            ind2++;
//        }
//
//        if(!findStartChar){
//            System.out.println("String 2 is not the rotation of String 1.");
//            return;
//        }
//
//        int str2StartPos = ind2;
//        while (ind2 < str2.length() && str1.charAt(ind1) == str2.charAt(ind2)){
//            ind1++; ind2++;
//        }
//
//        if (ind2 != str2.length()){
//            System.out.println("String 2 is not the rotation of String 1.");
//            return;
//        }
//
//        ind2 = 0;
//        while(ind2 < str2StartPos && str1.charAt(ind1) == str2.charAt(ind2)) {
//            ind1++; ind2++;
//        }
//
//        if (ind2 != str2StartPos){
//            System.out.println("String 2 is not the rotation of String 1.");
//            return;
//        }
//
//        System.out.println("String 2 is the rotation of String 1.");
//        return;
//    }
}
