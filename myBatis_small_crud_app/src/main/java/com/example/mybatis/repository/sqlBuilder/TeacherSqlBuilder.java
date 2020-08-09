package com.example.mybatis.repository.sqlBuilder;

import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

public class TeacherSqlBuilder {


    public static String buildGetTeacherByEmail(final String email) {
        return new SQL(){{
            SELECT("*");
            FROM("teachers");
            WHERE("email like #{email} || '%'");
            ORDER_BY("id");
        }}.toString();
    }


    @Select("SELECT * FROM teachers ORDER BY #{orderField} #{orderMethod} LIMIT #{limit} OFFSET #{offset}")
    public static String buildGetTeachersPage(final Integer offset, final Integer limit, final String orderMethod, final String orderField) {
        return new SQL(){{
            SELECT("*");
            FROM("teachers");
            ORDER_BY(orderField);
            LIMIT(limit);
            OFFSET(offset);
        }}.toString();
    }
}
