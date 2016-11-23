package type.system_design;

/**
 * Author: blueaken
 * Date: 3/14/16 11:49 PM
 */
public class Tweet {
    public int id;
    public int user_id;
    public String text;

    public Tweet(int user_id, String text) {
        this.user_id = user_id;
        this.text = text;
    }

    public static Tweet create(int user_id, String tweet_text) {
        // This will create a new tweet object,
        // and auto fill id

        return null;
    }
}

