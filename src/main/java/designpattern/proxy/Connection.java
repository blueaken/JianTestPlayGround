package designpattern.proxy;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jianshen on 11/24/16.
 */
public interface Connection {
    Statement createStatement() throws SQLException;

    void close() throws SQLException;
}
