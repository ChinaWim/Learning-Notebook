package 算法.剑指offer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class JDBCPool {
    private static int init;

    private static int max;

    private static int currentSize;

    private static String url;

    private static LinkedList<Connection> connectionList = new LinkedList<>();

    private JDBCPool() {
    }

    static {
        try {
            Class.forName("com.jdbc.mysql.Driver");
            for (int i = 0; i < init; i++) {
                connectionList.add(DriverManager.getConnection(url));
                currentSize++;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnection() throws Exception {
        if (connectionList.size() > 0) {
            return connectionList.poll();
        }
        if (currentSize <= max) {
            currentSize++;
            return DriverManager.getConnection(url);
        }
        throw new RuntimeException("超过最大连接数");
    }

    public static void releaseConnection(Connection connection) {
        connectionList.add(connection);
    }


}