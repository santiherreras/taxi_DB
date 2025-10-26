package com.solvd.taxi.config;


import java.sql.*;
import java.util.*;

public class ConnectionPool {
    private static final int POOL_SIZE = 5;
    private static final Queue<Connection> pool = new LinkedList<>();
    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            Properties props = new Properties();
            props.load(ConnectionPool.class.getClassLoader().getResourceAsStream("db.properties"));
            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

            for (int i = 0; i < POOL_SIZE; i++) {
                pool.add(DriverManager.getConnection(url, user, password));
            }
            System.out.println("✅ Connection pool initialized with " + POOL_SIZE + " connections.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnection() throws SQLException {
        if (pool.isEmpty()) {
            return DriverManager.getConnection(url, user, password);
        }
        return pool.poll();
    }

    public static synchronized void releaseConnection(Connection conn) {
        if (conn != null) {
            pool.offer(conn);
        }
    }
}
