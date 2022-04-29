package com.yj.domain.dao;

import com.yj.domain.dto.UserVO;
import com.yj.util.JDBCUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class UserDao {
    private final DataSource dataSource;

    public List<UserVO> selectList() throws SQLException {
        // 먼저 등록된 유저 순으로 반환
        String query = "select * from user order by id";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // connect and query
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            // parse result
            List<UserVO> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new UserVO(rs));
            }

            return users;
        } finally {
            JDBCUtil.close(conn, stmt, rs);
        }
    }

    public UserVO selectById(long id) throws SQLException {
        String query = String.format("select * from user where id = %d", id);
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // connect and query
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            // parse result
            if (rs.next()) {
                return new UserVO(rs);
            } else {
                return null;
            }
        } finally {
            JDBCUtil.close(conn, stmt, rs);
        }
    }
}
