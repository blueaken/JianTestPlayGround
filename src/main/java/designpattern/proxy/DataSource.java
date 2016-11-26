package designpattern.proxy;

import designpattern.proxy.staticproxy.ConnectionProxy_Static;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by jianshen on 11/24/16.
 */
public class DataSource {

    private static LinkedList<Connection> connectionList = new LinkedList<Connection>();

    //SJ: looks a legacy way of using JDBC - http://stackoverflow.com/questions/7662902/what-is-the-purpose-of-class-fornamemy-jdbc-driver
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection createNewConnection() throws SQLException{
        //SJ：实际使用中应该使用下面的方式，但是为了练习静态代理方便，使用临时方法
        //return DriverManager.getConnection("url","username", "password");
        return new ConnectionProxy_Static(connectionList.getFirst());
    }

    private DataSource(){
        if (connectionList == null || connectionList.size() == 0) {
            for (int i = 0; i < 10; i++) {
                try {
                    connectionList.add(createNewConnection());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Connection getConnection() throws Exception{
        if (connectionList.size() > 0) {
            //return connectionList.remove();  这是原有的方式，直接返回连接，这样可能会被程序员把连接给关闭掉
            //下面是使用代理的方式，程序员再调用close时，就会归还到连接池
            return new ConnectionProxy_Static(connectionList.remove());
        }
        return null;
    }

    public void recoveryConnection(Connection connection){
        connectionList.add(connection);
    }

    public static DataSource getInstance(){
        return DataSourceInstance.dataSource;
    }

    private static class DataSourceInstance{

        private static DataSource dataSource = new DataSource();

    }

}
