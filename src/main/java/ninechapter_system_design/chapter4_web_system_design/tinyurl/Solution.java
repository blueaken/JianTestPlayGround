package ninechapter_system_design.chapter4_web_system_design.tinyurl;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 3/28/16 2:42 PM
 */
public class Solution {

    public static int GLOBAL_ID = 0;
    private static Map<Integer, String> id2url = new HashMap<>();
    private static Map<String, Integer> url2id = new HashMap<>();

    public static String longToShort(String longURL) {
        // Write your code here
        if (url2id.containsKey(longURL)) {
            return idToShortURL(url2id.get(longURL));
        }

        GLOBAL_ID++;
        id2url.put(GLOBAL_ID, longURL);
        url2id.put(longURL, GLOBAL_ID);
        return idToShortURL(GLOBAL_ID);
    }

    public static String shortToLong(String shortURL) {
        // Write your code here
        // 1st position is for sharding
        int id = shortURLtoID(shortURL.substring(1));
//        int id = shortURLtoID(shortURL);
        return id2url.get(id);
    }

    private static String idToShortURL(int id) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String short_url = "";
        while (id > 0) {
            //build the short url from last char
            short_url = chars.charAt(id % 62) + short_url;
            id = id / 62;
        }
        while (short_url.length() < 6) {
            short_url = "0" + short_url;
        }
        //        return "http://tinyurl.com/" + short_url;
        return short_url;

    }

    private static int shortURLtoID(String shortURL) {
        int id = 0;
        for (int i = 0; i < shortURL.length(); i++) {
            id = id * 62 + toBase62(shortURL.charAt(i));
        }
        return id;
    }

    private static int toBase62(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }

        return -1;
    }

    public static void main(String[] args) {
        String longURL1 = "www.jiuzhang.com/";
        String longURL2 = "www.google.com/";


//        System.out.println("id from short url: " + shortURLtoID(shortURL));
//
//        System.out.println("id to short url: " + idToShortURL(3971));

        String shortURL1 = longToShort(longURL1);

        String shortURL2 = longToShort(longURL2);

        System.out.println("short url 2 from long: " + shortURL2);

        System.out.println("long url 2 from short:" + shortToLong(shortURL2));

        System.out.println(shortToLong(longToShort("http://www.lintcode.com/faq/?id=10")));
    }
}
