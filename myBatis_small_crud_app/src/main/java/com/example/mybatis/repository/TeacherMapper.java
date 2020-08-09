package com.example.mybatis.repository;

import com.example.mybatis.model.Teacher;
import com.example.mybatis.repository.sqlBuilder.TeacherSqlBuilder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstname", column = "firstname"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "birthdate", column = "birthdate"),
            @Result(property = "email", column = "email")
    })
    @Select("SELECT * FROM teachers")
    List<Teacher> findAll();

    @SelectProvider(type = TeacherSqlBuilder.class, method = "buildGetTeacherByEmail")
    Teacher getTeacherByEmail(String Email);

    @SelectProvider(type = TeacherSqlBuilder.class, method = "buildGetTeachersPage")
    List<Teacher> findPage(Integer offset, Integer limit, String orderMethod, String orderField);

    @Select("SELECT * FROM teachers WHERE id = #{teacherId}")
    Teacher findById(Integer teacherId);

    @Insert("INSERT INTO teachers(id, firstname, lastname, email, birthdate)" +
            " VALUES (null, #{firstname}, #{lastname}, #{email}, #{birthdate})")
    void insert(Teacher teacher);

    @Update("UPDATE teachers SET firstname = #{firstname}, lastname = #{lastname}, email = #{email}, birthdate = #{birthdate}" +
            " WHERE id = #{id}")
    void update(Teacher teacher);

    @Delete("DELETE FROM teachers WHERE id=#{id}")
    void delete(Integer teacher);
}
