package com.yj.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@ToString
public class UserVO {
    private long id;
    private String name;
    private String description;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public UserVO(ResultSet rs) throws SQLException {
        id = rs.getLong("id");
        name = rs.getString("name");
        description = rs.getString("description");
        createdAt = rs.getTimestamp("created_at");
        modifiedAt = rs.getTimestamp("modified_at");
    }

    @Builder
    public UserVO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
