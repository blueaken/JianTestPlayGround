package lintcode.twopointers;

public class CompareVersionNumbers_LE_165 {
    /**
     11.20.2022
     ref solution
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n1 = v1.length, n2 = v2.length;

        int i1, i2;
        //note Integer.valueOf() can ignore the leading 0s of the string
        for (int i = 0; i < Math.max(n1, n2); i++) {
            i1 = i < n1 ? Integer.valueOf(v1[i]) : 0;
            i2 = i < n2 ? Integer.valueOf(v2[i]) : 0;

            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }
}
