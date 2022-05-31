package lintcode.string;

import java.util.*;

/*
    - ref solution link and choose the approach 1 - https://leetcode.com/problems/design-in-memory-file-system/solution/
    - this approach uses a class with 2 seperate hash maps - one for directory, and one for file seperately
    - the advantage of this approach is it is easy to expand for more commands, ex rmdir, just need to read the destination directoy and remove the corresponding directory entry for dir keys.
    - rename is also simple, we just need to copy a temp directory and delete the old one
    - extract only dirs or files is alos easy, since we maintian seperate entries for dirs and files
*/
public class InMemoryFileSystem_LE_588 {
    class Dir {
        Map<String, String> files = new HashMap<>();
        Map<String, Dir> dirs = new HashMap<>();
    }

    Dir root;

    public InMemoryFileSystem_LE_588() {
        root = new Dir();
    }

    /*
        Time is O(m + n + klogk), m is the length of path for the split operation, n is the number of paths for the path iteration, k is the number of dirs and files of the destinations, the sort operation takes klogk time.
    */
    public List<String> ls(String path) {
        Dir t = root;
        List<String> files = new ArrayList<>();
        if (!path.equals("/")) {
            String[] paths = path.split("/");
            //iterate to the last dir, return empty list if path not match input
            for (int i = 1; i < paths.length - 1; i++) {
                String cur = paths[i];
                if (t.dirs.containsKey(cur)) {
                    t = t.dirs.get(cur);
                } else {
                    return files; //if not found return empty list
                }
            }
            if (t.files.containsKey(paths[paths.length - 1])) {
                files.add(paths[paths.length - 1]); //if last entry is file then just return the file name
                return files;
            }
            else {// if last entry is dir then return the list of its files and dir names, processed in the last step
                t = t.dirs.get(paths[paths.length - 1]);
            }
        }
        files.addAll(t.dirs.keySet());
        files.addAll(t.files.keySet());
        Collections.sort(files);

        return files;
    }

    /*
        - Note: If the middle directories in the path do not exist, you should create them as well.
        - Time is O(m + n), m is the length of path string for the split operation and n is the number of paths for the path iteration.
    */
    public void mkdir(String path) {
        Dir t = root;
        String paths[] = path.split("/");
        //iterate through the pass, create middle path entry as well if not exists
        for (int i = 1; i < paths.length; i++) {
            if (!t.dirs.containsKey(paths[i])) {
                t.dirs.put(paths[i], new Dir());
            }
            t = t.dirs.get(paths[i]);
        }
    }

    /*
        - Time is O(m + n), m is the length of path string for the split operation and n is the number of paths for the path iteration.
    */
    public void addContentToFile(String filePath, String content) {
        Dir t = root;
        String[] paths = filePath.split("/");
        for (int i = 1; i < paths.length - 1; i++) {
            t = t.dirs.get(paths[i]);
        }
        t.files.put(paths[paths.length - 1], t.files.getOrDefault(paths[paths.length - 1], "") + content);
    }

    /*
        - Time is O(m + n), m is the length of path string for the split operation and n is the number of paths for the path iteration.
    */
    public String readContentFromFile(String filePath) {
        Dir t = root;
        String[] paths = filePath.split("/");
        for (int i = 1; i < paths.length - 1; i++) {
            t = t.dirs.get(paths[i]);
        }
        return t.files.get(paths[paths.length - 1]);
    }
}
