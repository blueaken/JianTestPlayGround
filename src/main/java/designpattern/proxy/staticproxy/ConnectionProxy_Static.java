package designpattern.proxy.staticproxy;

import designpattern.proxy.Connection;
import designpattern.proxy.DataSource;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jianshen on 11/24/16.
 */
public class ConnectionProxy_Static implements Connection {

    private Connection connection;

    public ConnectionProxy_Static(Connection connection) {
        super();
        this.connection = connection;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }



    //连接池我们把它做成单例，所以假设是上述连接池的话，我们代理中的close方法可以再具体化一点，就像下面这样，用归还给连接池的动作取代关闭连接的动作。
//    @Override
//    public void close() throws SQLException {
//        System.out.print("不真正关闭连接，归还给连接池");
//    }

    @Override
    public void close() throws SQLException{
        DataSource.getInstance().recoveryConnection(connection);
    }

}
