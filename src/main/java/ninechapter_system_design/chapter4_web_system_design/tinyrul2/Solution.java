package ninechapter_system_design.chapter4_web_system_design.tinyrul2;

import java.util.HashMap;

/**
 * Author: blueaken
 * Date: 3/29/16 10:13 AM
 */
public class Solution {
    private static int GLOBAL_ID = 0;
    private HashMap<Integer, String> id2url = new HashMap<Integer, String>();
    private HashMap<String, Integer> url2id = new HashMap<String, Integer>();
    private HashMap<String, String> customerKey2url = new HashMap<String, String>();
    private HashMap<String, String> url2CustomerKey = new HashMap<String, String>();

    private static final String TINYURL = "http://tiny.url/";

    int toBase62(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        return c - 'A' + 36;
    }

    int shortURLtoID(String shortURL) {
        int id = 0;
        for (int i = 0; i < shortURL.length(); ++i) {
            id = id * 62 + toBase62(shortURL.charAt(i));
        }
        return id;
    }

    String idToShortURL(int id) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String short_url = "";
        while (id > 0) {
            short_url = chars.charAt(id % 62) + short_url;
            id = id / 62;
        }
        while (short_url.length() < 6) {
            short_url = "0" + short_url;
        }
        return short_url;
    }

    /**
     * @param long_url a long url
     * @param short_key a short key
     * @return a short url starts with http://tiny.url/
     */
    String createCustom(String long_url, String short_key) {
        // Write your code here
        if (url2CustomerKey.containsKey(long_url)) {
            return "error";
        }
        if (customerKey2url.containsKey(short_key)) {

        }
        url2CustomerKey.put(long_url, short_key);
        customerKey2url.put(short_key, long_url);
        return TINYURL + short_key;
    }

    /**
     * @param url a long url
     * @return a short url
     */
    public String longToShort(String url) {
        if (url2CustomerKey.containsKey(url)) {
            return TINYURL + url2CustomerKey.get(url);
        }
        if (url2id.containsKey(url)) {
            return TINYURL + this.idToShortURL(url2id.get(url));
        }
        GLOBAL_ID++;
        //avoid short key conflicts with customer url table
        while (customerKey2url.containsKey(this.idToShortURL(GLOBAL_ID))) {
            GLOBAL_ID++;
        }
        url2id.put(url, GLOBAL_ID);
        id2url.put(GLOBAL_ID, url);
        return TINYURL + this.idToShortURL(GLOBAL_ID);
    }

    /**
     * @param url a short url
     * @return a long url
     */
    public String shortToLong(String url) {
        if (url.startsWith(TINYURL)) {
            url = url.substring(16);
        }
        if (customerKey2url.containsKey(url)) {
            return customerKey2url.get(url);
        }
        int id = this.shortURLtoID(url.substring(1));
        return id2url.get(id);
    }
}
