package ninechapter_system_design.chapter2_database_design.minicassandra;

import type.system_design.Column;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 3/20/16 5:53 PM
 */
public class MiniCassandra {
    private Map<String, List<Column>> map;

    public MiniCassandra() {
        // initialize your data structure here.
        this.map = new HashMap<>();
    }

    /**
     * @param raw_key a string
     * @param column_key an integer
     * @param column_value a string
     * @return void
     */
    public void insert(String raw_key, int column_key, String column_value) {
        // Write your code here
        List<Column> current = this.map.get(raw_key);
        if (current == null) {
            current = new ArrayList<>();
        }

        Column column = new Column(column_key, column_value);
        current.add(column);
        this.map.put(raw_key, current);
    }

    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
        // Write your code here
        List<Column> current = this.map.get(raw_key);
        if (current == null) {
            return current;
        }

        int startInx = 0;
        int endInx = 0;
        for (int i = 0; i < current.size(); i++) {
            Column column = current.get(i);
            if (column.key == column_start) {
                startInx = i;
            }
            if (column.key <= column_end) {
                endInx = i + 1;
            }
        }

        if (startInx == -1) {
            return new ArrayList<>();
        }

        return current.subList(startInx, endInx);
    }

    public static void main(String[] args) {
        MiniCassandra miniCassandra = new MiniCassandra();
        miniCassandra.insert("google", 1, "haha");
        miniCassandra.insert("lintcode", 1, "Good");
        miniCassandra.insert("google", 2, "hehe");

        System.out.println(miniCassandra.query("google", 0, 1));
        System.out.println(miniCassandra.query("google", 0, 2));
        System.out.println(miniCassandra.query("go", 0, 1));
        System.out.println(miniCassandra.query("lintcode", 0, 10));
    }
}
