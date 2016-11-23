package leetcode.algorithm.hard.readncharactersgivenread4_2;

import type.Reader4;

/**
 * Author: blueaken
 * Date: 1/28/16 11:03 AM
 */
public class Solution extends Reader4{
    private char[] buffer = new char[4];
    private int offset = 0;
    private int bufsize = 0;

    /**
     * @param buf Destination buffer
     * @param n Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int bytesRead = 0;
        while (!eof && bytesRead < n){
            if (bufsize==0){
                int bufsize = read4(buffer);
                if (bufsize<4) eof = true;
            }
            int bytes = Math.min(n-bytesRead, bufsize);  // to ensure the number copied not beyond n
            System.arraycopy(buffer /* src */, offset /* srcPos */, buf /* dest */, bytesRead /* destPos */, bytes /* length */);

            offset = (offset+bytes)%4;
            bufsize -= bytes;
            bytesRead += bytes;
        }

        return bytesRead;
    }
}
