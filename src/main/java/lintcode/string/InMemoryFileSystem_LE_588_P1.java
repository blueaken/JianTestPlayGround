package lintcode.string;

import java.util.*;

/*
    - ref solution link and choose the approach 1 - https://leetcode.com/problems/design-in-memory-file-system/solution/
    - this approach uses a class with 2 separate hash maps - one for directory, and one for file seperately
    - the advantage of this approach is it is easy to expand for more commands, ex rmdir, just need to read the destination directoy and remove the corresponding directory entry for dir keys.
    - rename is also simple, we just need to copy a temp directory and delete the old one
    - extract only dirs or files is also easy, since we maintain separate entries for dirs and files
*/
public class InMemoryFileSystem_LE_588_P1 {
    class Dir {
        Map<String, Dir> dirs = new HashMap<>();
        Map<String, String> files = new HashMap<>();
    }

    Dir root;

    public InMemoryFileSystem_LE_588_P1() {
        root = new Dir();
    }

    /*
        Time is O(m + n + klogk), m is the length of path for the split operation, n is the number of paths for the path iteration, k is the number of dirs and files of the destinations, the sort operation takes klogk time.
    */
    public List<String> ls(String path) {
        List<String> res = new ArrayList<>();
        Dir t = root;
        if (!path.equals("/")) {
            String[] paths = path.split("/");
            for (int i = 1; i < paths.length - 1; i++) {
                String cur = paths[i];
                if (!t.dirs.containsKey(cur)) {//if path does not exist, return empty list;
                    return res;
                }
                t = t.dirs.get(cur);
            }
            String cur = paths[paths.length-1];
            if (t.files.containsKey(cur)) {
                //if last entry is a file, then just return the file name
                res.add(cur);
                return res;
            }
            t = t.dirs.get(cur);
        }
        //if the last entry is a dir, add it sub dir and file names into the list, sort and return;
        res.addAll(t.dirs.keySet());
        res.addAll(t.files.keySet());
        Collections.sort(res);
        return res;
    }

    /*
        - Note: If the middle directories in the path do not exist, you should create them as well.
        - Time is O(m + n), m is the length of path string for the split operation and n is the number of paths for the path iteration.
    */
    public void mkdir(String path) {
        Dir t = root;
        String[] paths = path.split("/");
        for (int i = 1; i < paths.length; i++) {
            String cur = paths[i];
            if (!t.dirs.containsKey(cur)) {
                t.dirs.put(cur, new Dir());
            }
            t = t.dirs.get(cur);
        }
    }

    /*
        - Time is O(m + n), m is the length of path string for the split operation and n is the number of paths for the path iteration.
    */
    public void addContentToFile(String filePath, String content) {
        Dir t = root;
        String[] paths = filePath.split("/");
        for (int i = 1; i < paths.length - 1; i++) {
            String cur = paths[i];
            if (!t.dirs.containsKey(cur)) {
                return;
            }
            t = t.dirs.get(cur);
        }
        String file = paths[paths.length - 1];
        t.files.put(file, t.files.getOrDefault(file, "") + content);
    }

    /*
        - Time is O(m + n), m is the length of path string for the split operation and n is the number of paths for the path iteration.
    */
    public String readContentFromFile(String filePath) {
        Dir t = root;
        String paths[] = filePath.split("/");
        for (int i = 1; i < paths.length - 1; i++) {
            String cur = paths[i];
            t = t.dirs.get(cur);
        }
        String file = paths[paths.length - 1];
        return t.files.get(file);
    }
}
