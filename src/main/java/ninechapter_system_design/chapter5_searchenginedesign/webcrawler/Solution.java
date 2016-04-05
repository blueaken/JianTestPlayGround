package ninechapter_system_design.chapter5_searchenginedesign.webcrawler;

/**
 * Author: blueaken
 * Date: 4/4/16 2:50 PM
 */
/**
 * public class HtmlHelper {
 *     public static List<String> parseUrls(String url);
 *         // Get all urls from a webpage of given url.
 * }
 */
import ninechapter_system_design.chapter5_searchenginedesign.geturlcontent.HtmlHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.lang.Thread;
import java.net.*;

class CrawlerThread extends Thread {
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    private static HashMap<String, Boolean> mp = new HashMap<>();
    private static List<String> results = new ArrayList<>();

    public static void setFirstUrl(String url) {
        try {
            queue.put(url);
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
    }

    public static List<String> getResults() {
        return results;
    }

    @Override
    public void run() {
        while (true) {
            String url = "";
            try {
                url = queue.take();
            } catch (Exception e) {
                // e.printStackTrace();
                break;
            }

            String domain = "";
            try {
                URL netUrl = new URL(url);
                domain = netUrl.getHost();
            } catch (MalformedURLException e) {
                // e.printStackTrace();
            }
            if (!mp.containsKey(url)) {
                mp.put(url, true);
                results.add(url);
                List<String> urls = HtmlHelper.parseUrls(url);
                for (String u : urls) {
                    try {
                        queue.put(u);
                    } catch (InterruptedException e) {
                        // e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class Solution {
    /**
     * @param inputurl a url of root page
     * @return all urls
     */
    public static List<String> crawler(String inputurl) {
        // Write your code here
        CrawlerThread.setFirstUrl(inputurl);
        CrawlerThread[] thread_pools = new CrawlerThread[7];
        for (int i = 0; i < 7; ++i) {
            thread_pools[i] = new CrawlerThread();
            thread_pools[i].start();
        }

        try {
            Thread.sleep(900);
        } catch (InterruptedException e){
            // e.printStackTrace();
        }

        for (int i = 0; i < 7; ++i) {
            //thread_pools[i].interrupt();
            thread_pools[i].stop();
        }

        List<String> results = CrawlerThread.getResults();
        return results;
    }

    public static void main(String[] args) {
        //System.out.println(crawler("http://www.wikipedia.org/"));
        System.out.println(crawler("http://www.mkyong.com/"));
    }
}
