package ninechapter_system_design.chapter5_searchenginedesign.htmlparser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: blueaken
 * Date: 4/3/16 2:20 PM
 */
public class Solution {
    private static final String HTML_HREF_TAG_PATTERN = "\\s*(?i)href\\s*=\\s*\"?'?([^\"'>\\s]*)";
    /**
     * @param content source code
     * @return a list of links
     */
    public static List<String> parseUrls(String content) {
        // Write your code here
        List<String> result = new ArrayList<>();
        if (content == null || content.length() == 0) {
            return result;
        }

        Pattern p = Pattern.compile(HTML_HREF_TAG_PATTERN);
        Matcher m = p.matcher(content);

        while(m.find()){
            String cur = m.group();
            String url = cur.substring(cur.indexOf("\"")+1);
            if (url.startsWith("#")) {
                continue;
            }
            result.add(url);
        }

        return result;
    }

    public static void main(String[] args) {
        String test = "<html>\n" +
                "  <body>\n" +
                "    <div>\n" +
                "      <a href=\"http://www.google.com\" class=\"text-lg\">Google</a>\n" +
                "      <a href=\"http://www.facebook.com\" style=\"display:none\">Facebook</a>\n" +
                "    </div>\n" +
                "    <div>\n" +
                "      <a href=\"https://www.linkedin.com\">Linkedin</a>\n" +
                "      <a href = \"http://github.io\">LintCode</a>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>";

        System.out.println(parseUrls(test));
    }
}
