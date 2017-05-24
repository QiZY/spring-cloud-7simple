package com.seven.cloud.simple.mapper;

import com.seven.cloud.simple.domain.User;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

public class UserSqlProvider {

    public String insertSelective(User record) {
        BEGIN();
        INSERT_INTO("t_user");

        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }

        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(User record) {
        BEGIN();
        UPDATE("t_user");

        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }

        WHERE("id = #{id,jdbcType=BIGINT}");

        return SQL();
    }
}