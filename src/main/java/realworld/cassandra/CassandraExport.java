package realworld.cassandra;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ColumnDefinitions.Definition;
import com.datastax.driver.core.DataType;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

/**
 * Created by jshe18 on 12/15/15.
 * note: works only in local evn, in aws cluster, we use eurika lookup to find target servers. To make it work, has to
 * deploy it in test/prod env, which is not an option today.
 */
public class CassandraExport {
    public static void main( String[] args )
    {
        String keyspace = "notification_domain";
        String table = "notification_lookup";
        String username = "jshe18";
        String password = "123456Ss@";
        String host = "127.0.0.1";

        Cluster.Builder clusterBuilder = Cluster.builder()
                .addContactPoints(host)
                .withCredentials(username, password);
        Cluster cluster = clusterBuilder.build();
        Session session = cluster.connect(keyspace);

        Statement stmt = new SimpleStatement("SELECT * FROM " + table);
        stmt.setFetchSize(1000);
        ResultSet rs = session.execute(stmt);
        Iterator<Row> iter = rs.iterator();

        while (!rs.isFullyFetched()) {
            rs.fetchMoreResults();
            Row row = iter.next();
            if (row != null)
            {
                StringBuilder line = new StringBuilder();
                for (Definition key : row.getColumnDefinitions().asList())
                {
                    String val = myGetValue(key, row);
                    line.append("\"");
                    line.append(val);
                    line.append("\"");
                    line.append(",");
                }
                line.deleteCharAt(line.length()-1);
                System.out.println(line.toString());
            }
        }

        session.close();
        cluster.close();

    }

    public static String myGetValue(Definition key, Row row)
    {
        String str = "";

        if (key != null)
        {
            String col = key.getName();

            try
            {
                if (key.getType() == DataType.timeuuid())
                {
                    str = row.getUUID(col).toString();
                }
                else if (key.getType() == DataType.cint())
                {
                    str = new Integer(row.getInt(col)).toString();
                }
                else if (key.getType() == DataType.uuid())
                {
                    str = row.getUUID(col).toString();
                }
                else if (key.getType() == DataType.cfloat())
                {
                    str = new Float(row.getFloat(col)).toString();
                }
                else if (key.getType() == DataType.timestamp())
                {
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
                    str = fmt.format(row.getDate(col));
                }
                else
                {
                    str = row.getString(col);
                }
            } catch (Exception e)
            {
                str = "";
            }
        }

        return str;
    }
}
