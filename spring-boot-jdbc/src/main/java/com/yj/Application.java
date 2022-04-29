package com.yj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    DataSource dataSource;

    @Override
    public void run(String... args) {
        dataSourceTest();
    }

    private void dataSourceTest() {
        try (Connection conn = dataSource.getConnection()) {
            log.info("Hikari DataSource Test");
            log.info(conn.toString());
        } catch (SQLException e) {
            log.warning(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
