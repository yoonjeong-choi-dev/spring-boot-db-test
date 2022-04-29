package com.yj.settings;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        properties = "spring.datasource.type=com.zaxxer.hikari.HikariDataSource"
)
public class DataSourceTest {
    private static final Logger log = Logger.getLogger(DataSourceTest.class.getName());

    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() {
        try (Connection conn = dataSource.getConnection()) {
            log.info("Hikari DataSource Test");
            log.info(conn.toString());
            log.info(conn.getSchema());
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }
}
