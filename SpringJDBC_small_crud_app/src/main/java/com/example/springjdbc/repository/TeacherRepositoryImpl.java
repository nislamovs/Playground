package com.example.springjdbc.repository;

import com.example.springjdbc.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TeacherRepositoryImpl implements TeacherRepository {

    public static final String QUERY_GET_ALL_TEACHERS = "SELECT * FROM teachers";
    public static final String QUERY_GET_TEACHER_BY_ID = "SELECT * FROM teachers WHERE id = ?";
    public static final String QUERY_GET_TEACHER_BY_EMAIL = "SELECT * FROM teachers WHERE email = :email";

    public static final String QUERY_INSERT_NEW_TEACHER = "INSERT INTO teachers (id, firstname, lastname, email, birthdate) "
                                                        + " VALUES (:id, :firstname, :lastname, :email, :birthdate); ";

    public static final String QUERY_UPDATE_TEACHER = "UPDATE teachers SET firstname = ?, lastname = ?, email = ?, birthdate = ?  WHERE id = ?";

    public static final String QUERY_DELETE_TEACHER_BY_ID = "DELETE FROM teachers WHERE id = ?";


    //order by not working for some reason - probably problem in h2
    public static final String QUERY_GET_TEACHERS_PAGE = "SELECT t.* FROM teachers t limit ? offset ?";


    
//    public static final String QUERY_GET_TEACHERS_PAGE = "SELECT * FROM teachers ORDER BY :field LIMIT :limit OFFSET :offset";
//    public static final String QUERY_GET_TEACHERS_PAGE = "SELECT * FROM teachers ORDER BY :field :sorting LIMIT :limit OFFSET :offset";
//    public static final String QUERY_GET_TEACHERS_PAGE = "SELECT * FROM teachers ORDER BY :field";

    private static final TeacherMapper teacherMapper = new TeacherMapper();
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Teacher> findAll() {
        return jdbcTemplate.query(QUERY_GET_ALL_TEACHERS, teacherMapper);
    }

    @Override
    public Teacher getTeacherByEmail(String email) {
        Teacher presetTeacher = Teacher.builder().email(email).build();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(presetTeacher);

        return namedParameterJdbcTemplate.queryForObject(QUERY_GET_TEACHER_BY_EMAIL, namedParameters, teacherMapper);
    }

    @Override
    public List<Teacher> findPage(Integer offset, Integer limit, String orderMethod, String orderField) {

        return jdbcTemplate.query(QUERY_GET_TEACHERS_PAGE, teacherMapper, limit, offset);       //order by not working for some reason - probably problem in h2
    }

    @Override
    public Teacher findById(Integer teacherId) {
        return jdbcTemplate.queryForObject(QUERY_GET_TEACHER_BY_ID, teacherMapper, teacherId);
    }

    @Override
    public int insert(Teacher teacher) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", teacher.getId());
        params.put("firstname", teacher.getFirstname());
        params.put("lastname", teacher.getLastname());
        params.put("email", teacher.getEmail());
        params.put("birthdate", teacher.getBirthdate());

        return namedParameterJdbcTemplate.update(QUERY_INSERT_NEW_TEACHER, params);
    }

    @Override
    public int update(Teacher teacher) {
        Object[] params = new Object[] {
                teacher.getFirstname(),
                teacher.getLastname(),
                teacher.getEmail(),
                teacher.getBirthdate(),
                teacher.getId()
        };

        return jdbcTemplate.update(QUERY_UPDATE_TEACHER, params);
    }

    @Override
    public int delete(Integer teacherId) {
        return jdbcTemplate.update(QUERY_DELETE_TEACHER_BY_ID, teacherId);
    }

    static final class TeacherMapper implements RowMapper<Teacher> {
        @Override
        public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");

            return Teacher.builder().id(rs.getInt(1))
                    .firstname(rs.getString(2))
                    .lastname(rs.getString(3))
                    .email(rs.getString(4))
                    .birthdate(LocalDate.parse(rs.getString(5), formatter))                 //getdate changed to getString to except error during marshalling date value from db to var
                    .build();
        }
    }
}
