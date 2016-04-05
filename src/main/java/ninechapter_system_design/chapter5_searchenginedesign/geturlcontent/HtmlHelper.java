package ninechapter_system_design.chapter5_searchenginedesign.geturlcontent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Author: blueaken
 * Date: 4/4/16 9:53 PM
 */
public class HtmlHelper {
    // Get all urls from a webpage of given url.
    public static List<String> parseUrls(String inputurl) {
        // get URL content
        URL url;
        String htmlContent = null;
        List<String> result;
        try {
            url = new URL(inputurl);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            br.close();

            htmlContent = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //parse html content
        result = ninechapter_system_design.chapter5_searchenginedesign.htmlparser.Solution.parseUrls(htmlContent);

        return result;
    }

    public static void main(String[] args) {
        //System.out.println(parseUrls("http://www.mkyong.com"));
        System.out.println(parseUrls("http://www.wenxuecity.com"));
    }

}
