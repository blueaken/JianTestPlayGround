package leetcode.algorithm.easy.readncharactersgivenread4;

import type.Reader4;

/**
 * Author: blueaken
 * Date: 1/27/16 6:00 PM
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean eof = false;
        int bytesRead = 0;
        while (!eof && bytesRead < n){
            int temp = read4(buffer);
            if (temp<4) eof = true;
            int bytes = Math.min(n-bytesRead, temp);  // to ensure the number copied not beyond n
            System.arraycopy(buffer /* src */, 0 /* srcPos */, buf /* dest */, bytesRead /* destPos */, bytes /* length */);
            bytesRead += bytes;
        }

        return bytesRead;
    }
}
