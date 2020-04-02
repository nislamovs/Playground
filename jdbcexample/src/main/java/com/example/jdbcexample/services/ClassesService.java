package com.example.jdbcexample.services;

import com.example.jdbcexample.dao.SchoolClassDAO;
import com.example.jdbcexample.dto.SchoolClassDTO;
import com.example.jdbcexample.mappers.ClassMapper;
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
public class ClassesService {

    private final BasicDataSource dataSource;
    private final ClassMapper mapper;

    private final String CLASSES_RETRIEVAL_QUERY = "select * FROM classes";
    private final String CLASSES_PAGE_RETRIEVAL_QUERY = "select * FROM classes WHERE id BETWEEN ? AND ? order by ? ?";

    @SneakyThrows
    public List<SchoolClassDTO> getAllClasses() {

        @Cleanup Connection conn = getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(CLASSES_RETRIEVAL_QUERY);

        System.out.println(">>>   "+stmt.toString());

        return executeQuery(stmt).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @SneakyThrows
    public  List<SchoolClassDTO> getClassesPage(String pagenum, String pagesize, String sort, String group) {

        @Cleanup Connection conn = getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(CLASSES_PAGE_RETRIEVAL_QUERY);

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

    private List<SchoolClassDAO> executeQuery(PreparedStatement stmt) {
        List<SchoolClassDAO> classes = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SchoolClassDAO mark = SchoolClassDAO.builder()
                        .id(rs.getLong("id"))
                        .class_head_id(rs.getLong("class_head_id"))
                        .name(rs.getString("name"))
                        .type(rs.getString("type"))
                        .build();

                classes.add(mark);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return classes;
    }
}
