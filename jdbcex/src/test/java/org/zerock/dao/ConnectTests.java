package org.zerock.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {
    @Test
    public void testConnections() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/webdb",
                "webuser",
                "webuser");

        Assertions.assertNotNull(connection);

        connection.close();
    }

    @Test
    public void testHikariCP() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        /*
        cachePrepStmts - Prepared Statement 캐싱여부
        prepStmtCacheSize - 하나의 커넥션에 캐싱할 PrepStmt의 개수
        prepStmtCacheSqlLimit - 캐싱할 PrepStmt의 최대길이
         */
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();
    }
}
