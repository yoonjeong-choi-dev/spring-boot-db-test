package com.yj.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC 관련 리소스 해제를 위한 유틸 클래스
public class JDBCUtil {
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
        }
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {

            }
        }
    }

    public static void close(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }


    public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        close(rs);
        close(stmt);
        close(conn);
    }

    public static void rollback(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {

            }
        }
    }
}
