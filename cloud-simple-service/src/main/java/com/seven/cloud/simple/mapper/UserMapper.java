package com.seven.cloud.simple.mapper;

import com.seven.cloud.simple.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
            "delete from t_user",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_user (id, name)",
            "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
    int insertSelective(User record);

    @Select({
            "select",
            "id, name",
            "from t_user",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Long id);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
            "update t_user",
            "set name = #{name,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}