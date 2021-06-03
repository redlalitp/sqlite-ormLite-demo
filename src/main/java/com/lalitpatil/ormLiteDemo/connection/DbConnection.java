package com.lalitpatil.ormLiteDemo.connection;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class DbConnection {

    static String databaseUrl = "jdbc:sqlite:slack.db";

    public static ConnectionSource connectionSource = null;

    public DbConnection() throws SQLException {
        if(connectionSource == null) {
            connectionSource = new JdbcConnectionSource(databaseUrl);
        }
    }

    public static ConnectionSource getConnectionSource() {
        return connectionSource;
    }
}
