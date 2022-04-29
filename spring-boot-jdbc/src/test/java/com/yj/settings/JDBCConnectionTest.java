package com.yj.settings;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.fail;

public class JDBCConnectionTest {

    private static final Logger log = Logger.getLogger(JDBCConnectionTest.class.getName());

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        String url = "jdbc:mysql://localhost:3306/SpringBootDBTest";
        String user = "springBootDBTestUser";
        String pw = "springBootDBTestPassword";

        try (Connection conn = DriverManager.getConnection(url, user, pw)) {
            log.info("Success to connect");
            log.info(conn.toString());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
