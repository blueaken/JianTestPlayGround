package interviewprep.source1.算法与编程.one;

import java.io.File;
import java.io.FileReader;

/**
 * Created by jianshen on 1/16/17.
 */
public class FileManager {
    String[] words = null;
    int pos = 0;

    public FileManager (String filename, char[] seperators) throws Exception  {
        File f = new File(filename);
        FileReader reader = new FileReader(f);
        char[] buf = new char[(int)f.length()];
        int len = reader.read(buf);

        String results = new String(buf, 0, len);
        String regex = null;
        if (seperators.length > 1) {
            regex = "" + seperators[0] + "|" + seperators[1];
        } else {
            regex = "" + seperators[0];
        }

        words = results.split(regex);
    }

    public String nextWord() {
        if (pos == words.length) {
            return null;
        } else {
            return words[pos++];
        }
    }
}
