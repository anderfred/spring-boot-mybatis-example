package com.anderfred.mybatis.mapper;

import com.anderfred.mybatis.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user (name, salary) values(#{name}, #{salary})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(User user);
}
