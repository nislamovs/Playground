package com.example.jdbcexample.services;

import com.example.jdbcexample.dao.SubjectDAO;
import com.example.jdbcexample.dto.SubjectDTO;
import com.example.jdbcexample.mappers.SubjectMapper;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectsService {

    private final BasicDataSource dataSource;
    private final SubjectMapper mapper;

    private final String SUBJECTS_RETRIEVAL_QUERY = "select * FROM subjects";
    private final String SUBJECTS_PAGE_RETRIEVAL_QUERY = "select * FROM subjects WHERE id BETWEEN ? AND ? order by ? ?";

    @SneakyThrows
    public List<SubjectDTO> getAllSubjects() {

        @Cleanup Connection conn = getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(SUBJECTS_RETRIEVAL_QUERY);

        System.out.println(">>>   "+stmt.toString());

        return executeQuery(stmt).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @SneakyThrows
    public  List<SubjectDTO> getSubjectsPage(String pagenum, String pagesize, String sort, String group) {

        @Cleanup Connection conn = getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(SUBJECTS_PAGE_RETRIEVAL_QUERY);

        int i = 1;
        stmt.setInt(i++, parseInt(pagesize) * parseInt(pagenum));
        stmt.setInt(i++, parseInt(pagesize) * parseInt(pagenum) + parseInt(pagesize));
        stmt.setString(i++, group);
        stmt.setString(i++, sort);

        System.out.println(">>>   "+stmt.toString());

        return executeQuery(stmt).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private List<SubjectDAO> executeQuery(PreparedStatement stmt) {
        List<SubjectDAO> subjects = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SubjectDAO subject = SubjectDAO.builder()
                        .id(rs.getLong("id"))
                        .teacher_id(rs.getLong("class_head_id"))
                        .name(rs.getString("class_id"))
                        .build();

                subjects.add(subject);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return subjects;
    }
}
